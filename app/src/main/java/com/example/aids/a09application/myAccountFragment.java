package com.example.aids.a09application;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class myAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        EditText password1 = (EditText) view.findViewById(R.id.firstPassword);
        EditText password2 = (EditText) view.findViewById(R.id.secondPassword);
        TextView passwordMatch = (TextView) view.findViewById(R.id.PasswordMatch);
        SeekBar priceRange = (SeekBar) view.findViewById(R.id.seekBarPrice);
        return view;
    }
}

