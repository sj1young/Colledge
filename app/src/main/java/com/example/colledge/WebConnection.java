package com.example.colledge;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;



public class WebConnection extends Fragment {
    private String URL;
    private Object obj;
    private String arg;
    private View dest;
    private Context parent;

    public WebConnection() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment WebConnection.
     */
    // TODO: Rename and change types and number of parameters
    public static WebConnection newInstance(String url, Object newGuy, String argument,View destination, Context pa) {
        WebConnection fragment = new WebConnection();
        fragment.URL = url;
        fragment.obj = newGuy;
        fragment.arg = argument;
        fragment.dest = destination;
        fragment.parent = pa;
        fragment.connect(fragment.arg,newGuy);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_connection, container, false);
    }


    public Object connect(String arg, Object passed){

        switch (arg){
            case "img":
                WebView web = (WebView)dest;
                web.getSettings().setJavaScriptEnabled(true);
                web.loadUrl("http://docs.google.com/gview?embedded=true&url=" + URL);
        }

        return null;
    }






}
