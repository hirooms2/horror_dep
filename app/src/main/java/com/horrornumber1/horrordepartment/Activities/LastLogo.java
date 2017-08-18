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
    TextView facebook, youtube, humor;
    int[] images = new int[] {R.drawable.last_logo1, R.drawable.last_logo2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_logo);

        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("LastLogo Activity");
        t.send(new HitBuilders.AppViewBuilder().build());

        logoImg = (ImageView) findViewById(R.id.lastLogo);
        int imageId = (int)(Math.random() * images.length);
        logoImg.setBackgroundResource(images[imageId]);

        facebook = (TextView)findViewById(R.id.facebookText);
        youtube = (TextView)findViewById(R.id.youtubeText);
        humor = (TextView)findViewById(R.id.humorText);

        if(imageId==0){
            humor.setVisibility(View.GONE);
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
        else{
            facebook.setVisibility(View.GONE);
            youtube.setVisibility(View.GONE);

            humor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
                    t.send(new HitBuilders.EventBuilder().setCategory("BoardTextFragment").setAction("Press Button").setLabel("LastLogo Ad Clicked").build());

                    Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/dept.of.humor/"));

                    startActivity(intent3);
                }
            });
        }



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