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

    private String mToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        mToken = getmToken("KEY", this);
        Log.d("TAG", "StartActivity onCreate " + mToken);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (mToken != null && !TextUtils.equals("", mToken)) {
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    intent.putExtra("token", mToken);
                    startActivity(intent);
                    finish();

                } else {
                    startActivity(new Intent(StartActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }, 2000);
    }

    public String getmToken(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}
