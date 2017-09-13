package com.example.aids.a09application;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Author: Matthew/Connor
 */


public class myAccountFragment extends Fragment {
    //declare buttons
    Button btnLogin, btnRegister;
    //inflate layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_account, container, false);


        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        //start an intent to the LoginActivity class
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myAccountFragment.this.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        // start an intent to the RegisterActivity class
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myAccountFragment.this.getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}