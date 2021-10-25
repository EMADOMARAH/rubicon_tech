package com.rubicon.rubicon_tech.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.rubicon.rubicon_tech.R;

public class WebViewActivity extends AppCompatActivity {
	
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		webView = findViewById(R.id.web_view);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webView.loadUrl("https://app.viakasidigitals.co.za/");
		
	}
}