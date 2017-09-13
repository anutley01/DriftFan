package com.example.aids.a09application;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RestaurantGenerator extends Activity {
    SQLHelper db = new SQLHelper(this);
    int restaurantID;
    String restaurantName, phone, near_to;
    double latitude, longitude;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_select);
        ImageButton mapsButton = (ImageButton)findViewById(R.id.mapsButton);
        ImageButton phoneButton = (ImageButton)findViewById(R.id.phoneButton);
        ImageButton infoButton = (ImageButton)findViewById(R.id.infoButton);
        TextView dispHotel = (TextView)findViewById(R.id.displayHotelName);
        Bundle b = getIntent().getExtras();
        restaurantID = b.getInt("ID");
        near_to = b.getString("NEAR_TO");
        Log.d("id in generator",Integer.toString(restaurantID));

        List<Hotel> getAllHotels;
        getAllHotels = db.getAllRestaurants(near_to);

        for (int i = 0; i < getAllHotels.size(); i++) {
            Hotel hotel = getAllHotels.get(i);
            //uses the restaurant ID passed in from intent to find the restaurant
            if (restaurantID == hotel.getId()) {
                restaurantName = hotel.getName();
                phone = hotel.getPhone();
                latitude = hotel.getLatitude();
                longitude = hotel.getLongitude();

                dispHotel.setText(restaurantName);
                mapsButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        shortClickToastMap();
                    }
                });
                mapsButton.setOnLongClickListener(new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View v){
                        longClickMapButton();
                        return true;
                    }
                });

                infoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shortClickToastInfoButton();
                    }
                });
                infoButton.setOnLongClickListener(new View.OnLongClickListener() {

                    @Override
                    public boolean onLongClick(View v) {
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + restaurantName + " " + near_to));
                        startActivity(intent);
                        return true;
                    }
                });

                phoneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shortClickToastPhone();
                    }
                });
                phoneButton.setOnLongClickListener(new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View v){
                        longClickPhoneButton();
                        return true;
                    }
                });

            }

        }
    }
    //displays a toast to remind user how to access functionality
    public void shortClickToastMap(){
        Toast.makeText(this, "Press and hold to open navigation in maps to this restaurant", Toast.LENGTH_LONG).show();
    }
    //displays a toast to remind user how to access functionality
    public void shortClickToastPhone(){
        Toast.makeText(this, "Press and hold to call this restaurant", Toast.LENGTH_LONG).show();
    }
    //opens navigation mode in google maps
    public void longClickMapButton(){
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri restaurant = Uri.parse("google.navigation:q="+ latitude + "," + longitude);
        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent directToRestaurant = new Intent(Intent.ACTION_VIEW, restaurant);
        // Make the Intent explicit by setting the Google Maps package
        directToRestaurant.setPackage("com.google.android.apps.maps");
        // Attempt to start an activity that can handle the Intent
        startActivity(directToRestaurant);
    }
    //opens the phone application with the number pre-dialled
    public void longClickPhoneButton() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
            return;
        }
    }
    //displays a toast to remind user how to access functionality
    public void shortClickToastInfoButton(){
        Toast.makeText(this, "Press and hold to open information in maps to this restaurant", Toast.LENGTH_LONG).show();
    }
}