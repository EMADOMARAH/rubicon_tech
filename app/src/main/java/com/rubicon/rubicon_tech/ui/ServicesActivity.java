package com.rubicon.rubicon_tech.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rubicon.rubicon_tech.R;
import com.rubicon.rubicon_tech.adapter.ServicesAdapter;
import com.rubicon.rubicon_tech.model.ServiceModel;

import java.util.ArrayList;

public class ServicesActivity extends AppCompatActivity {
	
	RecyclerView recyclerView;
	ArrayList<ServiceModel> myServices;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_services);
		
		recyclerView = findViewById(R.id.services_recycler);
		recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
		
		myServices = new ArrayList<>();
		
		myServices.add(new ServiceModel("Web development and design" , R.drawable.web));
		myServices.add(new ServiceModel("Mobile application development" , R.drawable.mobile));
		myServices.add(new ServiceModel("Hosting and support" , R.drawable.hosting));
		myServices.add(new ServiceModel("Graphic Design" , R.drawable.design));
		myServices.add(new ServiceModel("Digital Marketing" , R.drawable.digital));
		
		ServicesAdapter servicesAdapter = new ServicesAdapter(myServices , this);
		recyclerView.setAdapter(servicesAdapter);
		
	}
}