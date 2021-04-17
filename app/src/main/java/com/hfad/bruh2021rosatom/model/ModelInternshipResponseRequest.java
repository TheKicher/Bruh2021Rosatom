package com.hfad.bruh2021rosatom.model;

import com.google.gson.annotations.SerializedName;


public class ModelInternshipResponseRequest {

    @SerializedName("user")
    private String user;
    @SerializedName("internship")
    private String internship;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getInternship() {
        return internship;
    }

    public void setInternship(String internship) {
        this.internship = internship;
    }
}
