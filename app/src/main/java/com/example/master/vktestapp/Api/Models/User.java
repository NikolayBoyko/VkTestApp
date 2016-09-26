package com.example.master.vktestapp.Api.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("id")
    private String mId;

    @JsonProperty("first_name")
    private String mFirstName;

    @JsonProperty("last_name")
    private String mLastName;

    @JsonProperty("bdate")
    private String bDate;

    public String getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getBdate() {
        return bDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "mId='" + mId + '\'' +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", bDate='" + bDate + '\'' +
                '}';
    }
}