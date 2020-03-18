package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

public class ScheduleViewer extends AppCompatActivity {
    private WebConnection busGetter;
    private WebConnection diningGetter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_viewer);
        //busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/61A.pdf",null,"img",findViewById(R.id.busViewer),this);
        //diningGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/61A.pdf",null,"img",findViewById(R.id.DiningViewer),this);
    }

    public void get61AB(View view){
        busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/61A.pdf",null,"img",findViewById(R.id.busViewer),this);
    }

    public void get61CD(View view){
        busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/61C.pdf",null,"img",findViewById(R.id.busViewer),this);
    }

    public void get71AC(View view){
        busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/71A.pdf",null,"img",findViewById(R.id.busViewer),this);
    }

    public void get71BD(View view){
        busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/61C.pdf",null,"img",findViewById(R.id.busViewer),this);
    }

    public void get28(View view){
        busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/28X.pdf",null,"img",findViewById(R.id.busViewer),this);
    }

    public void get54(View view){
        busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/54.pdf",null,"img",findViewById(R.id.busViewer),this);
    }

    public void get58(View view){
        busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/58.pdf",null,"img",findViewById(R.id.busViewer),this);
    }

    public void get8183(View view){
        busGetter = WebConnection.newInstance("https://www.portauthority.org/pdfs/83.pdf",null,"img",findViewById(R.id.busViewer),this);
    }
}
