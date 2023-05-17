package com.example.xtypee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A simple {@link Fragment} subclass.

 */
public class ForoFragment extends Fragment {

    WebView webView;

    public ForoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foro, container, false);
        webView = view.findViewById(R.id.webviewId);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://ananoemimg2.discussion.community/");

        return view;
    }
}