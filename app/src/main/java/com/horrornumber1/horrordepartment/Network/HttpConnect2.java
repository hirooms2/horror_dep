package com.horrornumber1.horrordepartment.Network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by KIMTAEHO on 2017-08-16.
 */

public class HttpConnect2 {
    Context ctx;
    String url;

    public HttpConnect2(Context ctx){
        this.ctx = ctx;

    }
    public void connect(final int size, final int position ){
        url = "http://13.124.22.112:8080/horrormagazine/errormsg?size="+size+"&position="+position;
        RequestQueue postReqeustQueue = Volley.newRequestQueue(ctx);
        StringRequest postStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        postReqeustQueue.add(postStringRequest);
    }

}
