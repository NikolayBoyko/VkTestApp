package com.example.master.vktestapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoginActivity extends Activity {

    private SharedPreferences sPref;
    public static String mToken;
    final String SAVED_TEXT = "saved_text";
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mWebView = (WebView) findViewById(R.id.webView);

        //mToken = loadText();

        mWebView.setWebViewClient(new LoginActivity.MyWebView());
        mWebView.loadUrl("https://oauth.vk.com/authorize?client_id=5610917&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=friends,photos&response_type=token&v=5.53&state=123456");
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, LoginActivity.mToken).apply();
    }


    public class MyWebView extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            LoginActivity.mToken = url.substring(url.indexOf("=") + 1, url.indexOf("&"));
            view.loadUrl(url);
            saveText();
            finish();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            return true;
        }
    }

}


