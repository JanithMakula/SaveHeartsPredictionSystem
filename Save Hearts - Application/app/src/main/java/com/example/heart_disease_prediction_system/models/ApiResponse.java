package com.example.heart_disease_prediction_system.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ApiResponse implements Serializable {
    @SerializedName("prediction")
    @Expose
    private String prediction;

    public ApiResponse() {
    }

    public ApiResponse(String prediction) {
        this.prediction = prediction;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "prediction='" + prediction + '\'' +
                '}';
    }
}
