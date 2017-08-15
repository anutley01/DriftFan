package com.example.aids.a09application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


/**
 * Created by Johnsey on 08-Aug-17.
 */

public class RegisterActivity extends AppCompatActivity implements AsyncResponse {
    EditText username, email, password, confirmPassword, firstName, lastName, priceTest;
    TextView passwordMatch, availabilityText;
    SeekBar priceRange, popularity;
    Button submit, checkAvailability;
    int priceValue, popularityValue;
    String emailAddress, emailPattern;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);


        username = (EditText) findViewById(R.id.enterUsername);
        email = (EditText) findViewById(R.id.enterEmail);
        password = (EditText) findViewById(R.id.firstPassword);
        confirmPassword = (EditText) findViewById(R.id.secondPassword);
        firstName = (EditText) findViewById(R.id.enterFirstName);
        lastName = (EditText) findViewById(R.id.enterLastName);
        passwordMatch = (TextView) findViewById(R.id.PasswordMatch);
        priceRange = (SeekBar) findViewById(R.id.seekBarPrice);
        popularity = (SeekBar) findViewById(R.id.busyOrQuiet);
        submit = (Button) findViewById(R.id.submitButton);
        checkAvailability = (Button) findViewById(R.id.availabilityButton);
        // priceTest = (EditText) findViewById(R.id.priceTest);


        priceRange.setMax(2); // 200 maximum value for the Seek bar
        priceRange.setProgress(1); // 50 default progress value
        popularity.setMax(2); // 200 maximum value for the Seek bar
        popularity.setProgress(1); // 50 default progress value

        emailAddress = email.getText().toString().trim();
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

//        email.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d("pattern: ",emailPattern);
//                if (emailAddress.matches(emailPattern)) {
//                    Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


        priceRange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                String priceString = null;
                switch (progressChangedValue) {

                    case 0:
                        priceString = "Cheap";
                        break;
                    case 1:
                        priceString = "50/50";
                        break;
                    case 2:
                        priceString = "Expensive";
                        break;

                }
                priceValue = progressChangedValue;
                Toast.makeText(RegisterActivity.this, priceString,
                        Toast.LENGTH_SHORT).show();
            }
        });

        popularity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                String popularityString = null;
                switch (progressChangedValue) {

                    case 0:
                        popularityString = "Quiet";
                        break;
                    case 1:
                        popularityString = "50/50";
                        break;
                    case 2:
                        popularityString = "Busy";
                        break;

                }
                popularityValue = progressChangedValue;
                Toast.makeText(RegisterActivity.this, popularityString,
                        Toast.LENGTH_SHORT).show();

            }
        });


        checkAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap postData = new HashMap();
                postData.put("username", username.getText().toString());

                PostResponseAsyncTask loginTask =
                        new PostResponseAsyncTask(RegisterActivity.this, postData);
                loginTask.execute("http://163.172.142.145/usernameCheck.php");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Price = Integer.toString(priceValue);
                String Popularity = Integer.toString(popularityValue);

                HashMap postData = new HashMap();
                postData.put("username", username.getText().toString());
                postData.put("firstName", firstName.getText().toString());
                postData.put("lastName", lastName.getText().toString());
                postData.put("password", password.getText().toString());
                postData.put("email", email.getText().toString());
                postData.put("price", Price);
                postData.put("popularity", Popularity);
                PostResponseAsyncTask loginTask =
                        new PostResponseAsyncTask(RegisterActivity.this, postData);

                Log.d("password1: ", password.getText().toString());
                Log.d("password2: ", confirmPassword.getText().toString());
                if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                    loginTask.execute("http://163.172.142.145/test.php");
                } else {
                    Toast.makeText(RegisterActivity.this, "Password's do not match",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public void processFinish(String output) {
        if (output.equals("success")) {
            Toast.makeText(this, "User Added",
                    Toast.LENGTH_LONG).show();
        } else if (output.equals("Username Unavailable")) {
            Toast.makeText(this, "Username Unavailable",
                    Toast.LENGTH_LONG).show();
        } else if (output.equals("Username Available")) {
            Toast.makeText(this, "Username Available",
                    Toast.LENGTH_LONG).show();
        } else if (output.equals("fail")) {
            Toast.makeText(this, "fail",
                    Toast.LENGTH_LONG).show();
        } else if (output.equals("Email Unavailable")) {
            Toast.makeText(this, "Email Unavailable",
                    Toast.LENGTH_LONG).show();
        } else {
            //PROBLEM HERE CHECK IN A BIT - CODE STILL WORKS AND ADDS USERS PERFECTLY FINE
            //TOAST IS WRONG FOR SOME REASON
            //SHOULD BE "PLEASE TRY AGAIN" - MJ
            Toast.makeText(this, "User Added",
                    Toast.LENGTH_LONG).show();
        }
    }


}
