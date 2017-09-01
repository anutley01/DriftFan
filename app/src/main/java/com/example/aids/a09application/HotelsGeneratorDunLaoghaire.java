package com.example.aids.a09application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class HotelsGeneratorDunLaoghaire extends Activity {
    SQLHelper db = new SQLHelper(this);
    int hotelID;
    String hotelName, hotelPhone, price, near_to;
    double latitude, longitude;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_select);
        ImageButton mapsButton = (ImageButton)findViewById(R.id.mapsButton);
        ImageButton phoneButton = (ImageButton)findViewById(R.id.phoneButton);

        Bundle b = getIntent().getExtras();
        hotelID = b.getInt("ID");
        Log.d("id in generator",Integer.toString(hotelID));

        // create building list
        List<Hotel> getAllHotels = db.getAllHotelsDunLaoghaire();

        for (int i = 0; i < getAllHotels.size(); i++) {
            Hotel hotel = getAllHotels.get(i);
            // finds the correct building that was sent through via Intent from previous class
            if (hotelID == hotel.getId()) {
                hotelName = hotel.getName();
                hotelPhone = hotel.getPhone();
                latitude = hotel.getLatitude();
                longitude = hotel.getLongitude();
                price = hotel.getPrice();
                // set the empty fields to the data retrieved from the database
                // textViewName.setText(buildingName);
                //textViewAddress.setText(buildingAddress.replace(", ", "\n"));
                //imageView.setImageResource(getImageId(this, buildingImage));
                mapsButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        // Create a Uri from an intent string. Use the result to create an Intent.
                        Uri mondelloPark = Uri.parse("google.navigation:q="+ latitude + "," + longitude);
                        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                        Intent directToMondello = new Intent(Intent.ACTION_VIEW, mondelloPark);
                        // Make the Intent explicit by setting the Google Maps package
                        directToMondello.setPackage("com.google.android.apps.maps");
                        // Attempt to start an activity that can handle the Intent
                        startActivity(directToMondello);
                    }
                }); phoneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + hotelPhone));
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            startActivity(intent);
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }

                    }
                });


            }
        }}}

