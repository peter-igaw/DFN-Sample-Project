package com.igaworks.dfn_hybrid_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.igaworks.v2.core.AdBrixRm;

public class MainActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.addJavascriptInterface(new DfineryHybridInterface(this), "DFN");
        initWebView();

        // Deeplink open when app start
        onNewIntent(MainActivity.this.getIntent());
    }

    public void initWebView() {

        WebSettings ws = webView.getSettings();
        ws.setUserAgentString("AndroidWebView");
        ws.setJavaScriptEnabled(true);
        webView.loadUrl("https://dfn-hybrid.web.app/");


    }

    @Override
    public void onNewIntent(Intent intent) {
        setIntent(intent);

        // Deeplink Open
        AdBrixRm.deeplinkEvent(MainActivity.this);
    }
}