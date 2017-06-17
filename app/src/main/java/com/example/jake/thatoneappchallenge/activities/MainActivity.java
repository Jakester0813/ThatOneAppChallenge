package com.example.jake.thatoneappchallenge.activities;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jake.thatoneappchallenge.R;
import com.example.jake.thatoneappchallenge.adapters.GuideAdapter;
import com.example.jake.thatoneappchallenge.entities.Guide;
import com.example.jake.thatoneappchallenge.entities.RequestQueueSingleton;
import com.example.jake.thatoneappchallenge.parsers.DataResponseParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView mGuideRecycler;
    LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGuideRecycler = (RecyclerView) findViewById(R.id.rv_guide);
        mLayoutManager = new LinearLayoutManager(this);
        mGuideRecycler.setLayoutManager(mLayoutManager);
        getGuides(mGuideRecycler);

    }



    private void getGuides(final RecyclerView pGuideRecyclerView){
        String url = "https://guidebook.com/service/v2/upcomingGuides/";


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        List<Guide> guides;
                        try {
                            guides = DataResponseParser.getInstance().parseResponse(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            guides = new ArrayList<Guide>();
                        }
                        GuideAdapter mGuideAdapter = new GuideAdapter(MainActivity.this, guides);
                        pGuideRecyclerView.setAdapter(mGuideAdapter);
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        RequestQueueSingleton.getInstance(this).addToRequestQueue(jsObjRequest);


    }
}
