package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GPASuiteHome extends AppCompatActivity {

    public class course{
        private assignment[] asg;
        private double[] typeWeights;
        private String[] typeNames;
        private String name;
        private char letterGrade;
        private double grade;
        private int numTypes;
        private int numAssigns;

        public course(String n){
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
    }
}
