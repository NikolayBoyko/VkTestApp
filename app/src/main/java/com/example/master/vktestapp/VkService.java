package com.example.master.vktestapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VkService {

    //?user_ids=210700286&fields=bdate&v=5.53
   /* @Query("user_ids") String userId,
    @Query("fields") String fields,
    @Query("v") String version*/

    @GET("users.get?user_ids=210700286&fields=bdate&v=5.53")
    Call<ResponseVk> getUser();
}
