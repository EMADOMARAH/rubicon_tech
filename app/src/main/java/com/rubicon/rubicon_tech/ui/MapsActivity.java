package com.rubicon.rubicon_tech.ui;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.rubicon.rubicon_tech.R;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
	
	private GoogleMap mMap;
	ImageView currentLocationBtn,openMapBtn,infoBtn;
	double longitude = -0.3974038952959431;
	double latitude  = 51.6600366914027 ;
	String address;
	
	TextView mail,phone,add;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		currentLocationBtn = findViewById(R.id.reset_location);
		openMapBtn = findViewById(R.id.near_me);
		infoBtn = findViewById(R.id.info);
		mapFragment.getMapAsync(this);
	}
	
	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */
	@Override
	public void onMapReady(GoogleMap googleMap) {
		mMap = googleMap;
		
		// Add a marker in Sydney and move the camera
		LatLng london = new LatLng(51.6600366914027, -0.3974038952959431);
		mMap.addMarker(new MarkerOptions().position(london).title("Marker in London"));
		mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		mMap.moveCamera(CameraUpdateFactory.newLatLng(london));
		//mMap.animateCamera( CameraUpdateFactory.zoomTo( 14.0f ) );
		//mMap.getMaxZoomLevel();
		
		Geocoder geocoder;
		List<Address> addresses = new ArrayList<>();
		geocoder = new Geocoder(this, Locale.getDefault());
		
		try {
			addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
		} catch (IOException e) {
			e.printStackTrace();
		}
		address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//		String city = addresses.get(0).getLocality();
//		String state = addresses.get(0).getAdminArea();
//		String country = addresses.get(0).getCountryName();
//		String postalCode = addresses.get(0).getPostalCode();
//		String knownName = addresses.get(0).getFeatureName();
		
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(london,14));
		
		currentLocationBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMap.moveCamera(CameraUpdateFactory.newLatLng(london));
				
			}
		});
		
		openMapBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 51.6600366914027, -0.3974038952959431);
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
				startActivity(intent);
			}
		});
		
		infoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showMenu();
			}
		});
		
		
		
	}
	
	
	void showMenu() {
		
		final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
			bottomSheetDialog.setContentView(R.layout.map_dialog);
	
			mail = bottomSheetDialog.findViewById(R.id.menu_mail);
			phone = bottomSheetDialog.findViewById(R.id.menu_phone);
			add = bottomSheetDialog.findViewById(R.id.menu_loc);
			
			add.setText(address);
			mail.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "info@rubicon-tech.co.uk", null));
					intent.putExtra("android.intent.extra.SUBJECT", "Enter Subject Here");
					startActivity(Intent.createChooser(intent, "Select an email client"));
				}
			});
			
			phone.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(Intent.ACTION_DIAL);
					intent.setData(Uri.parse("tel:+4402037690706"));
					startActivity(intent);
					
				}
			});
			
		bottomSheetDialog.show();
	}
	
}