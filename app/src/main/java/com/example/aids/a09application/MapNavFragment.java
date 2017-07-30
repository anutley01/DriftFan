package com.example.aids.a09application;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MapNavFragment extends MapFragment implements OnMapReadyCallback {

    //Google Map
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_to_event, container, false);

        try {
            // Loading map
            initialiseMap();
        } catch (Exception e) {//return errors
            e.printStackTrace();
        }
        return view;
    }

    /**
     * function to load map. If map is not created it will create it for you
     * */
    public void initialiseMap() {
        if (googleMap == null) {
            MapFragment googleMap = (MapFragment) getFragmentManager().findFragmentById(R.layout.fragment_nav_to_event);
            googleMap.getMapAsync(this);
        }

        // check if map is created successfully or not
        if (googleMap == null) {
            Toast.makeText(getContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
    }

    @Override
    public void onResume() {
        super.onResume();
        initialiseMap();
    }
}
