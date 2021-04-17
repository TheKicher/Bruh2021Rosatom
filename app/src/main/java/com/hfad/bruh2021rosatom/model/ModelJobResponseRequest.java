package com.hfad.bruh2021rosatom.model;


import com.google.gson.annotations.SerializedName;

public class ModelJobResponseRequest {

    @SerializedName("user")
    private String user;
    @SerializedName("job")
    private String job;
    @SerializedName("letter")
    private String letter;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
