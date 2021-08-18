package com.example.heart_disease_prediction_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SearchMedicalHouseGUI extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_medical_house_g_u_i);
    }
    public void Main(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));//Redirect to the user management class after clicking back button
        finish();
    }

}