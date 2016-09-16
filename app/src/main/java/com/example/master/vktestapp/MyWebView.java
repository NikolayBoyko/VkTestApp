package com.example.master.vktestapp;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MyWebView extends WebViewClient {

    private static Context context;
    public static String mToken;

    public MyWebView(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        mToken = url.substring(url.indexOf("=") + 1, url.indexOf("&"));
        view.loadUrl(url);
        saveUrl(mToken);
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        return true;
    }

    public void saveUrl(String url) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("KEY", url).apply();
    }

    public static String getmToken(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

}
