package com.example.aids.a09application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Author: Connor
 */

public class AccomodationButtonsFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_open_hotels, container, false);
        //find buttons that will open lists
        Button openHotelMondello = (Button) view.findViewById(R.id.hotelsMondello);
        Button openHotelDunLaoghaire = (Button) view.findViewById(R.id.hotelsDunLaoghaire);
        Button openHotelWatergrasshill = (Button) view.findViewById(R.id.hotelsWatergrasshill);
        Button openRestaurantMondello = (Button) view.findViewById(R.id.restaurantsMondello);
        Button openRestaurantDunLaoghaire = (Button) view.findViewById(R.id.restaurantsDunLaoghaire);
        Button openRestaurantsWatergrasshill = (Button) view.findViewById(R.id.restaurantsWatergrasshill);
        Button nightLifeKildare = (Button) view.findViewById(R.id.thingsToDoKildare);
        Button nightLifeDunLaoghaire = (Button) view.findViewById(R.id.thingsToDunLaoghaire);
        Button nightLifeWatergrasshill = (Button) view.findViewById(R.id.thingsToDoWatergrasshill);

        nightLifeKildare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nightlife = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tripadvisor.co.uk/Attractions-g186614-Activities-c20-County_Kildare.html"));
                startActivity(nightlife);
            }
        });

        nightLifeDunLaoghaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nightlife = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dublintourist.com/directory/nightlife/south_county/dun_laoghaire/"));
                startActivity(nightlife);
            }
        });
        nightLifeWatergrasshill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nightlife = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.irishtourist.com/directory/nightlife/southwest/cork/east_cork/watergrasshill/"));
                startActivity(nightlife);
            }
        });
        //pass in bundle extra to be used in the next activity
        openHotelMondello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), HotelsList.class);
                Bundle extras = new Bundle();
                extras.putString("NEAR_TO", ("Mondello Park"));
                intentOpenHotelPage.putExtras(extras);
                startActivity(intentOpenHotelPage);

            }
        });
        openHotelDunLaoghaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), HotelsList.class);
                Bundle extras = new Bundle();
                extras.putString("NEAR_TO", ("Dun Laoghaire"));
                intentOpenHotelPage.putExtras(extras);
                startActivity(intentOpenHotelPage);
            }
        });
        openHotelWatergrasshill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), HotelsList.class);
                Bundle extras = new Bundle();
                extras.putString("NEAR_TO", ("Watergrasshill"));
                intentOpenHotelPage.putExtras(extras);
                startActivity(intentOpenHotelPage);
            }
        });
        openRestaurantMondello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), RestaurantList.class);
                Bundle extras = new Bundle();
                extras.putString("NEAR_TO", ("Mondello Park"));
                intentOpenHotelPage.putExtras(extras);
                startActivity(intentOpenHotelPage);
            }
        });
        openRestaurantDunLaoghaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), RestaurantList.class);
                Bundle extras = new Bundle();
                extras.putString("NEAR_TO", ("Dun Laoghaire"));
                intentOpenHotelPage.putExtras(extras);
                startActivity(intentOpenHotelPage);
            }
        });
        openRestaurantsWatergrasshill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), RestaurantList.class);
                Bundle extras = new Bundle();
                extras.putString("NEAR_TO", ("Watergrasshill"));
                intentOpenHotelPage.putExtras(extras);
                startActivity(intentOpenHotelPage);
            }
        });

        return view;

    }
}
