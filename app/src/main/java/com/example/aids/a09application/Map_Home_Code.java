package com.example.aids.a09application;

/**
 * Created by Aids on 09/08/2017.
 */

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
     * Created by Aids on 09/08/2017.
     */

    public class Map_Home_Code extends Activity implements OnMapReadyCallback {

    GoogleMap googleMap;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_home);

            MapFragment mapFragment = (MapFragment) getFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap map) {

            LatLng sydney = new LatLng(-33.852, 151.211);
            googleMap.addMarker(new MarkerOptions().position(sydney)
                    .title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    }
