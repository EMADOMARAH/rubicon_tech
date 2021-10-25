package com.rubicon.rubicon_tech.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.rubicon.rubicon_tech.R;
import com.rubicon.rubicon_tech.adapter.OnBoardingAdapter;
import com.rubicon.rubicon_tech.model.OnboardingModel;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {
	
	ViewPager viewPager;
	OnBoardingAdapter onBoardingAdapter;
	
	TextView nextBtn;
	
	TabLayout tabLayout ;
	int position;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_on_boarding);
		
		viewPager = findViewById(R.id.viewPager);
//		tabLayout = findViewById(R.id.tab_layout);
		nextBtn = findViewById(R.id.textView);
		
		List<OnboardingModel> mylist = new ArrayList<>();
		
		mylist.add(new OnboardingModel("Get access to full IT solutions Web Design, Web & Mobile Development, Hosting and Maintenance, Graphic Design and Digital Marketing" , R.drawable.on1));
		mylist.add(new OnboardingModel("Get your job Done from home with One Click" , R.drawable.on2));
		mylist.add(new OnboardingModel("Get Email description With Service you want and best Budget Offers" , R.drawable.on3));
		
		onBoardingAdapter = new OnBoardingAdapter(this , mylist);
		viewPager.setAdapter(onBoardingAdapter);
		
		
		nextBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			
				position = viewPager.getCurrentItem();
				if (position<mylist.size()){
					position++;
					viewPager.setCurrentItem(position);
				}
				
				if (position == mylist.size()-1){
					nextBtn.setText("Get Started");
				}
				
				if (position == mylist.size()){
					startActivity(new Intent(getApplicationContext() , OptionsActivity.class));
					finish();
				}
				
				
				
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		
	}
}