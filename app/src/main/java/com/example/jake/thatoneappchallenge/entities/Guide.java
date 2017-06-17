package com.example.jake.thatoneappchallenge.entities;

import org.json.JSONObject;

/**
 * Created by Jake on 6/16/2017.
 */

public class Guide {

    String mName, mStartDate, mEndDate, mUrl, mIconUrl;
    Venue mVenue;

    public Guide(String pName, String pStartDate, String pEndDate, String pUrl, String pIconUrl, Venue pVenue){
        this.mName = pName;
        this.mStartDate = pStartDate;
        this.mEndDate = pEndDate;
        this.mUrl = pUrl;
        this.mIconUrl = pIconUrl;
        this.mVenue = pVenue;
    }

    public String getName(){
        return mName;
    }

    public String getStartDate(){
        return mStartDate;
    }

    public String getEndDate(){
        return mEndDate;
    }

    public String getUrl(){
        return mUrl;
    }

    public String getIconUrl(){
        return mIconUrl;
    }

    public Venue getVenue(){
        return mVenue;
    }

}
