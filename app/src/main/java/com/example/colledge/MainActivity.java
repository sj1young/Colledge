package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGPA(View view){
        Intent intent = new Intent(this, GPASuiteHome.class);
        startActivity(intent);
    }

    public void startBus(View view){
        Intent intent = new Intent(this, ScheduleViewer.class);
        startActivity(intent);
    }
}
