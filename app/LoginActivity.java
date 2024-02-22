package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText password, username;
    Button login;
    CheckBox showpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.LogInbuttonID);
        username = findViewById(R.id.usernameID);
        password = findViewById(R.id.passwordID);
        showpassword = findViewById(R.id.eyeID);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin")&&
                   password.getText().toString().equals("admin")){
                    Intent homeIntent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}
