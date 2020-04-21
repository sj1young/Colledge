package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.sql.SQLOutput;

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

    public void startCourseEdit(View view){
        Intent intent = new Intent(this, Course.class);
        intent.putExtra("activeCourse",courses[currCourse]);
        startActivity(intent);
    }

    public void startGPACalc(View view){
        //System.out.println(coursesToString());
        double gpa = getCumulativeGPA();
        Intent intent = new Intent(this, ShowGPA.class);
        intent.putExtra("gpa",gpa);
        startActivity(intent);
    }

    public Course getActiveCourse(){
        return courses[currCourse];
    }

    public void createCourse(View view){
        TextView name = findViewById(R.id.newCourseName);
        TextView gpa = findViewById(R.id.newCourseGPA);
        TextView credits = findViewById(R.id.newCourseCredits);
        Course newest;
        if(Double.parseDouble(gpa.getText().toString()) != 0)
        {
            newest = new Course(name.getText().toString(), Integer.parseInt(credits.getText().toString()), Double.parseDouble(gpa.getText().toString()));
        }
        else {
            newest = new Course(name.getText().toString(), Integer.parseInt(credits.getText().toString()));
        }

        System.out.println(newest.getName());
        /*
            Really need to update this later
            make sure there aren't too many courses
         */
        courses[numCourses] = newest;
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[numCourses].getName());
        name.setText("");
        gpa.setText("");
        credits.setText("");
        numCourses++;
        currCourse = numCourses;
    }

    public String coursesToString()
    {
        System.out.println("Courses:");
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
        if(currCourse >= numCourses)
            currCourse = 0;
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[currCourse].toString());
    }

    public void prevCourse(View view){
        if(numCourses==0) {
            TextView viewer = findViewById(R.id.displaysCourses);
            viewer.setText("No Current Courses");
            return;
        }
        currCourse--;
        if(currCourse < 0)
            currCourse = numCourses-1;
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[currCourse].toString());

    }

    public Course[] getCourses()
    {
        return courses;
    }

    public double getCumulativeGPA()
    {
        double gradePoints = 0;
        double totalCredits = 0;
        for(int i = 0; i < numCourses; i++)
        {
            Course course = courses[i];
            totalCredits += course.getCredits();
            gradePoints += course.getCredits() * course.getClassGPA();
        }

        return (Math.round((gradePoints/totalCredits) * 100.0) / 100.0);
    }
}
