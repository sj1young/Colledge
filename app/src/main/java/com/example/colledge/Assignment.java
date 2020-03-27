package com.example.colledge;

public class Assignment{
    public String type;
    public String name;
    public double possible;
    public double earned;

    public Assignment(String t, String n, double poss, double e){
        type=t;
        possible=poss;
        earned = e;
        name = n;
    }
}
