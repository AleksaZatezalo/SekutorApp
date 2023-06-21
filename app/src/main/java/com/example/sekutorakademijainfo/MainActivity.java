package com.example.sekutorakademijainfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin, buttonReg;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView resetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonReg = findViewById(R.id.Register);
        buttonLogin = findViewById(R.id.Login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        resetPass = findViewById(R.id.ForgotPassword);

        resetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
            }
        });
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password  = String.valueOf(editTextPassword.getText());
                mAuth = FirebaseAuth.getInstance();

                if (TextUtils.isEmpty(email) & TextUtils.isEmpty(password)){
                    editTextEmail.setError("Enter your email.");
                    editTextPassword.setError("Enter your password.");
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    editTextEmail.setError("Enter your email.");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    editTextPassword.setError("Enter your password.");
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, "Authentication failed",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    try {
                                        Thread.sleep(150);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    progressBar.setVisibility(View.GONE);
                                    Intent intent = new Intent(getApplicationContext(), Home.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}