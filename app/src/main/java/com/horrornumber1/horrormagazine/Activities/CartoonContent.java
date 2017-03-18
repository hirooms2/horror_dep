package com.horrornumber1.horrormagazine.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.Fragments.ContentCartoonFragment;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

public class CartoonContent extends AppCompatActivity {

    public static final String PARAM_INPUT_MESSAGE = "input_message";
    public int num;
    FrameLayout alert;
    TextView btn_previous, btn_next;
    Menu absmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon_content);

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
        TextView cartoon_toolbar_title = (TextView) findViewById(R.id.cartoon_toolbar_title);
        cartoon_toolbar_title.setTypeface(yeonsung);

        //*************************************intent***********************************************
        Intent intent = getIntent();

        num = intent.getIntExtra(PARAM_INPUT_MESSAGE, -1);

        //setup prev next button
        btn_previous = (TextView) findViewById(R.id.btn_previous);
        btn_next = (TextView) findViewById(R.id.btn_next);
        if(num==0)
            btn_previous.setVisibility(View.INVISIBLE);
        if(num==DataHouse.cartoon2.size())
            btn_next.setVisibility(View.VISIBLE);

        //alert!!
        alert = (FrameLayout) findViewById(R.id.alertFLayout);
        alert.setFocusable(true);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.setVisibility(View.GONE);
            }
        });


        //ContentCartoonFragment contentCartoonFragment = (ContentCartoonFragment) getSupportFragmentManager().findFragmentById(R.id.cartoon_pager_fragment);
        ContentCartoonFragment contentCartoonFragment = ContentCartoonFragment.newInstance(num);

        getSupportFragmentManager().beginTransaction().replace(R.id.cartoon_pager_fragment_container, contentCartoonFragment).commit();

    }

    public void mOnClick(View v){

        switch( v.getId() ){
            case R.id.btn_previous:
                if(num>0) {
                    ContentCartoonFragment contentCartoonFragment = ContentCartoonFragment.newInstance(--num);
                    getSupportFragmentManager().beginTransaction().replace(R.id.cartoon_pager_fragment_container, contentCartoonFragment).commit();
                }
                if(num == 0) {
                    btn_previous.setVisibility(View.INVISIBLE);
                }
                if(num < DataHouse.cartoon2.size() -1) {
                    btn_next.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.btn_next:
                if(num<DataHouse.cartoon2.size()-1) {
                    ContentCartoonFragment contentCartoonFragment = ContentCartoonFragment.newInstance(++num);
                    getSupportFragmentManager().beginTransaction().replace(R.id.cartoon_pager_fragment_container, contentCartoonFragment).commit();
                }
                if(num == DataHouse.cartoon2.size()-1) {
                    btn_next.setVisibility(View.INVISIBLE);
                }
                if(num > 0) {
                    btn_previous.setVisibility(View.VISIBLE);
                }
        }
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
    public boolean onOptionsItemSelected(MenuItem item)
    {
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
