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
                  "Boks", "BJJ", "Grappiling", "MMA", "Za Zene", "Za Decu", "Kondicional Trening", "Kickboks"
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
        // Sala 1 Classes
        classes.add("Grappling - Ponedeljak 7:30");
        classes.add("MMA Stand Up - Ponedeljak 9:30");
        classes.add("BJJ Za Decu (3-6) - Ponedeljak 18:30");
        classes.add("BJJ Za Decu (7-13) - Ponedeljak 19:30");
        classes.add("BJJ Za Odrasle- Ponedeljak 20:45");
        classes.add("Cardioboks za Zene - Ponedeljak 17:30");
        classes.add("Kickboks - Ponedeljak 18:30");
        classes.add("BJJ Za Decu (3-6) - Ponedeljak 18:30");
        classes.add("BJJ Za Odrasle - Ponedeljak 20:45");

        classes.add("Kondicionalni Trening - Utorak 17:30");
        classes.add("Boks za Odrasle - Utorak 18:30");
        classes.add("Funcialnost za Zene - Utorak 18:30");
        classes.add("BJJ Fundamentals - Utorak 20:45");
        classes.add("MMA Rvanje - Utorak 9:30");
        classes.add("Grappling - Utorak 18:00");
        classes.add("MMA - Utorak 20:45");

        classes.add("Grappling - Sreda 7:30");
        classes.add("MMA Stand Up - Sreda 9:30");
        classes.add("BJJ Za Decu (3-6) - Sreda 18:30");
        classes.add("BJJ Za Odrasle - Sreda 20:45");
        classes.add("Cardioboks za Zene - Sreda 17:30");
        classes.add("Kickboks - Sreda 18:30");
        classes.add("Boks Za Decu - Sreda 17:30");
        classes.add("MMA Basic - Sreda 20:30");


        classes.add("MMA Rvanje - Cetvrtak 9:30");
        classes.add("Grappling -  Cetvrtak 18:00");
        classes.add("MMA- Cetvrtak 20:45");
        classes.add("Kondicional Trening - Cetvrtak 17:30");
        classes.add("Boks - Cetvrtak 18:30");
        classes.add("Funcionalnost Za Zene - Cetvrtak 18:30");
        classes.add("BJJ Fundamentals - Cetvrtak 20:45");

        classes.add("Grappling - Petak 7:30");
        classes.add("MMA Stand Up - Petak 18:00");
        classes.add("BJJ Za Decu (3-6) - Petak 18:30");
        classes.add("BJJ Za Odrasle - Petak 20:45");
        classes.add("Cardio Kickboks - Petak 17:30");
        classes.add("Kickboks - Petak 18:30");
        classes.add("BJJ Za Decu (3-6) - Petak 19:30");
        classes.add("MMA Basic - Petak 20:35");

        classes.add("MMA Rvanje - Subota 12:00");
        classes.add("Grappiling - Subota 13:30");
        classes.add("Funcionalnost Za Zene- Subota 11:00");
        classes.add("BJJ Fundamentals - Subota 12:00");
        classes.add("Boks Za Odrasle - Subota 12:30");
        classes.add("Kondicional Trening - Subota 14:35");

        schedule.setLayoutManager(new LinearLayoutManager((this)));
        cardAdapter = new Adapter(this, classes);
        schedule.setAdapter(cardAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = spinner.getSelectedItem().toString();
                cardAdapter.getFilter().filter(text);
                cardAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}