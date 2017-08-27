package com.example.aids.a09application;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class HotelsGeneratorMondello extends Activity {
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

        mapsButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){

            }
        });

        phoneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        Bundle b = getIntent().getExtras();
        hotelID = b.getInt("BUILDING_ID");

        // create building list
        List<Hotel> getAllHotels = db.getAllHotelsMondello();

        for (int i = 0; i < getAllHotels.size(); i++) {
            Hotel hotel = getAllHotels.get(i);
            // finds the correct building that was sent through via Intent from previous class
            if (hotelID == hotel.getId()) {
                hotelName = hotel.getHotelName();
                hotelPhone = hotel.getPhone();
                latitude = hotel.getLatitude();
                longitude = hotel.getLongitude();
                price = hotel.getPrice();
                // set the empty fields to the data retrieved from the database
               // textViewName.setText(buildingName);
                //textViewAddress.setText(buildingAddress.replace(", ", "\n"));
                //imageView.setImageResource(getImageId(this, buildingImage));

            }
        }
    }





}

