package com.example.aids.a09application;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


/*public class myAccountFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }

}*/
public class myAccountFragment extends Activity {
    EditText password1 = (EditText) findViewById(R.id.firstPassword);
    EditText password2 = (EditText) findViewById(R.id.secondPassword);
    TextView passwordMatch = (TextView) findViewById(R.id.PasswordMatch);
    SeekBar priceRange = (SeekBar) findViewById(R.id.seekBarPrice);
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_account);
        checkPasswordsMatch();

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        EditText password1 = (EditText) findViewById(R.id.firstPassword);
        View view =  inflater.inflate(R.layout.fragment_my_account, container, false);
        checkPasswordsMatch();
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
    public void checkPasswordsMatch(){
        if(password1.equals(password2)){
            passwordMatch.setText("Passwords match");
        } else {
            passwordMatch.setText("Passwords do not match");
        }}


    public void dataFromSeekbar(){
        int price = priceRange.getProgress();


    }




}
