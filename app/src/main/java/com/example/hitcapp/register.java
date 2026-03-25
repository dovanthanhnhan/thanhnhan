package com.example.hitcapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    EditText objPhone, objPass, objConfirmPass;
    Button btnRegister, btnBack;

    SharedPreferences sharedPreferences;
    static final String PREFS_NAME = "MyPrefs";
    static final String KEY_PHONE = "phone";
    static final String KEY_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        objPhone = findViewById(R.id.txtPhone);
        objPass = findViewById(R.id.txtPass);
        objConfirmPass = findViewById(R.id.txtConfirmPass);
        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        btnRegister.setOnClickListener(v -> {
            String sPhone = objPhone.getText().toString();
            String sPass = objPass.getText().toString();
            String sConfirmPass = objConfirmPass.getText().toString();

            if(sPhone.isEmpty() || sPass.isEmpty() || sConfirmPass.isEmpty()) {
                Toast.makeText(register.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!sPass.equals(sConfirmPass)) {
                Toast.makeText(register.this, "Mật khẩu xác nhận không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_PHONE, sPhone);
            editor.putString(KEY_PASS, sPass);
            editor.apply();

            Toast.makeText(register.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

            Intent it = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it);
            finish();
        });

        btnBack.setOnClickListener(v -> {
            Intent it = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it);
            finish();
        });
    }
}