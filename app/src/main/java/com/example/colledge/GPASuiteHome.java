package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GPASuiteHome extends AppCompatActivity {

    private Course[] courses;
    private int numCourses;
    public int currCourse;

    public class Course{
        private assignment[] asg;
        private double[] typeWeights;
        private String[] typeNames;
        private String name;
        private char letterGrade;
        private double grade;
        private int numTypes;
        private int numAssigns;

        public Course(String n){
            name = n;
            typeWeights = new double[15];
            typeNames = new String[15];
            letterGrade = 'F';
            grade = 0;
            asg = new assignment[50];
            numTypes = 0;
            numAssigns = 0;
        }

        public boolean addGradeType(String n, double w){
            for(int i=0;i<typeNames.length;i++)
            {
                if(typeNames[i].equals(n))
                    return false;
            }
            typeWeights[numTypes] = w;
            typeNames[numTypes] = n;
            numTypes++;
            return true;
        }

        public void addAssignment(String t, double poss, double e){
            asg[numAssigns] = new assignment(t, poss, e);
            numAssigns++;
        }

        private double calcGrade(){
            double runningTotal;
            double[] typePoss = new double[numTypes];
            double[] typeEarned = new double[numTypes];

            for(int i=0; i<numAssigns;i++){
                for(int j=0;j<numTypes;j++) {
                    if (asg[i].type.equals(typeNames[j])) {
                        typePoss[j] += asg[i].possible;
                        typeEarned[j] += asg[i].earned;
                        break;
                    }
                }
            }
            runningTotal = 0;
            for(int i=0;i<numTypes;i++)
            {
                runningTotal = runningTotal + ((typeEarned[i]/typePoss[i])*typeWeights[i]);
            }
            return runningTotal;
        }
    }

    public class assignment{
        public String type;
        public double possible;
        public double earned;

        public assignment(String t, double poss, double e){
            type=t;
            possible=poss;
            earned = e;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpasuite_home);
        courses = new Course[50];
        numCourses = 0;
        currCourse = 0;
    }

    public void createCourse(View view){
        TextView name = findViewById(R.id.newCourseName);
        Course newest = new Course(name.getText().toString());
        System.out.println(newest.name);
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
            out = out + "\n" +courses[i].name;

        return out;
    }

    public void UpdateCourseListing(View view){
        TextView viewer = findViewById(R.id.displaysCourses);
        viewer.setText(courses[currCourse].name);
        currCourse++;
        if(currCourse == numCourses)
            currCourse = 0;
    }
}
