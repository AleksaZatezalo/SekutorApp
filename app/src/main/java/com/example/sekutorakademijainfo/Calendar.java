package com.example.sekutorakademijainfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Calendar extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Spinner spinner;
    RecyclerView schedule;
    Adapter cardAdapter;
    ArrayList<String> classes;
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
                "Brazilian Jiu Jitsu", "Stand Up Box"
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
        schedule = findViewById(R.id.schedule);

        // Adding Items to Card View
        classes = new ArrayList<>();
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Funday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        classes.add("Brazilian Jiu Jitsu - Sunday 18:00");
        schedule.setLayoutManager(new LinearLayoutManager((this)));
        cardAdapter = new Adapter(this, classes);
        schedule.setAdapter(cardAdapter);
    }
}