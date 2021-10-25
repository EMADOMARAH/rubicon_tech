package com.rubicon.rubicon_tech.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rubicon.rubicon_tech.R;

public class WelcomeActivity extends AppCompatActivity {
	TextView startBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		startBtn = findViewById(R.id.textView0);
		startBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext() , OnBoardingActivity.class));
			}
		});
	}
}