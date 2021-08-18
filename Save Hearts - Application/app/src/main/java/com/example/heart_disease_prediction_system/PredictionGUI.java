package com.example.heart_disease_prediction_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.heart_disease_prediction_system.api.ApiService;
import com.example.heart_disease_prediction_system.api.ApiServiceGenerator;
import com.example.heart_disease_prediction_system.databinding.ActivityPredictionGUIBinding;
import com.example.heart_disease_prediction_system.models.ApiRequest;
import com.example.heart_disease_prediction_system.models.ApiResponse;
import com.kusu.loadingbutton.LoadingButton;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PredictionGUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPredictionGUIBinding binding = ActivityPredictionGUIBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        LoadingButton button = binding.button;

        button.setOnClickListener(v -> {
            button.showLoading();

            String age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal, ear, eye, cheek;

            age = binding.age.getText().toString();
            sex = binding.sex.getText().toString();
            cp = binding.cp.getText().toString();
            trestbps = binding.trestbps.getText().toString();
            chol = binding.chol.getText().toString();
            fbs = binding.fbs.getText().toString();
            restecg = binding.restecg.getText().toString();
            thalach = binding.thalach.getText().toString();
            exang = binding.exang.getText().toString();
            oldpeak = binding.oldpeak.getText().toString();
            slope = binding.slope.getText().toString();
            ca = binding.ca.getText().toString();
            thal = binding.thal.getText().toString();
            ear = binding.ear.getText().toString();
            eye = binding.eye.getText().toString();
            cheek = binding.cheek.getText().toString();

            if (age.isEmpty() || sex.isEmpty() || cp.isEmpty() || trestbps.isEmpty() || chol.isEmpty() || fbs.isEmpty() || restecg.isEmpty() || thalach.isEmpty() || exang.isEmpty() || oldpeak.isEmpty() || slope.isEmpty() || ca.isEmpty() || thal.isEmpty() || ear.isEmpty() || eye.isEmpty() || cheek.isEmpty()) {
                button.hideLoading();
                Toast.makeText(getApplicationContext(), "Fill all required fields.", Toast.LENGTH_SHORT).show();
            } else {
                ApiService service = ApiServiceGenerator.createService(ApiService.class);

                ApiRequest apiRequest = new ApiRequest();

                apiRequest.setAge(age);
                apiRequest.setSex(sex);
                apiRequest.setCp(cp);
                apiRequest.setTrestbps(trestbps);
                apiRequest.setChol(chol);
                apiRequest.setFbs(fbs);
                apiRequest.setRestecg(restecg);
                apiRequest.setThalach(thalach);
                apiRequest.setExang(exang);
                apiRequest.setOldpeak(oldpeak);
                apiRequest.setSlope(slope);
                apiRequest.setCa(ca);
                apiRequest.setThal(thal);
                apiRequest.setEar(ear);
                apiRequest.setEye(eye);
                apiRequest.setCheek(cheek);

                Call<ApiResponse> call = service.postData(apiRequest);

                call.enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<ApiResponse> call, @NotNull Response<ApiResponse> response) {
                        button.hideLoading();
                        if (response.code() == 201) {
                            new AlertDialog.Builder(PredictionGUI.this)
                                    .setTitle("Result")
                                    .setMessage("Prediction : " + response.body().getPrediction() + "%")
                                    .setPositiveButton("Ok", (dialog, which) -> {
                                        dialog.dismiss();
                                    })
                                    .show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<ApiResponse> call, @NotNull Throwable t) {
                        button.hideLoading();
                        Toast.makeText(getApplicationContext(), "Error.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    public void Main(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}