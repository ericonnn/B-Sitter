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
import android.widget.Toast;

import com.example.b_sitter.Model.ModelMajikan;
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

public class DaftarMajikan extends AppCompatActivity {

    EditText namaMajikan, emailMajikan, pwdMajikan, noTelpMajikan, kotaMajikan, provinsiMajikan, alamatMajikan, kodePosMajikan;
    ImageView fotoMajikan;
    public Uri imgUriMajikan;
    String picture = "profilePictureMajikan/";
    Button signUp;
    String uid;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    FirebaseAuth firebaseAuth;

    private void Filechooser() {
        //untuk pilih gambar
        Intent fProfilMajikan = new Intent();
        fProfilMajikan.setType("image/'");
        fProfilMajikan.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(fProfilMajikan, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            //untuk set gambar di imageview
            imgUriMajikan = data.getData();
            fotoMajikan.setImageURI(imgUriMajikan);
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
        setContentView(R.layout.activity_daftar_majikan);
        namaMajikan = findViewById(R.id.dNamaMajikan);
        emailMajikan = findViewById(R.id.dEmailMajikan);
        pwdMajikan = findViewById(R.id.dPwdMajikan);
        noTelpMajikan = findViewById(R.id.dNoTelpMajikan);
        kotaMajikan = findViewById(R.id.dKotaMajikan);
        provinsiMajikan = findViewById(R.id.dProvinsiMajikan);
        alamatMajikan = findViewById(R.id.dAlamatMajikan);
        kodePosMajikan = findViewById(R.id.dKodePosMajikan);
        fotoMajikan = findViewById(R.id.dFotoMajikan);
        signUp = findViewById(R.id.buttonSignUp);
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference("Foto Profil");
        firebaseAuth = FirebaseAuth.getInstance();
        fotoMajikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //untuk buat folder baru+upload foto
                final StorageReference ref = storageReference.child(picture + System.currentTimeMillis() + "." + getExtension(imgUriMajikan));
                //buat user baru
                firebaseAuth.createUserWithEmailAndPassword(emailMajikan.getText().toString(),pwdMajikan.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            uid = firebaseAuth.getCurrentUser().getUid();
                            ModelMajikan modelMajikan = new ModelMajikan(
                                    namaMajikan.getText().toString(),
                                    emailMajikan.getText().toString(),
                                    pwdMajikan.getText().toString(),
                                    noTelpMajikan.getText().toString(),
                                    kotaMajikan.getText().toString(),
                                    provinsiMajikan.getText().toString(),
                                    alamatMajikan.getText().toString(),
                                    kodePosMajikan.getText().toString(),
                                    "Majikan"
                            );
                            //buat database
                            firebaseFirestore.collection("Data").document(uid).set(modelMajikan);
                            //upload foto ke database
                            ref.putFile(imgUriMajikan).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
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
                            Toast.makeText(DaftarMajikan.this, "Halo Selamat Datang!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(DaftarMajikan.this,MainActivity.class);
                            startActivity(i);

                        }
                    }
                });
            }
        });
    }
}
