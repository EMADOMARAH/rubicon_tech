package com.rubicon.rubicon_tech.model;

public class OnboardingModel {
	
	String description ;
	int image;
	
	public OnboardingModel(String description, int image) {
		this.description = description;
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getImage() {
		return image;
	}
	
	public void setImage(int image) {
		this.image = image;
	}
}
