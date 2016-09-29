package com.example.master.vktestapp.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.master.vktestapp.Api.Api;
import com.example.master.vktestapp.Api.ResponseAudio;
import com.example.master.vktestapp.Api.ResponseVk;
import com.example.master.vktestapp.Api.VkService;
import com.example.master.vktestapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    VkService service = Api.getClient().create(VkService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

    }

    public void getUser() {
        Call<ResponseVk> responseVkCall = service.getUser("133508072", "bdate", "5.53");
        responseVkCall.enqueue(new Callback<ResponseVk>() {
            @Override
            public void onResponse(Call<ResponseVk> call, Response<ResponseVk> response) {
                Log.d("TAG", "onResponse" + response.body().getListUser().toString());
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseVk> call, Throwable t) {
                Log.d("TAG", "onFailure" + t);
            }
        });
    }

    public void getAudio() {
        Call<ResponseAudio> responseAudioVkCall = service.getAudio("133508072", "3", " ТОКЕН  ", "5.53");
        responseAudioVkCall.enqueue(new Callback<ResponseAudio>() {
            @Override
            public void onResponse(Call<ResponseAudio> call, Response<ResponseAudio> response) {
                Log.d("TAG", "onResponse responseAudioVkCall " + response.body().getResponse().getAudioList().get(0).getArtist());
            }

            @Override
            public void onFailure(Call<ResponseAudio> call, Throwable t) {
                Log.d("TAG", "onFailure responseAudioVkCall " + t);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.user:
                Toast.makeText(this, "Click on Android", Toast.LENGTH_SHORT).show();
                break;

            case R.id.audioList:
                Toast.makeText(this, "Click on Java", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                Toast.makeText(this, "Click on Settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.about:
                Toast.makeText(this, "Click on About", Toast.LENGTH_SHORT).show();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else super.onBackPressed();
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_content, fragment).commit();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_content, fragment).commit();
    }

    /* textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        mToken = intent.getStringExtra("token");
        textView.setText("\n" + "TOKEN: " + intent.getStringExtra("token"));

        Log.d("TAG", "TOKEN  " + mToken);*/
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