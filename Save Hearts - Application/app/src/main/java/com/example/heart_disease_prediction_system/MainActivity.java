package com.example.heart_disease_prediction_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.heart_disease_prediction_system.api.ApiServiceGenerator;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiServiceGenerator.setup();
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));//Redirect to the login class
        finish();
    }

    public void userManagement(View view) {
        startActivity(new Intent(getApplicationContext(),UserProfileManagement.class));//Redirect to the user management class
        finish();
    }
    public void Prediction(View view) {
        startActivity(new Intent(getApplicationContext(),PredictionGUI.class));//Redirect to the user management class
        finish();
    }
    public void FindDoctor(View view) {
        startActivity(new Intent(getApplicationContext(),FindDoctorGUI.class));//Redirect to the user management class
        finish();
    }
    public void SerachMedical(View view) {
        startActivity(new Intent(getApplicationContext(),SearchMedicalHouseGUI.class));//Redirect to the user management class
        finish();
    }
    public void Report(View view) {
        startActivity(new Intent(getApplicationContext(),ReportGUI.class));//Redirect to the user management class
        finish();
    }
}