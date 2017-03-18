package com.horrornumber1.horrormagazine.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.horrornumber1.horrormagazine.R;

public class LastLogo extends AppCompatActivity {

    ImageView exitBtn, logoImg;
    int[] images = new int[] {R.drawable.last_logo, R.drawable.last_logo2, R.drawable.last_logo3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_logo);

        logoImg = (ImageView) findViewById(R.id.lastLogo);
        int imageId = (int)(Math.random() * images.length);
        logoImg.setBackgroundResource(images[imageId]);

        logoImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.goodchoice.kr/"));
                startActivity(intent);
            }
        });

        exitBtn = (ImageView)findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);;
    }
}