package com.example.jake.thatoneappchallenge.managers;

import com.example.jake.thatoneappchallenge.entities.Guide;
import com.example.jake.thatoneappchallenge.parsers.DataResponseParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Jake on 6/16/2017.
 */

public class GuideManager {
    private static GuideManager instance = null;
    protected  GuideManager(){

    }

    public static GuideManager getInstance(){
        if (instance == null){
            instance = new GuideManager();
        }
        return instance;
    }


    public List<Guide> getItemLists(String data) throws JSONException {
        return DataResponseParser.getInstance().parseResponse(new JSONObject(data));
    }
}
