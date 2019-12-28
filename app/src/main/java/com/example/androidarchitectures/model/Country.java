package com.example.androidarchitectures.model;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
