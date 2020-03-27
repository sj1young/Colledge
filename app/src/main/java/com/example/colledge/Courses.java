package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

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

    public void startAssignEditor(View view){
        Intent intent = new Intent(this, AssignmentEditor.class);
        intent.putExtra("activeCourse",courses[currCourse]);
        startActivity(intent);
    }

    public Course getActiveCourse(){
        return courses[currCourse];
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
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[numCourses-1].getName());
    }

    public String coursesToString()
    {
        String out = "";
        for(int i=0;i<numCourses;i++)
            out = out + "\n" +courses[i].getName();

        return out;
    }

    public void nextCourse(View view){
        if(numCourses==0) {
            TextView viewer = findViewById(R.id.displaysCourses);
            viewer.setText("No Current Courses");
            return;
        }
        currCourse++;
        if(currCourse == numCourses)
            currCourse = 0;
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[currCourse].getName());
    }

    public void prevCourse(View view){
        if(numCourses==0) {
            TextView viewer = findViewById(R.id.displaysCourses);
            viewer.setText("No Current Courses");
            return;
        }
        currCourse--;
        if(currCourse < 0)
            currCourse = numCourses;
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[currCourse].toString());

    }
}
