package com.horrornumber1.horrordepartment.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.horrornumber1.horrordepartment.CounsilClass.Counsil;
import com.horrornumber1.horrordepartment.DataModel.Box;
import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.Module.DBManager;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {


    ImageView majorImg, councilImg, email, horrorChannel;
    ImageView sound, notification;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataHouse.uid = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        notification = (ImageView)findViewById(R.id.notification);

        //************************SQLite************************************************************
        DataHouse.dbManager = new DBManager(getApplicationContext(), "myDB", null, 4);

        if(DataHouse.dbManager.Notification()){
            FirebaseMessaging.getInstance().subscribeToTopic("news");
            notification.setImageResource(R.drawable.notification);
        } else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("news");
            notification.setImageResource(R.drawable.notification_off);
        }
        notification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(DataHouse.dbManager.Notification()){
                    Toast.makeText(getApplicationContext(),"푸시알림을 받지 않습니다", Toast.LENGTH_SHORT).show();
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("news");
                    DataHouse.dbManager.update("UPDATE NOTIFICATION SET ck = 0");
                    notification.setImageResource(R.drawable.notification_off);
                } else {
                    Toast.makeText(getApplicationContext(),"푸시알림을 받습니다", Toast.LENGTH_SHORT).show();
                    FirebaseMessaging.getInstance().subscribeToTopic("news");
                    DataHouse.dbManager.update("UPDATE NOTIFICATION SET ck = 1");
                    notification.setImageResource(R.drawable.notification);
                }
            }
        });

        //************************BackGround Music*************************************************
        DataHouse.mp = MediaPlayer.create(this, R.raw.bgm);
        DataHouse.mp.setLooping(true);
        if(DataHouse.musicCheck)
            DataHouse.mp.start();

        majorImg = (ImageView)findViewById(R.id.majorImg);
        majorImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Board.class);
                startActivity(intent);
            }
        });

        councilImg = (ImageView) findViewById(R.id.councilImg);
        councilImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Counsil.class);
                startActivity(intent);

            }
        });

        horrorChannel = (ImageView) findViewById(R.id.horrorChannel);
        horrorChannel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HorrorChannel.class);
                startActivity(intent);

            }
        });

        email = (ImageView) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Email.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        sound = (ImageView) findViewById(R.id.sound);

        sound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (DataHouse.musicCheck) {
                    sound.setImageResource(R.drawable.sound_off);
                    DataHouse.musicCheck = false;
                    DataHouse.mp.pause();
                } else {
                    sound.setImageResource(R.drawable.sound_on);
                    DataHouse.musicCheck = true;
                    DataHouse.mp.start();
                }
            }
        });
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, LastLogo.class);
        startActivity(intent);
    }

    @Override
    protected void onUserLeaveHint(){
        if(DataHouse.mp.isPlaying())
            DataHouse.mp.pause();
        super.onUserLeaveHint();
    }


    //재개
    @Override
    public void onResume(){
        RequestQueue requestQueue;
        String MYURL = "http://13.124.22.112:8080/horrormagazine/conn";
        final Comp comp = new Comp();
        if(DataHouse.box.getBox()==null){

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


                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("error", "onErrorResponse: " + error.getMessage());
                            DialogSimple();
                        }

                    }
            );
            requestQueue.add(stringRequest);
        }

        if (DataHouse.musicCheck) {
            sound.setImageResource(R.drawable.sound_on);
        } else {
            sound.setImageResource(R.drawable.sound_off);
        }
        if(DataHouse.musicCheck) {
            try {
                DataHouse.mp.start();
            } catch (NullPointerException e) {
                DataHouse.mp = MediaPlayer.create(this, R.raw.bgm);
                DataHouse.mp.setLooping(true);
                DataHouse.mp.start();
            }
        }

        super.onResume();
    }
    //끝날때
    @Override
    public void onDestroy(){
        DataHouse.mp.stop();
        super.onDestroy();
    }

    private void DialogSimple(){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setMessage("네트워크 연결이 불안정합니다").setCancelable(
                false).setPositiveButton("닫기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'Yes' Button
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);;
                    }
                });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }
}
