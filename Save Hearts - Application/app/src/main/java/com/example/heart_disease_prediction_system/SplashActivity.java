package com.example.heart_disease_prediction_system;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Intent intent;
        if (firebaseUser != null) {
            intent = new Intent(getApplicationContext(), MainActivity.class);
        } else {
            intent = new Intent(getApplicationContext(), Login.class);
        }
        startActivity(intent);
        finish();
    }
}