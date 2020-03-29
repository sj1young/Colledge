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

    public double getCumulativeGPA(Courses courseList)
    {
        double gradePoints = 0;
        double totalCredits = 0;
        for(course : courseList)
        {
            totalCredits += course.getCredits();
            gradePoints += course.getCredits() * course.getClassGPA();
        }

        return (Math.round((gradePoints/totalCredits) * 100.0) / 100.0);
    }

    /*public double getSemesterGPA(Courses[] courseList)
    {

    }*/

}
