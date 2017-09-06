package com.example.aids.a09application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 30/08/2017.
 */

public class RestaurantListWatergrasshill extends Activity {
    ListView restaurantList;
    SQLHelper db = new SQLHelper(this);
    List<Hotel> getAllRestaurants;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        restaurantList = (ListView) findViewById(R.id.hotel_listView);
        getAllRestaurants = db.getAllRestaurantsWatergrasshill();
        db.close();

        // set up ArrayList for buildingNames
        final List<String> buildingNames = new ArrayList<>();

        // loop through getAllBuilding List and add all building_name 's to buildingNames list
        for (int i = 0; i < getAllRestaurants.size(); i++) {
            buildingNames.add(getAllRestaurants.get(i).getName());
            //sort alphabetically
        }

        // set up adapter for searchBar listView
        adapter = new ArrayAdapter<>(RestaurantListWatergrasshill.this, android.R.layout.simple_list_item_1, buildingNames);
        restaurantList.setAdapter(adapter);
        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RestaurantListWatergrasshill.this, RestaurantGenMondello.class);
                Bundle extras = new Bundle();
                int hotelId = 1;
                String nearTo = "None";
                // set up string with the selected onItem building name
                String restaurantName = adapter.getItem(position);
                //loop through buildings (info pulled from db) to match the building names
                for (int i = 0; i < getAllRestaurants.size(); i++) {
                    if (restaurantName.equals(getAllRestaurants.get(i).getName())) {
                        // getName the corresponding building_id
                        hotelId = getAllRestaurants.get(i).getId();
                        nearTo = getAllRestaurants.get(i).getNearTo();
                    }
                }
                extras.putInt("ID", (hotelId));
                Log.d("id in list", Integer.toString(hotelId));
                extras.putString("NEAR_TO", (nearTo));
                intent.putExtras(extras);
                startActivity(intent);

            }
        });

    }
}