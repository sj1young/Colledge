package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

public class ScheduleViewer extends AppCompatActivity {
    private WebConnection busGetter;
    private WebConnection diningGetter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_viewer);
        busGetter = WebConnection.newInstance("sample.url",null,"img");
        diningGetter = WebConnection.newInstance("sample.url",null,"img");
    }

}
