package com.horrornumber1.horrordepartment.Network;

/**
 * Created by KIMTAEHO on 2017-08-13.
 */


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
import com.horrornumber1.horrordepartment.Activities.FirstLogo;
import com.horrornumber1.horrordepartment.DataModel.Box;
import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.Collections;
import java.util.Comparator;

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
                        Collections.sort(DataHouse.region2, new Comp());

                        DataHouse.millitary2 = DataHouse.box.getBox().get(1).getContent();
                        Collections.sort(DataHouse.millitary2, new Comp());

                        DataHouse.real2 = DataHouse.box.getBox().get(2).getContent();
                        Collections.sort(DataHouse.real2, new Comp());

                        DataHouse.college2 = DataHouse.box.getBox().get(3).getContent();
                        Collections.sort(DataHouse.college2, new Comp());

                        //DataHouse.cartoon2 = DataHouse.box.getBox().get(4).getContent();

                        DataHouse.lore2 = DataHouse.box.getBox().get(4).getContent();
                        Collections.sort(DataHouse.lore2, new Comp());

                        DataHouse.understand2 = DataHouse.box.getBox().get(5).getContent();
                        Collections.sort(DataHouse.understand2, new Comp());

                        DataHouse.city2 = DataHouse.box.getBox().get(6).getContent();
                        Collections.sort(DataHouse.city2, new Comp());

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

    class Comp implements Comparator<Model> {
        @Override
        public int compare(Model o1, Model o2) {
            int a = Integer.parseInt(o1.getDate());
            int b = Integer.parseInt(o2.getDate());
            if(a < b)
                return 1;
            else if (a==b)
                return 0;
            else
                return -1;
        }

    }


}
