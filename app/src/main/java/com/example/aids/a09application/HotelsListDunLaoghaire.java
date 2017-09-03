package com.example.aids.a09application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 25/08/2017.
 */

public class HotelsListDunLaoghaire extends AppCompatActivity {
    ListView hotelList;
    SQLHelper db = new SQLHelper(this);
    List<Hotel> getAllHotels;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);

        hotelList = (ListView) findViewById(R.id.hotel_listView);
        getAllHotels = db.getAllHotelsDunLaoghaire();
        db.close();

        // set up ArrayList for buildingNames
        final List<String> buildingNames = new ArrayList<>();

        // loop through getAllBuilding List and add all building_name 's to buildingNames list
        for (int i = 0; i < getAllHotels.size(); i++) {
            buildingNames.add(getAllHotels.get(i).getName());

            //sort alphabetically


        }


        // set up adapter for searchBar listView
        adapter = new ArrayAdapter<>(HotelsListDunLaoghaire.this, android.R.layout.simple_list_item_1, buildingNames);
        hotelList.setAdapter(adapter);
        hotelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HotelsListDunLaoghaire.this, HotelsGenerator.class);
                Bundle extras = new Bundle();
                int hotelId = 1;
                String hotelNearTo = "None";
                // set up string with the selected onItem building name
                Object hotelName = adapter.getItem(position);
                //loop through buildings (info pulled from db) to match the building names
                for (int i = 0; i < getAllHotels.size(); i++) {
                    if (hotelName.equals(getAllHotels.get(i).getName())) {
                        // getName the corresponding building_id
                        hotelId = getAllHotels.get(i).getId();
                        hotelNearTo = getAllHotels.get(i).getNearTo();
                    }
                }
                extras.putInt("ID", (hotelId));
                extras.putString("NEAR_TO", (hotelNearTo));
                intent.putExtras(extras);
                startActivity(intent);

            }
        });

    }
}

