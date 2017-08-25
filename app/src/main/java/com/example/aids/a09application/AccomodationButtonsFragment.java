package com.example.aids.a09application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Connor on 18/08/2017.
 */

public class AccomodationButtonsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_open_hotels, container, false);
        Button openHotelMondello = (Button) view.findViewById(R.id.hotelsMondello);
        Button openHotelDunLaoghaire = (Button) view.findViewById(R.id.hotelsDunLaoghaire);
        Button openHotelWatergrasshill = (Button) view.findViewById(R.id.hotelsWatergrasshill);
        openHotelMondello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), HotelsListMondello.class);
                startActivity(intentOpenHotelPage);
            }
        });
        openHotelDunLaoghaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), HotelsListDunLaoghaire.class);
                startActivity(intentOpenHotelPage);
            }
        });
        openHotelWatergrasshill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), HotelsListMondello.class);
                startActivity(intentOpenHotelPage);
            }
        });
        return view;

    }

    public void setButtonClickListener(Button openHotel) {

    }

    public void showMessage(String title, String message) {

        //AlertDialog.Builder builder = new AlertDialog.Builder();
    }
}
