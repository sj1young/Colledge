package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowGPA extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        Intent intent = getIntent();
        double gpa = (double)intent.getSerializableExtra("gpa");

        TextView viewer = findViewById(R.id.dispGPA);
        String txt = "" + gpa;
        viewer.setText(txt);
    }
}
