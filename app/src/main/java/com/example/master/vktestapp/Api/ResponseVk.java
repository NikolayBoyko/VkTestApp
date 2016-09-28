package com.example.master.vktestapp.Api;

import com.example.master.vktestapp.Api.Models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseVk {

    @JsonProperty("response")
    List<User> mListUser;

    public List<User> getListUser() {
        return mListUser;
    }

    @Override
    public String toString() {
        return "ResponseVk{" +
                "mListUser=" + mListUser +
                '}';
    }
}
