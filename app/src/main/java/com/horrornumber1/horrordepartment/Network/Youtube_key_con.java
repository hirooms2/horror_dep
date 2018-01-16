package com.horrornumber1.horrordepartment.Network;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.horrornumber1.horrordepartment.DataModel.Youtube_Box;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

/**
 * Created by KIMTAEHO on 2017-08-16.
 */

public class Youtube_key_con {
    String url;
    Context ctx;
    Intent intent;
    Handler handler;
    public Youtube_key_con(Context ctx, Handler handler){
        this.intent = intent;
        this.ctx = ctx;
        this.handler = handler;
    }
    public void connect( ){
        url = "http://13.125.102.246:8080/horrormagazine/youtube_key_conn";
        RequestQueue postReqeustQueue = Volley.newRequestQueue(ctx);
        StringRequest postStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                DataHouse.youtube_box = gson.fromJson(response, Youtube_Box.class);
                handler.sendEmptyMessage(1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(error.getMessage(), "onErrorResponse: ");
                handler.sendEmptyMessage(0);
            }
        });
        postReqeustQueue.add(postStringRequest);
    }

}
