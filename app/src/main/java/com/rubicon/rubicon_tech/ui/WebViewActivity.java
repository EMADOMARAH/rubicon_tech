package com.rubicon.rubicon_tech.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.rubicon.rubicon_tech.R;

public class WebViewActivity extends AppCompatActivity {
	
	ProgressBar loading;
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		
		webView = findViewById(R.id.web_view);
		loading = findViewById(R.id.progressBar);
		
		String url = "https://app.viakasidigitals.co.za/";
		webView.getSettings().setJavaScriptEnabled(true);
		
		webView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress)
			{
				//Make the bar disappear after URL is loaded, and changes string to Loading...
				//Make the bar disappear after URL is loaded
				
				// Return the app name after finish loading
				if(progress == 100){
					loading.setVisibility(View.INVISIBLE);
					webView.setVisibility(View.VISIBLE);
				}
				
			}
		});
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl(url);
		
		
		
		
		
	}
}