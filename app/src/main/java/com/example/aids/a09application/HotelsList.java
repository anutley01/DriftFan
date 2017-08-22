package com.example.aids.a09application;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.aids.a09application.Hotel;
import com.example.aids.a09application.R;
import com.example.aids.a09application.SQLHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Connor on 22/08/2017.
 */

public class HotelsList extends Activity {
    List<Hotel> getAllHotels;
    SQLHelper db = new SQLHelper(this);

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_list);

        ListView hotelList = (ListView)findViewById(R.id.hotel_listView);
        getAllHotels = db.getAllHotels();
        db.close();
        // set up ArrayList for buildingNames
        final List<String> buildingNames = new ArrayList<>();
        // loop through getAllBuilding List and add all building_name 's to buildingNames list
        for (int i = 0; i < getAllHotels.size(); i++) {
            buildingNames.add(getAllHotels.get(i).getPrice());
            //sort alphabetically
            Collections.sort(buildingNames);
        }

    }}

