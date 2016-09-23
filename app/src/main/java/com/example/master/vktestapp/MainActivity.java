package com.example.master.vktestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView id;
    private TextView firstName;
    private TextView lastName;
    private TextView bDate;

    //private String BASE_URL = "https://api.vk.com/method/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        id = (TextView) findViewById(R.id.id);
        firstName = (TextView) findViewById(R.id.firstName);
        lastName = (TextView) findViewById(R.id.secondName);
        bDate = (TextView) findViewById(R.id.bdate);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("token"));



        VkService service = Api.getClient().create(VkService.class);
        retrofit2.Call<ResponseVk> responseVkCall = service.getUser();

        responseVkCall.enqueue(new retrofit2.Callback<ResponseVk>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseVk> call, retrofit2.Response<ResponseVk> response) {
                Log.d("getListUser", "onResponse" + response.body().getListUser().get(0).toString());
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseVk> call, Throwable t) {
                Log.d("getListUser", "onFailure" + t);
            }
        });

       /* GetExample example = new GetExample();
        example.execute();*/
    }
}

/*class GetExample extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.vk.com/method/users.get?user_ids=210700286&fields=bdate&v=5.53")
                    .build();

            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String jsonData = response.body().string();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/






