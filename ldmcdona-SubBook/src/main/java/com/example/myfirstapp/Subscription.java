package com.example.myfirstapp;

import java.util.Date;

/**
 * Created by ldmcdona on 1/26/18.
 */

public class Subscription {
    private String name;
    private String date;
    private int cost;
    private String comment;

    public Subscription(String name, String date, int cost){
        this.name = name;
        this.date = date;
        this.cost = cost;
    }

    public Subscription(String name, String date, int cost, String comment){
        this.name = name;
        this.date = date;
        this.cost = cost;
        this.comment = comment;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }

    public int getCost(){
        return cost;
    }

    public String getComment(){
        return comment;
    }

    @Override
    public String toString(){
        return name + '\n' + date + '\n' + "$" + cost;
    }
}
