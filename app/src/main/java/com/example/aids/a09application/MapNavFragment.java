package com.example.aids.a09application;
import android.app.Activity;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static java.security.AccessController.checkPermission;
import static java.security.AccessController.getContext;

    public class MapNavFragment extends FragmentActivity {//implements
            //GoogleMap.OnMarkerClickListener,
            //OnMapReadyCallback {
        /*
        private static final LatLng MONDELLO_PARK = new LatLng(53.257456, -6.746064);
        private static final LatLng DUN_LAOGHAIRE = new LatLng(53.295954, -6.136933);
        private static final LatLng WATERGRASSHILL = new LatLng(52.001564, -8.326386);
        private Marker mMondelloPark;
        private Marker mDunLaoghaire;
        private Marker mWatergrasshill;
        MapView mMapView;
        private GoogleMap googleMap;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_home);

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
            mapFragment.getMapAsync(this);

        }

        @Override
        public void onMapReady(final GoogleMap googleMap) {
            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
            {
                @Override
                public void onMapClick(LatLng arg0)
                {
                    android.util.Log.i("onMapClick", "Horray!");
                    // For dropping a marker at a point on the Map
                    mMondelloPark = googleMap.addMarker(new MarkerOptions()
                            .position(MONDELLO_PARK)
                            .title("Mondello Park - Rounds 1, 3, & 5"));
                    mMondelloPark.setTag(0);

                    mDunLaoghaire = googleMap.addMarker(new MarkerOptions()
                            .position(DUN_LAOGHAIRE)
                            .title("Dun Laoghaire - Round 2"));
                    mDunLaoghaire.setTag(0);

                    mWatergrasshill = googleMap.addMarker(new MarkerOptions()
                            .position(WATERGRASSHILL)
                            .title("Watergrasshill - Round 4"));
                    mWatergrasshill.setTag(0);
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(WATERGRASSHILL));
                }
            });



        }

        @Override
        public void onResume() {
            super.onResume();
            mMapView.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
            mMapView.onPause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mMapView.onDestroy();
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            mMapView.onLowMemory();
        }

        @Override
        public boolean onMarkerClick(Marker marker) {
            return false;
        }
    }























    /*
    //Google Map
    private GoogleMap googleMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_to_event, container, false);
        super.onCreate(savedInstanceState);
        try {
            // Loading map
            initialiseMap();
        } catch (Exception e) {//return errors
            e.printStackTrace();
        }
        return view;
    }
        @Override
        public void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

    /**
     * function to load map. If map is not created it will create it for you
     *
    public void initialiseMap() {
        if (googleMap == null) {
            MapFragment googleMap = (MapFragment) getFragmentManager().findFragmentById(R.layout.fragment_nav_to_event);
            googleMap.getMapAsync(this);
        }

        // check if map is created successfully or not
        if (googleMap == null) {
            //Toast.makeText(getContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
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
}*/}
