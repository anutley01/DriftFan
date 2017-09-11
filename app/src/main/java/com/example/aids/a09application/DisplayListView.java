package com.example.aids.a09application;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends Fragment {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    StandingsAdapter standingsAdapter;
    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.display_list_view_layout, container, false );
        listView= (ListView) view.findViewById( R.id.ListViewParse );
        standingsAdapter = new StandingsAdapter(getActivity(),R.layout.row_layout);
        listView.setAdapter( standingsAdapter );
        json_string = getActivity().getIntent().getStringExtra( "json_data" );

        try {
            jsonArray  = new JSONObject(json_string).getJSONArray("server_response");


            int count = 0;

            int driver_id, team_id, position, points;
            String firstName, lastName;

            while(count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                driver_id = JO.getInt( "Driver_id" );
                team_id =JO.getInt( "Team_id" );
                firstName = JO.getString( "First_name" );
                lastName= JO.getString( "Last_name" );
                position= JO.getInt( "Position" );
                points = JO.getInt( "Points" );

                Standings standings = new Standings(driver_id, team_id, firstName, lastName, position, points );
                standingsAdapter.add( standings );
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return view;
    }

}

