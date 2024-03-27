package com.satvik.webrowse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.analytics.FirebaseAnalytics;


public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        ;
        ImageButton back = findViewById(R.id.back);
        ImageButton forward = findViewById(R.id.forward);
        ImageButton home = findViewById(R.id.home);
        ImageButton refresh = findViewById(R.id.refresh);

        final WebView mywebview = findViewById(R.id.webView);
        mywebview.setWebViewClient(new WebViewClient());
        mywebview.loadUrl("https://www.google.com");
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setSupportZoom(true);
        mywebview.clearSslPreferences();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mywebview.goBack();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mywebview.goForward();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mywebview.loadUrl("https://www.google.com");
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mywebview.reload();
            }
        });


    }
}