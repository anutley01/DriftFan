package com.example.aids.a09application;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Aids on 02/08/2017.
 */

public class NewsFragment extends Fragment {

    WebView webView;
    String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        webView = (WebView) view.findViewById(R.id.webviewNews);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        url = Uri.parse("http://www.idcnation.com/news/").toString();
        webView.loadUrl(url);
        return view;
    }

}


