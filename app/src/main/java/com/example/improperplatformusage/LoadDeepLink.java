package com.example.improperplatformusage;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.content.Intent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class LoadDeepLink extends AppCompatActivity {
    WebView mWebView;
    Uri data;
    String nameInput;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);
        mWebView = (WebView) findViewById(R.id.activity_load_deep_link);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        String nameInput = data.getLastPathSegment();

        mWebView.loadUrl("file:///android_asset/www/hello.html?name="
                +nameInput);

    }
}
