package com.example.colledge;

public class Course {
    private Assignment[] asg;
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
        asg = new Assignment[50];
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

    public void addAssignment(String t,String n, double poss, double e){
        asg[numAssigns] = new Assignment(t, n, poss, e);
        numAssigns++;
    }

    public double calcGrade(){
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

    public String getName(){
        return name;
    }

    public int getNumTypes(){
        return numTypes;
    }

    public int getNumAssigns(){
        return numAssigns;
    }
}

