package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.horrornumber1.horrordepartment.Adapters.FavoriteListViewAdapter;
import com.horrornumber1.horrordepartment.ApplicationController;
import com.horrornumber1.horrordepartment.DataModel.FavoriteModel;
import com.horrornumber1.horrordepartment.DataModel.MyData;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.ArrayList;
import java.util.List;

public class Favorite extends AppCompatActivity implements FavoriteListViewAdapter.ListBtnClickListener{

    Menu absmenu;
    TextView textView;
    ListView listView;
    ArrayList<FavoriteModel> list = new ArrayList<>();
    int position;
    String board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("Favorite Activity");
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

        //******************************************************************************************



        list=DataHouse.dbManager.PrintAll();
        listView = (ListView) findViewById(R.id.favorite_listview);
        FavoriteListViewAdapter adapter = new FavoriteListViewAdapter(getApplicationContext(), list, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Favorite.this, Content.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Content.PARAM_INPUT_NAME, whichBoard(list.get(i).getBoard()));
                intent.putExtra(Content.PARAM_INPUT_FROM, "A");
                List<MyData> contents = whichContents(whichBoard(list.get(i).getBoard()));
                for(int j = 0; j< contents.size() ; j++) {
                    Log.i("test", contents.get(j).getTitle());
                    if(contents.get(j).getTitle().equals(list.get(i).getTitle())) {
                        position = j;
                        break;
                    }
                }
                intent.putExtra(Content.PARAM_INPUT_INDEX, position);
                intent.putExtra("fromFavorite",1);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onListBtnClick(int position) {
        DataHouse.dbManager.delete("delete from '" + list.get(position).getBoard() + "' where title = '" + list.get(position).getTitle() + "';");
        Toast.makeText(getApplicationContext(), "삭제되었습니다", Toast.LENGTH_SHORT).show();
        refresh();
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

    private String whichBoard(String str) {

        switch (str) {
            case "REGION":
                return "지역괴담";
            case "MILLITARY":
                return "군대괴담";
            case "REAL":
                return "실제이야기";
            case "COLLEGE":
                return "대학괴담";
            case "LORE":
                return "로어";
            case "UNDERSTAND":
                return "이해하면 무서운 이야기";
            case "CITY":
                return "도시괴담";
        }
        return null;
    }

    private List<MyData> whichContents(String name) {
        List<MyData> contents = new ArrayList<>();
        switch (name) {
            case "지역괴담":
                contents = DataHouse.region;
                return contents;
            case "군대괴담":
                contents = DataHouse.millitary;
                return contents;
            case "실제이야기":
                contents = DataHouse.real;
                return contents;
            case "대학괴담":
                contents = DataHouse.college;
                return contents;
            case "4컷 만화":
                contents = DataHouse.understand;
                return contents;
            case "로어":
                contents = DataHouse.lore;
                return contents;
            case "이해하면 무서운 이야기":
                contents = DataHouse.understand;
                return contents;
            case "도시괴담":
                contents = DataHouse.city;
                return contents;
        }
        return contents;
    }
    private String whichTable(String name)
    {
        switch (name)
        {
            case "지역괴담":
                return "REGION2";
            case "군대괴담":
                return "MILLITARY2";
            case "실제이야기":
                return "REAL2";
            case "대학괴담":
                return "COLLEGE2";
            case "로어":
                return "LORE2";
            case "이해하면 무서운 이야기":
                return "UNDERSTAND2";
            case "도시괴담":
                return "CITY2";
        }
        return null;
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
