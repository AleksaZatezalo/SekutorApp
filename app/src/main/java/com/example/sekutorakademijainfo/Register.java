package com.example.sekutorakademijainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    EditText editTextEmail, editTextName, editTextPassword;
    Button buttonReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonReg = findViewById(R.id.Register);

        buttonReg.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, name, password;
                email = String.valueOf(editTextEmail.getText());
                name = String.valueOf(editTextName.getText());
                password  = String.valueOf(editTextPassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this, "Enter email", Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(Register.this, "Enter name", Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "Enter password", Toast.LENGTH_SHORT);
                    return;
                }
            }

        }));
    }
}