package com.example.jake.thatoneappchallenge.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jake.thatoneappchallenge.R;
import com.example.jake.thatoneappchallenge.entities.Guide;
import com.example.jake.thatoneappchallenge.entities.RequestQueueSingleton;
import com.example.jake.thatoneappchallenge.parsers.DataResponseParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<Guide> guides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guides = getGuides();

    }

    private List<Guide> getGuides(){
        final List<Guide>[] resultGuides = null;
        String url = "https://guidebook.com/service/v2/upcomingGuides/";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            resultGuides[0] = DataResponseParser.getInstance().parseResponse(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        RequestQueueSingleton.getInstance(this).addToRequestQueue(jsObjRequest);

        return resultGuides[0];
    }
}
