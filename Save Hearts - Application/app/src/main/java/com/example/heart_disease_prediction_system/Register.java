package com.example.heart_disease_prediction_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText uFullName,uEmail,uPassword,uConfirmPassword;
    Button uRegisterButton;
    TextView uLoginButton;
    FirebaseAuth mAuth;
    FirebaseFirestore mStore;
    ProgressBar pBar;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uFullName = findViewById(R.id.FullName);
        uEmail = findViewById(R.id.Email);
        uPassword = findViewById(R.id.Password);
        uConfirmPassword = findViewById(R.id.Confirm_Password);
        uRegisterButton = findViewById(R.id.btnLogin);
        uLoginButton = findViewById(R.id.ViewLogBtn);
        mAuth = FirebaseAuth.getInstance();
        mStore=FirebaseFirestore.getInstance();
        pBar = findViewById(R.id.progressBar);


        if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));//user is already log,redirect to the main activity
            finish();
        }

        uRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=uFullName.getText().toString();
                String email = uEmail.getText().toString().trim();
                String password = uPassword.getText().toString().trim();
                String confirm_password = uConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    uEmail.setError("Email is Required!.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    uPassword.setError("Password is Required!.");
                    return;
                }
                if (TextUtils.isEmpty(confirm_password)) {
                    uConfirmPassword.setError("Confirm password is Required!.");
                    return;
                }
                if (!password.equals(confirm_password)) {
                    uPassword.setError("Please check the Password and Confirm Password");
                    return;
                }
                if (password.length()<6) {
                    uPassword.setError("Password must have minimum 6 characters");
                    return;
                }

                pBar.setVisibility(View.VISIBLE);

                //input data into firebase
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                            userID=mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = mStore.collection("users").document(userID);
                            Map<String,Object> user =new HashMap<>();
                            user.put("Name",name);
                            user.put("email",email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"onSuccess:User profile created for "+userID);
                                }
                            });

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        } else {
                            Toast.makeText(Register.this, "Error!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            pBar.setVisibility(View.GONE);

                        }

                    }
                });

                uLoginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Login.class));
                    }
                });

            }
        });
    }
}