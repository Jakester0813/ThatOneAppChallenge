package com.example.jake.thatoneappchallenge.entities;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.jake.thatoneappchallenge.parsers.DataResponseParser;

/**
 * Created by Jake on 6/16/2017.
 */

public class RequestQueueSingleton{

    RequestQueue mRequestQueue;
    Context context;

    private static RequestQueueSingleton instance = null;
    private  RequestQueueSingleton(Context context){

        this.context = context;

        mRequestQueue = getRequestQueue();
    }

    public static RequestQueueSingleton getInstance(Context context){
        return instance == null ? new RequestQueueSingleton(context) : instance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
