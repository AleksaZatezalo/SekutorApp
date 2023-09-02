package com.example.sekutorakademijainfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class Calendar extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Sekutor Info");
        }

        spinner = findViewById(R.id.menu);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bot_menu);
        bottomNavigationView.setSelectedItemId(R.id.calendar);
        String[] arraySpinner = new String[] {
                "Sala 1", "Sala 2"
        };

        //Woo hoo
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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}