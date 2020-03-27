package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Courses extends AppCompatActivity {
    private Course[] courses;
    private int numCourses;
    public int currCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        courses = new Course[50];
        numCourses = 0;
        currCourse = 0;
    }

    public void createCourse(View view){
        TextView name = findViewById(R.id.newCourseName);
        Course newest = new Course(name.getText().toString());
        System.out.println(newest.getName());
        /*
            Really need to update this later
            make sure there aren't too many courses
         */
        courses[numCourses] = newest;
        numCourses++;
    }

    public String coursesToString()
    {
        String out = "";
        for(int i=0;i<numCourses;i++)
            out = out + "\n" +courses[i].getName();

        return out;
    }

    public void nextCourse(View view){
        currCourse++;
        if(currCourse == numCourses)
            currCourse = 0;
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[currCourse].getName());
    }

    public void prevCourse(View view){
        currCourse--;
        if(currCourse < 0)
            currCourse = numCourses;
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[currCourse].getName());

    }
}
