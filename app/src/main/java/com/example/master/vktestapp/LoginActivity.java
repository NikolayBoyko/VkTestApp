package com.example.master.vktestapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoginActivity extends Activity {

    private WebView mWebView;
    public static String mToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mWebView = (WebView) findViewById(R.id.webView);

        Log.d("TAG", "LoginActivity onCreate ");

        mWebView.setWebViewClient(new MyWebView(getBaseContext()));

        mWebView.loadUrl("https://oauth.vk.com/authorize?client_id=5610917&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=friends,photos&response_type=token&v=5.53&state=123456");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "LoginActivity onDestroy()");
    }

    class MyWebView extends WebViewClient {

        private Context context;

        public MyWebView(Context context) {
            this.context = context;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mToken = url.substring(url.indexOf("=") + 1, url.indexOf("&"));
            view.loadUrl(url);
            saveUrl(mToken);
            startActivity(new Intent(context, MainActivity.class));
            finish();
            return true;
        }

        public void saveUrl(String url) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("KEY", url).apply();
        }
    }
}


