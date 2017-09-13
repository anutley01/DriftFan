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



public class RestaurantList extends Activity {
    //declaration of variables
    ListView restaurantList;
    SQLHelper db = new SQLHelper(this);
    List<Hotel> getAllRestaurants;
    ArrayAdapter<String> adapter;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        restaurantList = (ListView) findViewById(R.id.hotel_listView);
        //unparcels the extras
        Bundle b = getIntent().getExtras();
        String near_to = b.getString("NEAR_TO");
        getAllRestaurants = db.getAllRestaurants(near_to);
        db.close();

        // set up ArrayList for restaurantNames
        final List<String> restaurantNames = new ArrayList<>();

        //loop through all restaurants and add to list
        for (int i = 0; i < getAllRestaurants.size(); i++) {
            restaurantNames.add(getAllRestaurants.get(i).getName());

        }

        // set up adapter and populate list
        adapter = new ArrayAdapter<>(RestaurantList.this, android.R.layout.simple_list_item_1, restaurantNames);
        restaurantList.setAdapter(adapter);
        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RestaurantList.this, RestaurantGenerator.class);
                Bundle extras = new Bundle();
                int hotelId = 1;
                String nearTo = "None";
                String restaurantName = adapter.getItem(position);

                for (int i = 0; i < getAllRestaurants.size(); i++) {
                    if (restaurantName.equals(getAllRestaurants.get(i).getName())) {
                        // getName the corresponding building_id
                        hotelId = getAllRestaurants.get(i).getId();
                        nearTo = getAllRestaurants.get(i).getNearTo();
                    }
                }
                //pass extras to next activity
                extras.putInt("ID", (hotelId));
                Log.d("id in list", Integer.toString(hotelId));
                extras.putString("NEAR_TO", (nearTo));
                intent.putExtras(extras);
                startActivity(intent);

            }
        });

    }
}


