package com.example.aids.a09application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Map;

import static com.example.aids.a09application.R.id.openMapsButton;

/**
 * Created by Connor on 02/08/2017.
 */

public class OpenMapActivity extends Fragment implements View.OnClickListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_to_event, container, false);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
