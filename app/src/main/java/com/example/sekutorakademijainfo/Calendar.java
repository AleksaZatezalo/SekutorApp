package com.example.sekutorakademijainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Calendar extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Calendar");
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bot_menu);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
}