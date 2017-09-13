package com.example.aids.a09application;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class DisplayListView extends Activity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    StandingsAdapter standingsAdapter;
    ListView listView;
    WebView webView;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_list_view_layout);


    webView = (WebView) findViewById(R.id.webviewStandings);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        url = Uri.parse("http://www.idcnation.com/standings/").toString();
        webView.loadUrl(url);
    }

}



