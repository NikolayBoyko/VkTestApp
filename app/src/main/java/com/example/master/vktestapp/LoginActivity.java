package com.example.master.vktestapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        WebView mWebView = (WebView) findViewById(R.id.webView);

        mWebView.setWebViewClient(new MyWebView(this));

        mWebView.loadUrl("https://oauth.vk.com/authorize?client_id=5610917&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=friends,audio&response_type=token&v=5.53&state=123456");
    }

    class MyWebView extends WebViewClient {

        private String mToken;
        private Context context;

        public MyWebView(Context context) {
            this.context = context;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            mToken = url.substring(url.indexOf("=") + 1, url.indexOf("&"));

            if (!mToken.equals(Integer.toString(5610917)) || !mToken.equals("grant_access")) {

                Log.d("TAG", "shouldOverrideUrlLoading  заебись" + mToken);

                saveUrl(mToken);

                Intent intent = new Intent(new Intent(context, MainActivity.class));
                intent.putExtra("token", mToken);
                startActivity(intent);
                finish();
            } else {
                Log.d("TAG", "shouldOverrideUrlLoading  хуйня " + url);

            }
            return true;
        }

        public void saveUrl(String url) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("KEY", url).apply();
        }
    }
}


