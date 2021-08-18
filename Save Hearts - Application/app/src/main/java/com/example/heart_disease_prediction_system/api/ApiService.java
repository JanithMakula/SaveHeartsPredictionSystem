package com.example.heart_disease_prediction_system.api;

import com.example.heart_disease_prediction_system.models.ApiRequest;
import com.example.heart_disease_prediction_system.models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("app/getpredict")
    public Call<ApiResponse> postData(@Body ApiRequest request);
}
