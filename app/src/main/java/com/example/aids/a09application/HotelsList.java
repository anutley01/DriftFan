package com.example.aids.a09application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Connor
 */

public class HotelsList extends AppCompatActivity {
    ListView hotelList;
    SQLHelper db = new SQLHelper(this);
    List<Hotel> getAllHotels;
    ArrayAdapter<String> adapter;
    public static final String [] menu = {"View in maps", "Call"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        hotelList = (ListView) findViewById(R.id.hotel_listView);
        Bundle b = getIntent().getExtras();
        String near_to = b.getString("NEAR_TO");
        getAllHotels = db.getAllHotels(near_to);
        db.close();

        // set up ArrayList for hotelNames
        final List<String> hotelNames = new ArrayList<>();


        for (int i = 0; i < getAllHotels.size(); i++) {
            hotelNames.add(getAllHotels.get(i).getName());

        }

        // set up adapter
        adapter = new ArrayAdapter<>(HotelsList.this, android.R.layout.simple_list_item_1, hotelNames);
        hotelList.setAdapter(adapter);
        hotelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HotelsList.this, HotelsGenerator.class);
                Bundle extras = new Bundle();
                int hotelId = 1;
                String hotelNearTo = "None";
                Object hotelName = adapter.getItem(position);

                for (int i = 0; i < getAllHotels.size(); i++) {
                    if (hotelName.equals(getAllHotels.get(i).getName())) {
                        // get the corresponding building_id
                        hotelId = getAllHotels.get(i).getId();
                        hotelNearTo = getAllHotels.get(i).getNearTo();
                    }
                }
                extras.putInt("ID", (hotelId));
                Log.d("id in list",Integer.toString(hotelId));
                extras.putString("NEAR_TO", (hotelNearTo));
                intent.putExtras(extras);
                startActivity(intent);

            }
            });

    }

}