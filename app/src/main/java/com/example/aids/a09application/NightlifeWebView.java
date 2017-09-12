package com.example.aids.a09application;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Connor on 12/09/2017.
 */

public class NightlifeWebView extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_nightlife);
        Bundle b = getIntent().getExtras();
        String town = b.getString("TOWN");

        WebView nightlifeWebView = (WebView)findViewById(R.id.webviewNightlife);
        nightlifeWebView.getSettings().setJavaScriptEnabled(true);
        nightlifeWebView.setWebViewClient(new WebViewClient());
        if (town.equals("Mondello Park")) {
            String url = Uri.parse("https://www.tripadvisor.co.uk/Attractions-g186614-Activities-c20-County_Kildare.html").toString();
            nightlifeWebView.loadUrl(url);
        } else if (town.equals("Dun Laoghaire")){
            String url = Uri.parse("http://www.dublintourist.com/directory/nightlife/south_county/dun_laoghaire/").toString();
            nightlifeWebView.loadUrl(url);
        } else if (town.equals("Watergrasshill")){
            String url = Uri.parse("http://www.irishtourist.com/directory/nightlife/southwest/cork/east_cork/watergrasshill/").toString();
            nightlifeWebView.loadUrl(url);
        }

    }

}
