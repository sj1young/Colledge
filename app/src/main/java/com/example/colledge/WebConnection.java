package com.example.colledge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class WebConnection extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static int connections = 0;

    // TODO: Rename and change types of parameters
    private String URL;
    private Object obj;
    private String arg;
    private Drawable img;

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
    public static WebConnection newInstance(String url, Object newGuy, String argument) {
        WebConnection fragment = new WebConnection();
        fragment.URL = url;
        fragment.obj = newGuy;
        fragment.arg = argument;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_connection, container, false);
    }

    private class DownloadFromNetwork extends AppCompatActivity {
            public Object doInBackground(String[] args){

                switch (args[0]){
                    case "img":
                        ImageView view = findViewById(R.id.fragImage);
                        String url = args[1];
                }

                return null;
            }





    }
}
