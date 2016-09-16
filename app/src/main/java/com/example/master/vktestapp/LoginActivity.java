package com.example.master.vktestapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class LoginActivity extends Activity {

        private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mWebView = (WebView) findViewById(R.id.webView);
        Log.d("TAG","LoginActivity onCreate " + MyWebView.mToken);

        mWebView.setWebViewClient(new MyWebView(getBaseContext()));

        mWebView.loadUrl("https://oauth.vk.com/authorize?client_id=5610917&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=friends,photos&response_type=token&v=5.53&state=123456");

    }

   /* void setText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, LoginActivity.mToken).apply();
    }

    public static void setmToken(String key, String value, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getmToken(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    String getText() {
        sPref = getPreferences(MODE_PRIVATE);
        return sPref.getString(SAVED_TEXT, "");
    }*/



}


