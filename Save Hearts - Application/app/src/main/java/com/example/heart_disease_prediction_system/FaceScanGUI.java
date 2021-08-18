package com.example.heart_disease_prediction_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FaceScanGUI extends AppCompatActivity {

    public static final int CAMERA_CODE = 101;
    ImageView selectedImage;
    Button btncamera,btngallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_scan_g_u_i);

        selectedImage = findViewById(R.id.imageView);
        btncamera = findViewById(R.id.btncamera);
        btngallery=findViewById(R.id.btngallery);

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FaceScanGUI.this, "Camera button is clicked", Toast.LENGTH_SHORT).show();//to show the message
            }
        });

        btngallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FaceScanGUI.this, "Gallery button is clicked", Toast.LENGTH_SHORT).show();//to show the message
                askCameraPermission();
            }
        });
    }

    private void askCameraPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_CODE);
        }else{
              openCamera();
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_CODE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED);
                openCamera();
        }else{
            Toast.makeText(FaceScanGUI.this, "Camera Permission is required.", Toast.LENGTH_SHORT).show();
        }
    }

    private void openCamera() {
        Toast.makeText(this, "Open Camera", Toast.LENGTH_SHORT).show();

    }

    public void Back(View view) {
        startActivity(new Intent(getApplicationContext(),PredictionGUI.class));//Redirect to the user management class
        finish();
    }
}