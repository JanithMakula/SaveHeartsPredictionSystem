package com.example.heart_disease_prediction_system.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ApiRequest implements Serializable {
    @SerializedName("age")
    @Expose
    String age;
    @SerializedName("sex")
    @Expose
    String sex;
    @SerializedName("cp")
    @Expose
    String cp;
    @SerializedName("trestbps")
    @Expose
    String trestbps;
    @SerializedName("chol")
    @Expose
    String chol;
    @SerializedName("fbs")
    @Expose
    String fbs;
    @SerializedName("restecg")
    @Expose
    String restecg;
    @SerializedName("thalach")
    @Expose
    String thalach;
    @SerializedName("exang")
    @Expose
    String exang;
    @SerializedName("oldpeak")
    @Expose
    String oldpeak;
    @SerializedName("slope")
    @Expose
    String slope;
    @SerializedName("ca")
    @Expose
    String ca;
    @SerializedName("thal")
    @Expose
    String thal;
    @SerializedName("ear")
    @Expose
    String ear;
    @SerializedName("eye")
    @Expose
    String eye;
    @SerializedName("cheek")
    @Expose
    String cheek;

    public ApiRequest() {
    }

    public ApiRequest(String age, String sex, String cp, String trestbps, String chol, String fbs, String restecg, String thalach, String exang, String oldpeak, String slope, String ca, String thal, String ear, String eye, String cheek) {
        this.age = age;
        this.sex = sex;
        this.cp = cp;
        this.trestbps = trestbps;
        this.chol = chol;
        this.fbs = fbs;
        this.restecg = restecg;
        this.thalach = thalach;
        this.exang = exang;
        this.oldpeak = oldpeak;
        this.slope = slope;
        this.ca = ca;
        this.thal = thal;
        this.ear = ear;
        this.eye = eye;
        this.cheek = cheek;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTrestbps() {
        return trestbps;
    }

    public void setTrestbps(String trestbps) {
        this.trestbps = trestbps;
    }

    public String getChol() {
        return chol;
    }

    public void setChol(String chol) {
        this.chol = chol;
    }

    public String getFbs() {
        return fbs;
    }

    public void setFbs(String fbs) {
        this.fbs = fbs;
    }

    public String getRestecg() {
        return restecg;
    }

    public void setRestecg(String restecg) {
        this.restecg = restecg;
    }

    public String getThalach() {
        return thalach;
    }

    public void setThalach(String thalach) {
        this.thalach = thalach;
    }

    public String getExang() {
        return exang;
    }

    public void setExang(String exang) {
        this.exang = exang;
    }

    public String getOldpeak() {
        return oldpeak;
    }

    public void setOldpeak(String oldpeak) {
        this.oldpeak = oldpeak;
    }

    public String getSlope() {
        return slope;
    }

    public void setSlope(String slope) {
        this.slope = slope;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getThal() {
        return thal;
    }

    public void setThal(String thal) {
        this.thal = thal;
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getCheek() {
        return cheek;
    }

    public void setCheek(String cheek) {
        this.cheek = cheek;
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", cp='" + cp + '\'' +
                ", trestbps='" + trestbps + '\'' +
                ", chol='" + chol + '\'' +
                ", fbs='" + fbs + '\'' +
                ", restecg='" + restecg + '\'' +
                ", thalach='" + thalach + '\'' +
                ", exang='" + exang + '\'' +
                ", oldpeak='" + oldpeak + '\'' +
                ", slope='" + slope + '\'' +
                ", ca='" + ca + '\'' +
                ", thal='" + thal + '\'' +
                ", ear='" + ear + '\'' +
                ", eye='" + eye + '\'' +
                ", cheek='" + cheek + '\'' +
                '}';
    }
}
