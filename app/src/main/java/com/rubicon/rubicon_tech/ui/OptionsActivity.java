package com.rubicon.rubicon_tech.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rubicon.rubicon_tech.R;

public class OptionsActivity extends AppCompatActivity {
	
	TextView servicesBtn , contactUsBtn , aboutBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		
		servicesBtn  = findViewById(R.id.textView4);
		contactUsBtn = findViewById(R.id.textView5);
		aboutBtn     = findViewById(R.id.textView6);
		
		
		servicesBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() , ServicesActivity.class));
			}
		});
		
		contactUsBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "info@rubicon-tech.co.uk", null));
				intent.putExtra("android.intent.extra.SUBJECT", "Enter Subject Here");
				startActivity(Intent.createChooser(intent, "Select an email client"));
			}
		});
		
		aboutBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() , MapsActivity.class));
			}
		});
		
	}
}