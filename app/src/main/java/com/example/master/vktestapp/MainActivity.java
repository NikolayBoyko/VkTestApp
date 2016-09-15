package com.example.master.vktestapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        assert textView !=null;
        textView.setText(LoginActivity.mToken);
       /* GetExample example = new GetExample();
        example.execute();*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

class GetExample extends AsyncTask<String, String, String> {

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
    }

}




