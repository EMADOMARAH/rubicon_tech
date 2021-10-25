package com.rubicon.rubicon_tech.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rubicon.rubicon_tech.R;
import com.rubicon.rubicon_tech.model.ServiceModel;
import com.rubicon.rubicon_tech.ui.OptionsActivity;
import com.rubicon.rubicon_tech.ui.WebViewActivity;

import java.util.ArrayList;


public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder> {
	 ArrayList<ServiceModel> servicesList;
	 Context context ;
	
	public ServicesAdapter(ArrayList<ServiceModel> servicesList , Context context) {
		this.servicesList = servicesList;
		this.context = context;
	}
	
	@NonNull
	@Override
	public ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new ServicesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull ServicesViewHolder holder, int position) {
		ServiceModel serviceModel = servicesList.get(position);
		
		holder.serviceName.setText(serviceModel.getServiceName());
		holder.serviceImage.setImageResource(serviceModel.getServiceImage());
		holder.serviceImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				context.startActivity(new Intent(context , WebViewActivity.class));

			}
		});
		
	}
	
	@Override
	public int getItemCount() {
		return servicesList.size();
	}
	
	public void setlist(ArrayList<ServiceModel> servicesList) {
		this.servicesList = servicesList;
		notifyDataSetChanged();
	}
	
	public class ServicesViewHolder extends RecyclerView.ViewHolder {
		
		ImageView serviceImage;
		TextView serviceName;
		
		public ServicesViewHolder(@NonNull View itemView) {
			super(itemView);
			serviceImage = itemView.findViewById(R.id.imageView5);
			serviceName = itemView.findViewById(R.id.textView7);
			
		}
	}
}

