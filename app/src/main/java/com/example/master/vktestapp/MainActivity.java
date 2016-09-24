package com.example.master.vktestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        textView.setText("\n" + "TOKEN: "+intent.getStringExtra("token"));


        VkService service = Api.getClient().create(VkService.class);
        Call<ResponseVk> responseVkCall = service.getUser("133508072", "bdate", "5.53");

        responseVkCall.enqueue(new Callback<ResponseVk>() {
            @Override
            public void onResponse(Call<ResponseVk> call, Response<ResponseVk> response) {
                Log.d("getListUser", "onResponse" + response.body().getListUser().toString());
                id.setText("\n" + "ID: " + response.body().getListUser().get(0).getId());
                firstName.setText("\n" + "Name: " + response.body().getListUser().get(0).getFirstName());
                lastName.setText("\n" + "Second Name: " + response.body().getListUser().get(0).getLastName());
                bDate.setText("\n" + "birthday: " + response.body().getListUser().get(0).getBdate());
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






