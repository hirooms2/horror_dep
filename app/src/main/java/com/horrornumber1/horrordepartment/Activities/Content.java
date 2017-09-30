package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.horrornumber1.horrordepartment.Adapters.ViewPagerAdapter;
import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.Module.ApplicationController;
import com.horrornumber1.horrordepartment.Module.Which;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.List;

public class Content extends AppCompatActivity {

    public static String PARAM_INPUT_NAME = "input name"; // 이전 Activity에서 넘어올 카테고리 이름
    public static String PARAM_INPUT_INDEX = "input index"; // 이전 Activity에서 넘어올 position 정보 받는 키워드
    public static String PARAM_INPUT_FROM = "input from";

    Menu absmenu; // 볼륨 아이콘을 설정하기 위함
    List<Model> contents;
    String name, from; // content 메뉴
    int position;
    ViewPagerAdapter adapter;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_content);
        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("Content Activity");
        t.send(new HitBuilders.AppViewBuilder().build());

        //*************************************Toolbar**********************************************
        if(absmenu!=null) {
            absmenu.clear();
            onCreateOptionsMenu(absmenu);
            onPrepareOptionsMenu(absmenu);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.content_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);

        Typeface yeonsung = Typeface.createFromAsset(getAssets(), "fonts/YEONSUNG.ttf");
        TextView content_toolbar_title = (TextView) findViewById(R.id.content_toolbar_title);
        content_toolbar_title.setTypeface(yeonsung);

        // **************************************Intent 설정****************************************
        Intent intent = getIntent();                        //Content 창 여는 intent

        name = intent.getStringExtra(PARAM_INPUT_NAME);
        from = intent.getStringExtra(PARAM_INPUT_FROM);
        position = intent.getIntExtra(PARAM_INPUT_INDEX, -1); //키워드에 해당되는 값을 받고 만약 없을시에는 -1로 default

        contents = new Which().whichContents(name); // 이전 Activity 에서 받아온 name을 기반으로 컨텐츠에 띄울 카테고리를 선택

        // *****************************Content Activity의 ViewPager를 설정함***********************
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), name, contents.size());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(0); // 최대 로딩 개수 1 ( 메모리 부담을 줄이기 위함 )
        pager.setCurrentItem(position); // 해당 index의 page로 이동
    }



    // 이전 Activity 에서 받아온 name을 기반으로 컨텐츠에 띄울 카테고리를 선택


    //**************************Background Music****************************************************
    //home_layout key + back button
    @Override
    protected void onUserLeaveHint() {
        if(DataHouse.mp.isPlaying())
            DataHouse.mp.pause();
        super.onUserLeaveHint();
    }
    //재개
    @Override
    public void onResume(){

        if(absmenu!=null) {
            absmenu.clear();
            onCreateOptionsMenu(absmenu);
            onPrepareOptionsMenu(absmenu);
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
    //옵션메뉴 생성
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        absmenu=menu;
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem=menu.findItem(R.id.volumeController);
        if(DataHouse.musicCheck)
            menuItem.setIcon(R.drawable.sound_on);
        else
            menuItem.setIcon(R.drawable.sound_off);
        return true;
    }


    //menu item이 클릭됐을때 실행되는 동작
    //menu item이 클릭됐을때 실행되는 동작
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {

            case android.R.id.home:
                if(from.equals("A")) {
                    Intent intent = new Intent(Content.this, Board.class);
                    intent.putExtra(Board.PARAM_INPUT_NAME, name);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                } else if (from.equals("B"))
                {
                    onBackPressed();
                }

                return true;


            case R.id.volumeController:
                if(DataHouse.musicCheck) {
                    item.setIcon(R.drawable.sound_off);
                    DataHouse.musicCheck=false;
                    DataHouse.mp.pause();
                    return true;
                } else {
                    item.setIcon(R.drawable.sound_on);
                    DataHouse.musicCheck=true;
                    DataHouse.mp.start();
                    return true;
                }
        }

        return super.onOptionsItemSelected(item);
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

    //**************************Background Music****************************************************
}

