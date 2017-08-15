package com.example.aids.a09application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


public class LoginActivity extends AppCompatActivity implements AsyncResponse {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap postData = new HashMap();
              //  postData.put("mobile", "android");
                postData.put("txtUsername", etUsername.getText().toString());
                postData.put("txtPassword", etPassword.getText().toString());

                PostResponseAsyncTask loginTask =
                        new PostResponseAsyncTask(LoginActivity.this, postData);
                loginTask.execute("http://163.172.142.145/logintest.php");
            }
        });
    }

    @Override
    public void processFinish(String output) {
        if(output.equals("success")){
            Toast.makeText(this, "Login Successful",
                    Toast.LENGTH_LONG).show();
            String Username = etUsername.getText().toString();
            Intent intent = new Intent(getBaseContext(), EditAccount.class);
            intent.putExtra("Username",Username);
            startActivity(intent);
        }
        else{Toast.makeText(this, "Please Try Again",
                Toast.LENGTH_LONG).show();}
    }
}