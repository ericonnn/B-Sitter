package com.example.b_sitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.b_sitter.ui.login.LoginActivity;

public class HalamanAwalActivity extends AppCompatActivity {
    Button majikanButton, penyalurButton;
    TextView signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_awal);
        majikanButton = findViewById(R.id.buttonSignUpMajikan);
        penyalurButton = findViewById(R.id.buttonSignUpPenyalur);
        signIn = findViewById(R.id.directSignIn);

        majikanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HalamanAwalActivity.this, DaftarMajikan.class);
                startActivity(i);
            }
        });

        penyalurButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HalamanAwalActivity.this, DaftarPenyalur.class);
                startActivity(i);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HalamanAwalActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
