package com.example.jake.thatoneappchallenge.entities;

/**
 * Created by Jake on 6/16/2017.
 */

public class Venue {

    String mCity, mState;

    public Venue(String pCity, String pState){
        this.mCity = pCity;
        this.mState = pState;
    }

    public String getCity(){
        return mCity;
    }

    public String getState(){
        return mState;
    }
}
