package com.example.colledge;

import java.io.Serializable;

public class Assignment implements Serializable {
    public String type;
    public String name;
    public double possible;
    public double earned;

    public Assignment(String n, String t, double poss, double e){
        type=t;
        possible=poss;
        earned = e;
        name = n;
    }
}
