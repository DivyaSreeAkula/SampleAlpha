package com.git.samplealpha;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class SkipActivity extends Activity {
     WebView mWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skipscreen);
        mWebView = (WebView) findViewById(R.id.webview);
        //to enable user interaction with the webpage
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //to load the webpages
        mWebView.loadUrl("http://hyderabad.girlsintech.org/");
        //to allow the webpages of the site to open in the app itself inspitye of opening in the browser
        mWebView.setWebViewClient(new MyAppWebViewClient());

    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    private class MyAppWebViewClient extends WebViewClient {}



}