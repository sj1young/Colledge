package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GPASuiteHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpasuite_home);
    }

    public void startCourses(View view){
        Intent intent = new Intent(this, Courses.class);
        startActivity(intent);
    }

    public void startGPA(View view){
        Intent intent = new Intent(this, Courses.class);
        startActivity(intent);
    }

}
