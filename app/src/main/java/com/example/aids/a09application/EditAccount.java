package com.example.aids.a09application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Johnsey on 11-Aug-17.
 */

public class EditAccount extends AppCompatActivity {

    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account);


        String Username = getIntent().getStringExtra("Username");
        username = (TextView) findViewById(R.id.usernameTxt);

        username.setText(Username);



    }
}
