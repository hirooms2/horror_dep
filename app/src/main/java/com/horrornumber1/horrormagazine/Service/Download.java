package com.horrornumber1.horrormagazine.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.horrornumber1.horrormagazine.Activities.FirstLogo;
import com.horrornumber1.horrormagazine.DataModel.Box;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

/**
 * Created by 김태호 on 2017-02-15.
 */

public class Download extends IntentService {

    public static final String RESPONSE_MESSAGE = "ResponseMessage";
    public static final String MYURL = "http://13.124.22.112:8080/horrormagazine/conn";
    public RequestQueue requestQueue;
    public Download() {
        super("download");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("Download", "onHandleIntent: start");

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                MYURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        DataHouse.box =  gson.fromJson(response, Box.class);

                        DataHouse.region2 = DataHouse.box.getBox().get(0).getContent();
                        DataHouse.millitary2 = DataHouse.box.getBox().get(1).getContent();
                        DataHouse.real2 = DataHouse.box.getBox().get(2).getContent();
                        DataHouse.college2 = DataHouse.box.getBox().get(3).getContent();
                        //DataHouse.cartoon2 = DataHouse.box.getBox().get(4).getContent();
                        DataHouse.lore2 = DataHouse.box.getBox().get(4).getContent();
                        DataHouse.understand2 = DataHouse.box.getBox().get(5).getContent();
                        DataHouse.city2 = DataHouse.box.getBox().get(6).getContent();

                        Intent broadcastIntent = new Intent();
                        broadcastIntent.setAction(FirstLogo.RequestReceiver.PROCESS_RESPONSE);
                        broadcastIntent.putExtra(RESPONSE_MESSAGE, FirstLogo.RequestReceiver.SUCEESS);
                        sendBroadcast(broadcastIntent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error", "onErrorResponse: " + error.getMessage());
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        Intent broadcastIntent = new Intent();
                        broadcastIntent.setAction(FirstLogo.RequestReceiver.PROCESS_RESPONSE);
                        broadcastIntent.putExtra(RESPONSE_MESSAGE, FirstLogo.RequestReceiver.FAIL);
                        sendBroadcast(broadcastIntent);
                    }
                }
        );
        requestQueue.add(stringRequest);

    }
}
