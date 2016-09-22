package com.example.master.vktestapp;

import retrofit2.Retrofit;

public class Api {

    public static String BASE_URL = "https://api.vk.com/method/";

    public static Retrofit getClient() {
        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .build();
    }
}
