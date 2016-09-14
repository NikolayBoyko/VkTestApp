package com.example.master.vktestapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoginActivity extends Activity {

    public SharedPreferences sPref;
    private WebView mWebView;
    public static String mToken;
    final String SAVED_TEXT = "saved_text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mWebView = (WebView) findViewById(R.id.webView);

        if (mToken != null && !TextUtils.equals("", mToken)) {

            startActivity(new Intent(this, MainActivity.class));

        } else mWebView.setWebViewClient(new MyWebView());
        mToken = loadText();
        mWebView.loadUrl("https://oauth.vk.com/authorize?client_id=5610917&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=friends,photos&response_type=token&v=5.53&state=123456");

    }

    String loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        return sPref.getString(SAVED_TEXT, "");
    }

    private class MyWebView extends WebViewClient {

        private String token;

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            mToken = url.substring(url.indexOf("=") + 1, url.indexOf("&"));

            if (url.contains("https://oauth.vk.com/blank.html")) {

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                saveText();
            }
            view.loadUrl(url);
            saveText();
            return true;
        }

        void saveText() {
            sPref = getPreferences(MODE_PRIVATE);
            Editor ed = sPref.edit();
            ed.putString(SAVED_TEXT, token).apply();
            Log.d("LOG", "saveText = " + token);
        }
    }
}


