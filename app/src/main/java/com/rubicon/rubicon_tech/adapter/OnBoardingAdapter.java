package com.rubicon.rubicon_tech.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.rubicon.rubicon_tech.R;
import com.rubicon.rubicon_tech.model.OnboardingModel;

import java.util.List;

public class OnBoardingAdapter extends PagerAdapter {

	Context context ;
	List<OnboardingModel> list;
	
	
	public OnBoardingAdapter(Context context, List<OnboardingModel> list) {
		this.context = context;
		this.list = list;
	}
	
	
	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View screen = layoutInflater.inflate(R.layout.onboarding_item , null);
		
		ImageView imageView = screen.findViewById(R.id.imageView3);
		TextView textView = screen.findViewById(R.id.textView3);
		
		imageView.setImageResource(list.get(position).getImage());
		textView.setText(list.get(position).getDescription());
		
		container.addView(screen);
		 return screen;
		
		
		
	}
	
	@Override
	public int getCount() {
		return list.size();
	}
	
	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view == object;
	}
	
	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
		container.removeView((View) object);
	}
}
