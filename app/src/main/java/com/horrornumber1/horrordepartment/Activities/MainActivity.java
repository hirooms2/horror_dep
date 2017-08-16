package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.horrornumber1.horrordepartment.CounsilClass.Counsil;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

public class MainActivity extends AppCompatActivity {


    ImageView majorImg, councilImg, keepImg, magazineImg;
    ImageView sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         DataHouse.uid = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

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

        magazineImg = (ImageView)findViewById(R.id.magazineImg);
        magazineImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MagazineActivity.class);
                startActivity(intent);
            }
        });

        keepImg = (ImageView) findViewById(R.id.keepImg);
        keepImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Favorite.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
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

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
//        mDemoSlider.stopAutoCycle();
        super.onStop();
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
        if (DataHouse.musicCheck) {
            sound.setImageResource(R.drawable.sound_on);
        } else {
            sound.setImageResource(R.drawable.sound_off);
        }
        if(DataHouse.musicCheck)
            DataHouse.mp.start();

        super.onResume();
    }
    //끝날때
    @Override
    public void onDestroy(){
        DataHouse.mp.stop();
        super.onDestroy();
    }
}
