package com.horrornumber1.horrormagazine.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.horrornumber1.horrormagazine.Adapters.ViewPagerAdapter;
import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.DataModel.MyData;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Content extends AppCompatActivity {

    public static String PARAM_INPUT_NAME = "input name"; // 이전 Activity에서 넘어올 카테고리 이름
    public static String PARAM_INPUT_INDEX = "input index"; // 이전 Activity에서 넘어올 position 정보 받는 키워드
    public static String PARAM_INPUT_FROM = "input from";

    Menu absmenu; // 볼륨 아이콘을 설정하기 위함

    String name, from; // content 메뉴
    int position;
    List<MyData> contents;  // Model 있는 content text 파일을 받아올 리스트
    ViewPager pager;
    ViewPagerAdapter adapter;

    ImageView prev, next, favorite, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);



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

        contents = whichContents(name); // 이전 Activity 에서 받아온 name을 기반으로 컨텐츠에 띄울 카테고리를 선택

        // *****************************Content Activity의 ViewPager를 설정함***********************
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(this, getApplicationContext(),contents, pager);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(0); // 최대 로딩 개수 1 ( 메모리 부담을 줄이기 위함 )
        pager.setCurrentItem(position); // 해당 index의 page로 이동
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("page position", Integer.toString(pager.getCurrentItem()));

                if(pager.getCurrentItem()==0){
                    Log.i("listener position", "start");
                    prev.setVisibility(View.INVISIBLE); // 시작할때 첫번째 이야기 누르면 이전 버튼 안보이고 시작
                }
                else if(pager.getCurrentItem() ==contents.size()-1){
                    Log.i("listener position", "last");
                    next.setVisibility(View.INVISIBLE); // 시작할때 마지막 이야기 누르면 다음 버튼 안보이고 시작
                } else {
                    Log.i("listener position", "middle");
                    prev.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                }

            }
        });

        // 이전 다음 버튼은 activity_content layout에서 관리한다
        prev = (ImageView)findViewById(R.id.prevBtn); //이전 버튼
        next = (ImageView)findViewById(R.id.nextBtn); //다음 버튼
        favorite = (ImageView) findViewById(R.id.favorite);

        if(position==0) {
            prev.setVisibility(View.INVISIBLE); // 시작할때 첫번째 이야기 누르면 이전 버튼 안보이고 시작
        }
        else if(position ==contents.size()-1) {
            next.setVisibility(View.INVISIBLE); // 시작할때 마지막 이야기 누르면 다음 버튼 안보이고 시작
        }

        prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //  fragment_text_scroll.scrollTo(0,0);  //일단 스크롤을 맨위로 올려주고
                if(pager.getCurrentItem()>0) {
                    pager.setCurrentItem(pager.getCurrentItem()-1);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //fragment_text_scroll.scrollTo(0,0); // 화면 올리고
                if( position < contents.size()-1) {
                    pager.setCurrentItem(pager.getCurrentItem()+1);
                }
            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String board = whichTable(name);
                String title = contents.get(pager.getCurrentItem()).getTitle();

                Date d = new Date();
                SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");

                DataHouse.dbManager.insert("insert into " + board + " values(null, '" + board + "', '" + title + "', '" + sdf.format(d) + "'); ");
                Log.i(board, ": " + DataHouse.dbManager.PrintData(board));
                Toast.makeText(getApplicationContext(), "보관함에 추가되었습니다", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private String whichTable(String name)
    {
        switch (name)
        {
            case "지역괴담":
                return "REGION";
            case "군대괴담":
                return "MILLITARY";
            case "실제이야기":
                return "REAL";
            case "대학괴담":
                return "COLLEGE";
            case "로어":
                return "LORE";
            case "이해하면 무서운 이야기":
                return "UNDERSTAND";
            case "도시괴담":
                return "CITY";
        }
        return null;
    }

    // 이전 Activity 에서 받아온 name을 기반으로 컨텐츠에 띄울 카테고리를 선택
    private List<MyData> whichContents(String name) {
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
        if(DataHouse.musicCheck)
            DataHouse.mp.start();

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

    //**************************Background Music****************************************************
}

