package com.horrornumber1.horrordepartment.Network;

/**
 * Created by KIMTAEHO on 2017-08-13.
 */


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.horrornumber1.horrordepartment.Activities.FirstLogo;
import com.horrornumber1.horrordepartment.DataModel.Box;
import com.horrornumber1.horrordepartment.Module.Comp;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.Collections;

/**
 * Created by 김태호 on 2017-02-15.
 */

public class Download extends IntentService {

    public static final String RESPONSE_MESSAGE = "ResponseMessage";
    public static final String MYURL = "http://13.125.102.246:8080/horrormagazine/conn";
    public RequestQueue requestQueue;
    public Download() {
        super("download");
    }
    Comp comp = new Comp();
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
                        Collections.sort(DataHouse.region2, comp);

                        DataHouse.millitary2 = DataHouse.box.getBox().get(1).getContent();
                        Collections.sort(DataHouse.millitary2, comp);

                        DataHouse.real2 = DataHouse.box.getBox().get(2).getContent();
                        Collections.sort(DataHouse.real2, comp);

                        DataHouse.college2 = DataHouse.box.getBox().get(3).getContent();
                        Collections.sort(DataHouse.college2, comp);

                        //DataHouse.cartoon2 = DataHouse.box.getBox().get(4).getContent();

                        DataHouse.lore2 = DataHouse.box.getBox().get(4).getContent();
                        Collections.sort(DataHouse.lore2, comp);

                        DataHouse.understand2 = DataHouse.box.getBox().get(5).getContent();
                        Collections.sort(DataHouse.understand2, comp);

                        DataHouse.city2 = DataHouse.box.getBox().get(6).getContent();
                        Collections.sort(DataHouse.city2, comp);

                        DataHouse.togo2 = DataHouse.box.getBox().get(7).getContent();
                        Collections.sort(DataHouse.togo2, comp);

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
