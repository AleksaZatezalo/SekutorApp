package com.example.sekutorakademijainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Calendar");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }
}