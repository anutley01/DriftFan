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

public class RestaurantListMondello extends Activity {

    ListView restaurantList;
    SQLHelper db = new SQLHelper(this);
    List<Hotel> getAllRestaurants;
    ArrayAdapter<String> adapter;
    public static final String [] menu = {"View in maps", "Call"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        restaurantList = (ListView) findViewById(R.id.hotel_listView);
        getAllRestaurants = db.getAllRestaurantsMondello();
        db.close();

        // set up ArrayList for buildingNames
        final List<String> buildingNames = new ArrayList<>();

        // loop through getAllBuilding List and add all building_name 's to buildingNames list
        for (int i = 0; i < getAllRestaurants.size(); i++) {
            buildingNames.add(getAllRestaurants.get(i).getName());
            //sort alphabetically
        }

        // set up adapter for searchBar listView
        adapter = new ArrayAdapter<>(RestaurantListMondello.this, android.R.layout.simple_list_item_1, buildingNames);
        restaurantList.setAdapter(adapter);
        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RestaurantListMondello.this, RestaurantGenMondello.class);
                Bundle extras = new Bundle();
                int hotelId = 1;
                // set up string with the selected onItem building name
                String hotelName = adapter.getItem(position);
                //loop through buildings (info pulled from db) to match the building names
                for (int i = 0; i < getAllRestaurants.size(); i++) {
                    if (hotelName.equals(getAllRestaurants.get(i).getName())) {
                        // getName the corresponding building_id
                        hotelId = getAllRestaurants.get(i).getId();
                    }
                }
                extras.putInt("ID", (hotelId));
                Log.d("id in list", Integer.toString(hotelId));
                intent.putExtras(extras);
                startActivity(intent);

            }
        });

    }
}


