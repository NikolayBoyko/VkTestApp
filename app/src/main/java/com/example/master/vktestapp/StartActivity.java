package com.example.master.vktestapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.content.Intent;

public class StartActivity extends Activity {

    private SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        LoginActivity.mToken = loadText();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (LoginActivity.mToken != null && !TextUtils.equals("", LoginActivity.mToken)) {
                    startActivity(new Intent(StartActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(StartActivity.this, LoginActivity.class));
                }
            }
        }, 3000);
    }

    String loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        return sPref.getString(SAVED_TEXT, "");
    }

}
