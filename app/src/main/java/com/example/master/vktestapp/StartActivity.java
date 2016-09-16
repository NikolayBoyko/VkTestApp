package com.example.master.vktestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

public class StartActivity extends Activity {

    final String SAVED_TEXT = "saved_text";
    private String xui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        xui = MyWebView.getmToken(SAVED_TEXT, getBaseContext());
        Log.d("TAG", "StartActivity onCreate " + xui);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (xui != null && !TextUtils.equals("", xui)) {
                    finish();
                    startActivity(new Intent(StartActivity.this, MainActivity.class));

                } else {
                    finish();
                    startActivity(new Intent(StartActivity.this, LoginActivity.class));
                }
            }
        }, 2000);
    }
}
