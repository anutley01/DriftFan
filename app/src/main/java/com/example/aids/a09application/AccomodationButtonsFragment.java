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
        Button openHotel = (Button) view.findViewById(R.id.hotelsButton);
        setButtonClickListener(openHotel);
        return view;

    }

    public void setButtonClickListener(Button openHotel) {
        openHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenHotelPage = new Intent(getActivity(), HotelsList.class);
                startActivity(intentOpenHotelPage);
            }
        });
    }

    public void showMessage(String title, String message) {

        //AlertDialog.Builder builder = new AlertDialog.Builder();
    }
}
