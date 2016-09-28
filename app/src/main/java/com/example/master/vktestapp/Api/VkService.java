package com.example.master.vktestapp.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VkService {

    @GET("users.get")
    Call<ResponseVk> getUser(@Query("user_ids") String userId,
                             @Query("fields") String fields,
                             @Query("v") String version);

    @GET("audio.get")
    Call<ResponseAudio> getAudio(@Query("owner_id") String owner_id,
                                 @Query("count") String count,
                                 @Query("access_token") String access_token,
                                 @Query("v") String version);

    //https://api.vk.com/method/audio.get?owner_id=133508072&count=1t&access_token=ca9d4dd02cee3d0772f7b797ff903c1358fd549f3927b3ce13b17b4d8b48e2f47986a95f8e60b54838cb3&v=5.53
}
