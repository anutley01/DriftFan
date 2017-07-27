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
 * Created by Aids on 27/07/2017.
 */

public class ShopFragment extends Fragment {

    private WebView webView;
    String url = "https://www.driftgames.life/collections/irish-drift-championship";


    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        webView = (WebView) view.findViewById(R.id.webview1);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        url = Uri.parse("https://www.driftgames.life/collections/irish-drift-championship").toString();
        webView.loadUrl(url);
        return view;
    }

}












