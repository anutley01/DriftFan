package com.example.aids.a09application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Aids on 27/07/2017.
 */

public class AboutDriftingFragment extends Fragment {

    ImageButton aboutDriftinMoreInfo;

    public AboutDriftingFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_drifting, container, false);
        aboutDriftinMoreInfo = (ImageButton) view.findViewById(R.id.more_info_about);

        aboutDriftinMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.driftworks.com/blog/drifting/"));
                getActivity().startActivity(i);

                Toast.makeText(getActivity(), "Directing to DriftWorks website", Toast.LENGTH_LONG).show();
            }


        });

        return view;
    }


}







