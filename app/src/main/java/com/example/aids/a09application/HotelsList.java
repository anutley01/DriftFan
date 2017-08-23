package com.example.aids.a09application;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class HotelsList extends AppCompatActivity {
    List<Hotel> getAllHotels;
    ArrayAdapter adapter;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_list);
        SQLHelper db = new SQLHelper(this);
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
        // set up adapter for searchBar listView
        adapter = new ArrayAdapter<>(HotelsList.this, android.R.layout.simple_list_item_1, buildingNames);
        hotelList.setAdapter(adapter);
        hotelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HotelsList.this, HotelsGenerator.class);
                Bundle extras = new Bundle();
                int hotelId = 1;
                // set up string with the selected onItem building name
                Object hotelName = adapter.getItem(position);
                //loop through buildings (info pulled from db) to match the building names
                for (int i = 0; i < getAllHotels.size(); i++) {
                    if (hotelName.equals(getAllHotels.get(i).getHotelName())) {
                        // get the corresponding building_id
                        hotelId = getAllHotels.get(i).getId();
                    }
                }
                extras.putInt("ID", (hotelId));
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

    }

