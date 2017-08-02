package com.example.aids.a09application;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.aids.a09application.R.id.submitButton;


/*public class myAccountFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }

}*/
public class myAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        EditText password1 = (EditText) view.findViewById(R.id.firstPassword);
        EditText password2 = (EditText) view.findViewById(R.id.secondPassword);
        TextView passwordMatch = (TextView) view.findViewById(R.id.PasswordMatch);
        SeekBar priceRange = (SeekBar) view.findViewById(R.id.seekBarPrice);
        TextView seekBarData = (TextView) view.findViewById(R.id.seekBarData);
        Button submitData = (Button) view.findViewById(submitButton);
        submitData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onButtonPressed();
            }
        });
        return view;
    }

    /* @Override
         public void onCreate(Bundle savedInstanceState){
             super.onCreate(savedInstanceState);
             setContentView(R.layout.fragment_my_account);
             checkPasswordsMatch();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }

    /* @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle   savedInstanceState) {
         View view =  inflater.inflate(R.layout.secondefragment, container, false);
         mWebView = (WebView) view.findViewById(R.id.activity_main_webview);
         progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);

         WebSettings webSettings = mWebView.getSettings();
         webSettings.setJavaScriptEnabled(true);
         mWebView.loadUrl("http://www.google.com");

         return view;


     }
 */
    public void checkPasswordsMatch(EditText password1, EditText password2, TextView passwordMatch){
        if(password1.getText().toString().equals(password2.getText().toString())){
            passwordMatch.setText("Passwords match");
        } else {
            passwordMatch.setText("Passwords do not match");
        }}

    /*
    Testing seekbar

     */
    public void dataFromSeekbar(SeekBar priceRange, TextView seekBarData){

        Integer price = priceRange.getProgress();
        String priceString = price.toString();
        seekBarData.setText(price);

    }


    public void onPause(){
        myAccountFragment.super.onPause();
    }

    public void setButtonClickListener(){

    }

    /**
     * This method will handle the push to the database
     */
    public void onButtonPressed(){
        toastDataSubmission();

    }

    /**
     * This method displays a toast to let the user know the data has been submitted
     */
    public void toastDataSubmission(){
        Context contextForSubmitButton = getContext();
        CharSequence message = "Data Submitted";
        int duration = Toast.LENGTH_LONG;
        Toast toastBasic = Toast.makeText(contextForSubmitButton,message,duration); toastBasic.show();
    }

}