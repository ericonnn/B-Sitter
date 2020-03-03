package com.example.b_sitter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.b_sitter.Model.ModelMajikan;
import com.example.b_sitter.Model.ModelPenyalur;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class DaftarPenyalur extends AppCompatActivity {
    EditText namaPenyalur, emailPenyalur, pwdPenyalur, noTelpPenyalur, kotaPenyalur, provinsiPenyalur, alamatPenyalur, kodePosPenyalur, namaPerusahaan;
    ImageView fotoPenyalur;
    public Uri imgUriPenyalur;
    String picture = "profilePicturePenyalur/";
    Button signUp;
    String uid;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    FirebaseAuth firebaseAuth;


    private void Filechooser() {
        Intent fProfilMajikan = new Intent();
        fProfilMajikan.setType("image/'");
        fProfilMajikan.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(fProfilMajikan, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imgUriPenyalur = data.getData();
            fotoPenyalur.setImageURI(imgUriPenyalur);
        }
    };
    private String getExtension(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_penyalur);
        namaPenyalur = findViewById(R.id.dNamaPenyalur);
        emailPenyalur = findViewById(R.id.dEmailPenyalur);
        pwdPenyalur = findViewById(R.id.dPwdPenyalur);
        noTelpPenyalur = findViewById(R.id.dNoTelpPenyalur);
        kotaPenyalur = findViewById(R.id.dKotaPenyalur);
        provinsiPenyalur = findViewById(R.id.dProvinsiPenyalur);
        alamatPenyalur = findViewById(R.id.dAlamatPenyalur);
        kodePosPenyalur = findViewById(R.id.dKodePosPenyalur);
        fotoPenyalur = findViewById(R.id.dFotoPenyalur);
        namaPerusahaan = findViewById(R.id.dNamaPerusahaan);
        signUp = findViewById(R.id.buttonSignUp);
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference("Foto Profil");
        firebaseAuth = FirebaseAuth.getInstance();
        fotoPenyalur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final StorageReference ref = storageReference.child(picture + System.currentTimeMillis() + "." + getExtension(imgUriPenyalur));

                firebaseAuth.createUserWithEmailAndPassword(emailPenyalur.getText().toString(),pwdPenyalur.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            uid = firebaseAuth.getCurrentUser().getUid();
                            ModelPenyalur modelPenyalur = new ModelPenyalur(
                                    namaPenyalur.getText().toString(),
                                    emailPenyalur.getText().toString(),
                                    pwdPenyalur.getText().toString(),
                                    noTelpPenyalur.getText().toString(),
                                    kotaPenyalur.getText().toString(),
                                    provinsiPenyalur.getText().toString(),
                                    alamatPenyalur.getText().toString(),
                                    kodePosPenyalur.getText().toString(),
                                    namaPerusahaan.getText().toString(),
                                    "Penyalur"
                            );
                            firebaseFirestore.collection("Data").document(uid).set(modelPenyalur);
                            ref.putFile(imgUriPenyalur).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            String url = uri.toString();
                                            Map<String, Object> userMap = new HashMap<>();
                                            userMap.put("fotoProfilMajikanId", url);

                                            firebaseFirestore.collection("Data").document(uid).set(userMap, SetOptions.merge());
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                            Toast.makeText(DaftarPenyalur.this, "Halo Selamat Datang!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(DaftarPenyalur.this,MainActivity.class);
                            startActivity(i);

                        }
                    }
                });
            }
        });
    }
}
