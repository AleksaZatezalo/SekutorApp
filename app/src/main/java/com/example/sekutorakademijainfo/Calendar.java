package com.example.sekutorakademijainfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
        bottomNavigationView.setSelectedItemId(R.id.calendar);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.calendar:
                       return true;
                   case R.id.home:
                       startActivity(new Intent(getApplicationContext(), Home.class));
                       overridePendingTransition(0,0);
                       return true;
               }
               return false;
           }
       }
        );

    }
}