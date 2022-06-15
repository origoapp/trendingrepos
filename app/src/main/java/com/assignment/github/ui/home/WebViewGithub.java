package com.assignment.github.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.assignment.github.R;

public class WebViewGithub extends AppCompatActivity {
    private WebView webView = null;
    String githubUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_github);
        getSupportActionBar().hide();

        this.webView = (WebView) findViewById(R.id.web_view);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                githubUrl= null;
            } else {
                githubUrl= extras.getString("github_url");
            }
        } else {
            githubUrl= (String) savedInstanceState.getSerializable("github_url");
        }

        webView.loadUrl(githubUrl);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}