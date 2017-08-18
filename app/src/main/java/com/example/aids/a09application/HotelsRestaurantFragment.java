package com.example.aids.a09application;
import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Connor on 17/08/2017.
 */

public class HotelsRestaurantFragment extends Activity {

    String myJSON;

    private static final String TAG_RESULTS="result";
    private static final String TAG_ID = "hotel_id";
    private static final String TAG_HOTEL_NAME = "hotel_name";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_LAT ="latitude";
    private static final String TAG_LONGITUDE = "longitude";
    private static final String TAG_PRICE = "price";
    private static final String TAG_VENUE_ID = "venue_id";

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_accommodation_eateries);
        list = (ListView) findViewById(R.id.listView1);
        personList = new ArrayList<HashMap<String,String>>();
        getData();
    }

    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost("http://163.172.142.145/phpmyadmin/");

                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops
                }
                finally {
                    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                myJSON=result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }
    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_HOTEL_NAME);

            for(int loopCounter=0;loopCounter<peoples.length();loopCounter++){
                JSONObject c = peoples.getJSONObject(loopCounter);
                String id = c.getString(TAG_ID);
                String name = c.getString(TAG_HOTEL_NAME);
                String phone = c.getString(TAG_PHONE);

                HashMap<String,String> hotels = new HashMap<String,String>();

                hotels.put(TAG_ID,id);
                hotels.put(TAG_HOTEL_NAME,name);
                hotels.put(TAG_PHONE,phone);

                personList.add(hotels);
            }

            ListAdapter adapter = new SimpleAdapter(
                    HotelsRestaurantFragment.this, personList, R.layout.list_item,
                    new String[]{TAG_ID,TAG_HOTEL_NAME,TAG_PHONE},
                    new int[]{R.id.hotel_id, R.id.hotel_name, R.id.hotel_phone}
            );

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}


