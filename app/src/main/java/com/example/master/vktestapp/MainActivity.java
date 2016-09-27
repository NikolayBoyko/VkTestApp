package com.example.master.vktestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.master.vktestapp.Api.Api;
import com.example.master.vktestapp.Api.VkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView id;
    private TextView firstName;
    private TextView lastName;
    private TextView bDate;
    private TextView mAudio;
    private String mToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        id = (TextView) findViewById(R.id.id);
        firstName = (TextView) findViewById(R.id.firstName);
        lastName = (TextView) findViewById(R.id.secondName);
        bDate = (TextView) findViewById(R.id.bdate);
        mAudio = (TextView) findViewById(R.id.mAudio);


        Intent intent = getIntent();
        mToken = intent.getStringExtra("token");
        textView.setText("\n" + "TOKEN: " + intent.getStringExtra("token"));
        Log.d("TAG", "TOKEN  " + mToken);


        VkService service = Api.getClient().create(VkService.class);
        Call<ResponseVk> responseVkCall = service.getUser("133508072", "bdate", "5.53");

        responseVkCall.enqueue(new Callback<ResponseVk>() {
            @Override
            public void onResponse(Call<ResponseVk> call, Response<ResponseVk> response) {
                Log.d("TAG", "onResponse" + response.body().getListUser().toString());
                id.setText( "ID: " + response.body().getListUser().get(0).getId());
                firstName.setText("Name: " + response.body().getListUser().get(0).getFirstName());
                lastName.setText("Second Name: " + response.body().getListUser().get(0).getLastName());
                bDate.setText("birthday: " + response.body().getListUser().get(0).getBdate());
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseVk> call, Throwable t) {
                Log.d("TAG", "onFailure" + t);
            }
        });

       /* Call<ResponseAudioVk> responseAudioVkCall = service.getAudio("133508072", "1", mToken, "5.53");
        responseAudioVkCall.enqueue(new Callback<ResponseAudioVk>() {
            @Override
            public void onResponse(Call<ResponseAudioVk> call, Response<ResponseAudioVk> response) {
                Log.d("TAG", "onResponse responseAudioVkCall " + response.body().getAudioList().get(0).toString());
                mAudio.setText("\n" +"on/Response responseAudioVkCall " + response.body().getCount());
            }

            @Override
            public void onFailure(Call<ResponseAudioVk> call, Throwable t) {
                Log.d("TAG", "onFailure responseAudioVkCall" + t);
            }
        });*/

        /*GetExample example = new GetExample();
        example.execute();*/
    }
}

/*class GetExample extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.vk.com/method/audio.get?owner_id=133508072&count=1t&access_token=ca9d4dd02cee3d0772f7b797ff903c1358fd549f3927b3ce13b17b4d8b48e2f47986a95f8e60b54838cb3&v=5.53")
                    .build();

            Call call = (Call) okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d("TAG", "onFailure responseAudioVkCall" + e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String jsonData = response.body().string();
                    Log.d("TAG", "onResponse responseAudioVkCall" + jsonData);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/







