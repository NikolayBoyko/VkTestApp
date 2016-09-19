package com.example.master.vktestapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

public class StartActivity extends Activity {

    private String myToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        myToken = getmToken("KEY", getBaseContext());
        Log.d("TAG", "StartActivity onCreate " + myToken);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (myToken != null && !TextUtils.equals("", myToken)) {
                    startActivity(new Intent(StartActivity.this, MainActivity.class));
                    Log.d("TAG", "Start MainActivity ");
                    finish();

                } else {
                    startActivity(new Intent(StartActivity.this, LoginActivity.class));
                    Log.d("TAG", "Start LoginActivity ");
                    finish();
                }
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "StartActivity onDestroy()");
    }

    public String getmToken(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}
