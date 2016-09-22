package com.example.master.vktestapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VkService {

    /*@GET("method/users.get?user_ids=210700286&fields=bdate&v=5.53")
    void getUser(Callback<User> user);*/

   /* @GET("users.get?user_ids=210700286&fields=bdate&v=5.53")
    Call<ResponseVk> getUser();*/


    @GET("users.get")
    Call<ResponseVk> getUser(@Query("user_ids") String userId,
                             @Query("fields") String fields,
                             @Query("v") String version);
}
