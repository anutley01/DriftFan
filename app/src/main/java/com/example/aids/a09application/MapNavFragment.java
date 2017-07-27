package com.example.aids.a09application;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by Connor on 26/07/2017.
 */

public class MapNavFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap map;
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
        if (map == null) {
            com.google.android.gms.maps.MapFragment googleMap = (com.google.android.gms.maps.MapFragment) getFragmentManager().findFragmentById(R.id.nav_map);
            googleMap.getMapAsync(this);
        }

        // check if map is created successfully or not
        if (map == null) {
            Toast.makeText(getActivity(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
    }

    @Override
    public void onResume() {
        super.onResume();
        initialiseMap();
    }
}