package com.example.jake.thatoneappchallenge.parsers;

import com.example.jake.thatoneappchallenge.entities.Guide;
import com.example.jake.thatoneappchallenge.entities.Venue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jake on 6/16/2017.
 */

final public class DataResponseParser {
    private static DataResponseParser instance = null;
    protected  DataResponseParser(){

    }

    public static DataResponseParser getInstance(){
        return instance == null ? new DataResponseParser() : instance;
    }

    public List<Guide> parseResponse(JSONObject result) throws JSONException {

        JSONArray dataArray;
        JSONObject responseObject;
        String resultString;
        Guide guide;
        List<Guide> guideArray;

        dataArray = result.getJSONArray("data");
        guideArray = new ArrayList<Guide>();
        for (int i = 0; i < dataArray.length(); i++){
            guideArray.add(parseGuide(dataArray.getJSONObject(i)));
        }
        return guideArray;
    }

    private Guide parseGuide(JSONObject object) throws JSONException{
        String name, startDate, endDate, url, photoUrl, city, state;
        JSONObject venueObject;
        Venue venue;

        name = object.getString("name");
        startDate = object.getString("startDate");
        endDate = object.getString("endDate");
        url = object.getString("url");
        venueObject = object.getJSONObject("venue");
        city = venueObject.optString("city", "No");
        state = venueObject.optString("state", "Venue");
        photoUrl = object.getString("icon");
        venue = new Venue(city, state);

        return new Guide(name, startDate,  endDate, url, photoUrl, venue);
    }
}