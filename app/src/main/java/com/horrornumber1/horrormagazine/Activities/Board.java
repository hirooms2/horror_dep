package com.horrornumber1.horrormagazine.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.horrornumber1.horrormagazine.Adapters.TabPagerAdapter;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.SetView.SetTextView;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

public class Board extends AppCompatActivity {
//
    public static String PARAM_INPUT_NAME = "input name";

    Menu absmenu;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        //************************BackGround Music*************************************************
        DataHouse.mp = MediaPlayer.create(this, R.raw.bgm);
        DataHouse.mp.setLooping(true);
        if(DataHouse.musicCheck)
            DataHouse.mp.start();

       // Intent intent = getIntent();
       // name = intent.getStringExtra(PARAM_INPUT_NAME);
        name ="군대괴담";
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

        //***************************************tab************************************************
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("지역"));
        tabLayout.addTab(tabLayout.newTab().setText("군대"));
        tabLayout.addTab(tabLayout.newTab().setText("실화"));
        tabLayout.addTab(tabLayout.newTab().setText("대학"));
        //tabLayout.addTab(tabLayout.newTab().setText("만화"));
        tabLayout.addTab(tabLayout.newTab().setText("로어"));
        tabLayout.addTab(tabLayout.newTab().setText("이무이"));
        tabLayout.addTab(tabLayout.newTab().setText("도시"));

        //ViewPager Fragment
        final ViewPager viewPager= (ViewPager) findViewById(R.id.board_viewpager);
        Log.i("count", Integer.toString(tabLayout.getTabCount()));
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(whichContents(name));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.i("test", Integer.toString(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        SetTextView setTextView = new SetTextView(getApplicationContext(), this);
        setTextView.BoardFont();
    }

    private int whichContents(String name) {
        switch (name) {
            case "지역괴담":
                return 0;
            case "군대괴담":
                return 1;
            case "실제이야기":
                return 2;
            case "대학괴담":
                return 3;
            //case "4컷 만화":
            //    return 4;
            case "로어":
                return 4;
            case "이해하면 무서운 이야기":
                return 5;
            case "도시괴담":
                return 6;
        }
        return 0;
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
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

    //**************************Background Music****************************************************

    @Override
    protected void onUserLeaveHint(){
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

        if(DataHouse.musicCheck)
            DataHouse.mp.start();

        super.onResume();
    }

}
