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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HotelsGenerator extends Activity {
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
        ImageButton infoButton = (ImageButton)findViewById(R.id.infoButton);
        TextView dispHotel = (TextView)findViewById(R.id.displayHotelName);
        Bundle b = getIntent().getExtras();
        hotelID = b.getInt("ID");
        near_to = b.getString("NEAR_TO");
        Log.d("id in generator",Integer.toString(hotelID));
        List<Hotel> getAllHotels;
        // create building list
        if(near_to.equals("Dun Laoghaire")) {
            getAllHotels = db.getAllHotelsDunLaoghaire();
        } else if (near_to.equals("Mondello Park")){
            getAllHotels = db.getAllHotelsMondello();
        } else if (near_to.equals("Watergrasshill")){
            getAllHotels = db.getAllHotelsDunLaoghaire();
        } else {
            getAllHotels = null;
        }
        if (getAllHotels.equals(null)){
            Toast.makeText(this, "There has been an error. Please restart the application.", Toast.LENGTH_LONG).show();
        } else {
            for (int i = 0; i < getAllHotels.size(); i++) {
                Hotel hotel = getAllHotels.get(i);
                // finds the correct building that was sent through via Intent from previous class
                if (hotelID == hotel.getId()) {
                    hotelName = hotel.getName();
                    hotelPhone = hotel.getPhone();
                    latitude = hotel.getLatitude();
                    longitude = hotel.getLongitude();
                    price = hotel.getPrice();
                    dispHotel.setText(hotelName);
                    if(near_to.equals("Mondello Park")){
                        near_to = "Kildare";
                    }
                    infoButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            shortClickToastInfoButton();
                        }
                    });
                    infoButton.setOnLongClickListener(new View.OnLongClickListener() {

                        @Override
                        public boolean onLongClick(View v) {
                            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + hotelName + "    " + near_to));
                            startActivity(intent);
                            return true;
                        }
                    });
                    mapsButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            shortClickToastMap();
                        }
                    });
                    mapsButton.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            longClickMapButton();
                            return true;
                        }
                    });
                    phoneButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            shortClickToastPhone();
                        }
                    });
                    phoneButton.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            longClickPhoneButton();
                            return true;
                        }
                    });

                }

            }
        }}

    public void shortClickToastMap(){
        Toast.makeText(this, "Press and hold to open navigation in maps to this hotel", Toast.LENGTH_LONG).show();
    }

    public void shortClickToastPhone(){
        Toast.makeText(this, "Press and hold to call this hotel", Toast.LENGTH_LONG).show();
    }
    public void shortClickToastInfoButton(){
        Toast.makeText(this, "Press and hold to view information about this hotel", Toast.LENGTH_LONG).show();
    }
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
    public void longClickPhoneButton() {
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
}
