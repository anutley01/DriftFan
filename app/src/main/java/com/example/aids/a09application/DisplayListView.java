package com.example.aids.a09application;

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

public class DisplayListView extends Fragment {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    StandingsAdapter standingsAdapter;
    ListView listView;
    WebView webView;
    String url;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.display_list_view_layout, container, false);

        webView = (WebView) view.findViewById(R.id.webviewNews);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        url = Uri.parse("http://163.172.142.145/driver_view.php").toString();
        webView.loadUrl(url);
        return view;
    }

}



