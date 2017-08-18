package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.horrornumber1.horrordepartment.Adapters.CustomPagerAdapter;
import com.horrornumber1.horrordepartment.Module.ApplicationController;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

public class MagazineActivity extends AppCompatActivity {
    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    Menu absmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);

        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("Magazine Activity");
        t.send(new HitBuilders.AppViewBuilder().build());

        mCustomPagerAdapter = new CustomPagerAdapter(this);

        mViewPager = (ViewPager) findViewById(R.id.magazine_pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

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

    public void refresh() {
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        startActivity(intent);
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
