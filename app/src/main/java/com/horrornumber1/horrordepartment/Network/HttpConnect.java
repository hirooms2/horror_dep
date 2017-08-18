package com.horrornumber1.horrordepartment.Network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by KIMTAEHO on 2017-08-16.
 */

public class HttpConnect {
    Context ctx;
    String url;

    public HttpConnect(Context ctx){
        this.ctx = ctx;
    }
    public void connect(final String uid, final String board, final int no){
        url = "http://13.124.22.112:8080/horrormagazine/likeproc?uid="+uid+"&board="+board+"&no="+no;
        RequestQueue postReqeustQueue = Volley.newRequestQueue(ctx);
        StringRequest postStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("RESPONSE ", response);
                if(response.equals("1")){
                    Toast.makeText(ctx,"추천하였습니다",Toast.LENGTH_SHORT).show();
                } else if(response.equals("0")) {
                    Toast.makeText(ctx, "이미 추천하였습니다", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ctx, "네트워크 연결이 불안정합니다", Toast.LENGTH_SHORT).show();
            }
        });
        postReqeustQueue.add(postStringRequest);
    }

}
