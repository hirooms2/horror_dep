package com.horrornumber1.horrormagazine.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.horrornumber1.horrormagazine.Adapters.DrawerAdapter;
import com.horrornumber1.horrormagazine.CounsilClass.Counsil;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.SetView.SetCard;
import com.horrornumber1.horrormagazine.SetView.SetRecycler;
import com.horrornumber1.horrormagazine.SetView.SetTextView;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

import java.util.HashMap;

public class MainActivity extends ActionBarActivity implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    private ScrollView scrollView;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private Menu absmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***********************TextFont***********************************************************
        SetTextView homeFont = new SetTextView(getApplicationContext(), this);
        homeFont.HomeFont();

        //************************BackGround Music*************************************************
        DataHouse.mp = MediaPlayer.create(this, R.raw.bgm);
        DataHouse.mp.setLooping(true);
        if(DataHouse.musicCheck)
            DataHouse.mp.start();


        //************************ NavigationDrawer************************************************


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        toggle.syncState();

        ListView listView = (ListView) findViewById(R.id.nav_listView1);
        final DrawerAdapter drawerAdapter = new DrawerAdapter(this, DataHouse.drawerData);
        listView.setAdapter(drawerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Board.class);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(i));
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        ListView listView2 = (ListView) findViewById(R.id.nav_listView2);
        final DrawerAdapter drawerAdapter2 = new DrawerAdapter(this, DataHouse.drawerData2);
        listView2.setAdapter(drawerAdapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent intent = new Intent(MainActivity.this, Counsil.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);

                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer);
                    drawer.closeDrawer(GravityCompat.START);

                }
                //favorite
                if(i==2) {
                    Intent intent = new Intent(MainActivity.this, Favorite.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);

                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer);
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });


        // drawer.setDrawerListener(toggle);
        // *****************************************************************************************



        scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.smoothScrollTo(0, 0);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();

        file_maps.put("magazine", R.drawable.horrormagazine);
        file_maps.put("facebook", R.drawable.horrorfacebook);
        file_maps.put("youtube", R.drawable.horrorradio);

        for (String name : file_maps.keySet()) {
            final TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            textSliderView.setOnSliderClickListener(new TextSliderView.OnSliderClickListener(){
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    if(mDemoSlider.getCurrentPosition()==0)
                       startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCQbKk4fa3B23YDmVXjv-j4w")));
                    else if (mDemoSlider.getCurrentPosition()==1)
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/horrorNo.1/?fref=ts")));

                }
            });

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        //Set Home RecyclerView(군대, 대학, 로어, 도시)
        SetRecycler homeRecycler = new SetRecycler(getApplicationContext(), this);
        homeRecycler.HomeRecycler();

        //Set CardView (이무이, 실제)
        SetCard cardRecycler = new SetCard(getApplicationContext(), this);
        cardRecycler.HomeCard();

    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }
    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    //**********************************************************************************************

    //menu item이 클릭됐을때 실행되는 동작
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
            switch (item.getItemId()) {

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
    //화면이 변환되었을때
    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        toggle.onConfigurationChanged(newConfig);

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


    //**************************Background Music****************************************************

/*
    @Override
    public boolean dispatchKeyEvent(KeyEvent event)
    {
        if(event.getAction() == KeyEvent.ACTION_DOWN) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_HOME) {
                DataHouse.mp.pause();
            } else if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    Intent intent = new Intent(MainActivity.this, LastLogo.class);
                    startActivity(intent);
                }
            }
        }
        return true;
    }
 */

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(MainActivity.this, LastLogo.class);
            startActivity(intent);
        }
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

        if(absmenu!=null) {
            absmenu.clear();
            onCreateOptionsMenu(absmenu);
            onPrepareOptionsMenu(absmenu);
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
