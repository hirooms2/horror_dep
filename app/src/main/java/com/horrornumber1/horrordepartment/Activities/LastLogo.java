package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.horrornumber1.horrordepartment.Module.ApplicationController;
import com.horrornumber1.horrordepartment.R;

public class LastLogo extends AppCompatActivity {

    ImageView logoImg;
    TextView facebook, youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_logo);

        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("LastLogo Activity");
        t.send(new HitBuilders.AppViewBuilder().build());

        logoImg = (ImageView) findViewById(R.id.lastLogo);
        logoImg.setBackgroundResource(R.drawable.last_logo1);

        facebook = (TextView)findViewById(R.id.facebookText);
        youtube = (TextView)findViewById(R.id.youtubeText);


            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
                    t.send(new HitBuilders.EventBuilder().setCategory("BoardTextFragment").setAction("Press Button").setLabel("LastLogo Ad Clicked").build());

                    Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/horrorNo.1/"));

                    startActivity(intent1);

                }
            });
            youtube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
                    t.send(new HitBuilders.EventBuilder().setCategory("BoardTextFragment").setAction("Press Button").setLabel("LastLogo Ad Clicked").build());

                    Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCQbKk4fa3B23YDmVXjv-j4w"));

                    startActivity(intent2);
                }
            });


    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);;
    }
    @Override
    protected void onStart(){
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }
    @Override
    protected void onStop(){
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }
}