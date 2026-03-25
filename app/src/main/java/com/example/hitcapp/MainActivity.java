package com.example.hitcapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText objPhone, objPass;
    Button btnLogin, btnRegister;

    SharedPreferences sharedPreferences;
    static final String PREFS_NAME = "MyPrefs";
    static final String KEY_PHONE = "phone";
    static final String KEY_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objPhone = findViewById(R.id.txtPhone);
        objPass = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> {
            String sPhone = objPhone.getText().toString();
            String sPass = objPass.getText().toString();

            String savedPhone = sharedPreferences.getString(KEY_PHONE, "");
            String savedPass = sharedPreferences.getString(KEY_PASS, "");

            if (sPhone.equals(savedPhone) && sPass.equals(savedPass)) {
                Intent it = new Intent(getApplicationContext(), home.class);
                startActivity(it);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Sai số điện thoại hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(v -> {
            Intent it = new Intent(getApplicationContext(), register.class);
            startActivity(it);
        });
    }
}