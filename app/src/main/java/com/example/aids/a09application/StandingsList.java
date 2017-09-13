package com.example.aids.a09application;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;
import static com.example.aids.a09application.R.id.main_container;

/**
 * Created by Aids on 29/08/2017.
 */

public class StandingsList extends Activity implements View.OnClickListener {
    //make member variable is Views
    Button mButton;
    Button mButton1;
    TextView mResult;
    String JSON_RESPONSE;
    String json_string;

    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_standings);


        //get reference of the views
        mButton = (Button) findViewById( R.id.button );
        mButton1 = (Button) findViewById( R.id.buttontwo );
        mResult = (TextView) findViewById( R.id.result );
        mButton1.setOnClickListener(this);

        //when button is clicked
        mButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the getJsonResponse method and fetch the response from the server
                new getJsonResponse().execute();
            }
        } );

    }


        public class getJsonResponse extends AsyncTask<Void, Void, String> {
            String serverUrl;

            public getJsonResponse() {
                mProgressDialog = new ProgressDialog(StandingsList.this);
                mProgressDialog.setMessage( "Please Wait" );
                mProgressDialog.setTitle( "Processing" );
                mProgressDialog.setCancelable( false );
            }

            @Override
            protected void onPreExecute() {

                //set the url from we have to fetch the json response
                serverUrl = "http://163.172.142.145/get_info.php";
                mProgressDialog.show();
            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    URL url = new URL( serverUrl );
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((JSON_RESPONSE = bufferedReader.readLine()) != null) {

                        stringBuilder.append( JSON_RESPONSE + "\n" );

                    }

                    inputStream.close();
                    bufferedReader.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();

                } catch (MalformedURLException e) {
                    Log.e( TAG, "MalformedURLException: " + e ); //print exception message to log
                } catch (IOException e) {
                    Log.e( TAG, "IOException: " + e ); //print exception message to log
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate( values );
            }

            @Override
            protected void onPostExecute(String result) {
                //set the result which is returned by doInBackground() method to result textView
                mResult.setText( result );
                mProgressDialog.dismiss();
                json_string = result;
            }

        }

            public void onClick(View view){

                switch (view.getId()) {
                    case R.id.buttontwo:
                        Intent intent = new Intent(this, DisplayListView.class);
                        startActivity(intent);

                }


            }
        }





