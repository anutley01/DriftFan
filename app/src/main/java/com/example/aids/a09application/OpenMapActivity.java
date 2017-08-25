package com.example.aids.a09application;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Map;

import static com.example.aids.a09application.R.id.openMapsButton;
import static com.example.aids.a09application.R.id.round1button;
import static com.example.aids.a09application.R.id.round2button;
import static com.example.aids.a09application.R.id.round3button;
import static com.example.aids.a09application.R.id.round4button;
import static com.example.aids.a09application.R.id.round5button;

/**
 * Created by Connor on 02/08/2017.
 */

public class OpenMapActivity extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_to_event, container, false);
        ImageButton round1 = (ImageButton) view.findViewById(round1button);
        ImageButton round2 = (ImageButton) view.findViewById(round2button);
        ImageButton round3 = (ImageButton) view.findViewById(round3button);
        ImageButton round4 = (ImageButton) view.findViewById(round4button);
        ImageButton round5 = (ImageButton) view.findViewById(round5button);
        setRound1ClickListener(round1);
        setRound1ClickListener(round3);
        setRound2ClickListener(round2);
        setRound4ClickListener(round4);
        setRound1ClickListener(round5);

        return view;
    }



    /**
     * This method is used to open navigation to rounds 1, 3 and 5
     * @param round1
     */
    public void setRound1ClickListener(ImageButton round1){
        round1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri mondelloPark = Uri.parse("google.navigation:q=53.257450, -6.745986");
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent directToMondello = new Intent(Intent.ACTION_VIEW, mondelloPark);
                // Make the Intent explicit by setting the Google Maps package
                directToMondello.setPackage("com.google.android.apps.maps");
                // Attempt to start an activity that can handle the Intent
                startActivity(directToMondello);
            }
        });
    }

    public void setRound2ClickListener(ImageButton round2){
        round2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri dunLaoghaire = Uri.parse("google.navigation:q=53.294951, -6.133538");
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent directToDunLaoghaire = new Intent(Intent.ACTION_VIEW, dunLaoghaire);
                // Make the Intent explicit by setting the Google Maps package
                directToDunLaoghaire.setPackage("com.google.android.apps.maps");
                // Attempt to start an activity that can handle the Intent
                startActivity(directToDunLaoghaire);

            }
        });
    }

    public void setRound4ClickListener(ImageButton round4){
        round4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri watergrasshill = Uri.parse("google.navigation:q=52.001571, -8.326375");
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent directToWatergrasshill = new Intent(Intent.ACTION_VIEW, watergrasshill);
                // Make the Intent explicit by setting the Google Maps package
                directToWatergrasshill.setPackage("com.google.android.apps.maps");
                // Attempt to start an activity that can handle the Intent
                startActivity(directToWatergrasshill);
            }
        });
    }


}
