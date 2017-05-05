package com.horrornumber1.horrormagazine.CounsilClass;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.R;

import java.util.ArrayList;
import java.util.List;

public class Counsil extends AppCompatActivity {

    private Button knock, knockBack, oneQuit, stroke, feed, dotoriBack, lookBack, introduce,
            horrorStoryBtn, bothOptionBack, dream, paralysis, reaper, follow, noBtn, mBack, wBack,
            mHorrorStory, wHorrorStory, toLookGhost, ghostSpotBtn, aboutGhost, mostHorror; //선택 버튼
    private ImageView interview, youtubeImg; // 이미지
    private LinearLayout screen;//전체화면
    private Handler layoutHandler, imageviewHandler, answerHandler;
    private Animation fadeout;
    private Typeface nanumBold;
    private TypeWriter storyText, effectText;
    private TextView word1, word2, word3, word4, introduceText, closeText; // 효과음
    private int i, random, count; //for문, 경우의수, 면담하기 이야기 카운트
    private List<String> enter, paralysisStory, followStory, reaperStory, noTalk, watchGhost, ghostSpot,  mostHorrible; //첫화면 케이스들 담아두는곳, 무서운이야기 테스트
    private FrameLayout storyFrame, oneLookBackFrame, oneQuitFrame,
            twoOptionKnockFrame, dotoriSelectFrame, bothOptionFrame, dreamOption, mOptionFrame, wOptionFrame, youtubeBtnFrame;
    private View introduceFrame;
    private Animation topShow, topHide;
    public static MediaPlayer dooropen, scream, knocksound, eating, growl, girllaugh, grandmother, knockbark, ringonce, ringseveral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counsil_main);

        enter = new ArrayList<String>(); // 처음 시작할 때 경우의수 문자열 컬렉션
        paralysisStory = new ArrayList<String>(); // 가위 스토리
        followStory = new ArrayList<>(); //누가 따라와요 스토리
        reaperStory = new ArrayList<>();//저승사자를 본 것 같아요 스토리
        noTalk = new ArrayList<>();//이야기하기 싫어요
        watchGhost = new ArrayList<>();//귀신 보는 방법
        ghostSpot = new ArrayList<>(); // 흉가 탐방이 가고 싶어요
        mostHorrible = new ArrayList<>(); // 가장 무서운것은 뭔가요?

//        nanumBold = Typeface.createFromAsset(getApplicationContext().getAssets(), "font/nanumgothic.ttf");

        dooropen = MediaPlayer.create(this, R.raw.dooropen);
        dooropen.setLooping(false);

        scream = MediaPlayer.create(this, R.raw.scream);
        scream.setLooping(false);

        knocksound = MediaPlayer.create(this, R.raw.knock);
        knocksound.setLooping(false);

        eating = MediaPlayer.create(this, R.raw.eating);
        eating.setLooping(false);

        growl = MediaPlayer.create(this, R.raw.growl);
        growl.setLooping(false);

        girllaugh = MediaPlayer.create(this, R.raw.girllaugh);
        girllaugh.setLooping(false);

        knockbark = MediaPlayer.create(this, R.raw.knockbark);
        knockbark.setLooping(false);

        grandmother = MediaPlayer.create(this, R.raw.grandmother);
        grandmother.setLooping(false);

        ringonce = MediaPlayer.create(this, R.raw.ringonce);
        ringonce.setLooping(false);

        ringseveral = MediaPlayer.create(this, R.raw.ringseveral);
        ringseveral.setLooping(false);

        topShow = AnimationUtils.loadAnimation(this, R.anim.top_in);
        topHide = AnimationUtils.loadAnimation(this, R.anim.top_out);

        //random = (int) (Math.random()*5);  // 경우의 수 5개 할당(교수없음, 도토리, 둘다, m혼자, w혼자
        random = 4;

        count = 0;

        screen = (LinearLayout) findViewById(R.id.activity_main);

        storyFrame = (FrameLayout)findViewById(R.id.storyFrame);
        oneLookBackFrame = (FrameLayout)findViewById(R.id.oneOptionLookBack);
        oneQuitFrame = (FrameLayout)findViewById(R.id.oneOptionQuit);
        twoOptionKnockFrame = (FrameLayout)findViewById(R.id.twoOptionKnock);
        dotoriSelectFrame = (FrameLayout)findViewById(R.id.dotoriSelect);
        bothOptionFrame = (FrameLayout)findViewById(R.id.fourBothoption);
        introduceFrame = (FrameLayout)findViewById(R.id.introduceFrame);
        dreamOption = (FrameLayout)findViewById(R.id.dreamOption);
        mOptionFrame = (FrameLayout)findViewById(R.id.fourMoption);
        wOptionFrame = (FrameLayout)findViewById(R.id.fourWoption);
        youtubeBtnFrame = (FrameLayout)findViewById(R.id.youtubeButtonFrame);

        interview = (ImageView)findViewById(R.id.interview);
        youtubeImg = (ImageView)findViewById(R.id.youtubeBtn);

        word1 = (TextView)findViewById(R.id.word1); word2 = (TextView)findViewById(R.id.word2);
        word3 = (TextView)findViewById(R.id.word3); word4 = (TextView)findViewById(R.id.word4);
        introduceText = (TextView)findViewById(R.id.introduceText); //공포학과 소개 텍스트뷰
        closeText = (TextView)findViewById(R.id.closeBtn); //창닫기 버튼

        storyText = (TypeWriter) findViewById(R.id.storyText); //이야기 창 텍스트뷰
        effectText = (TypeWriter)findViewById(R.id.effectText); //노크 등등 효과음용

        oneLookBackFrame.setVisibility(View.GONE); // 뒤돌아 본다 프레임 레이아웃 Gone 처리
        oneQuitFrame.setVisibility(View.GONE); // 돌아간다 프레임 레이아웃 Gone 처리
        storyFrame.setVisibility(View.GONE); // 이야기 프레임 레이아웃 Gone 처리
        dotoriSelectFrame.setVisibility(View.GONE); // 도토리 선택창 GONE 처리
        bothOptionFrame.setVisibility(View.GONE); //교수 둘 선택창 사라지도록
        effectText.setVisibility(View.GONE); //효과음 창 Gone 처리
        introduceFrame.setVisibility(View.GONE); //공포학과 소개 창 Gone 처리
        dreamOption.setVisibility(View.GONE); //꿈 프레임 Gone 처리
        mOptionFrame.setVisibility(View.GONE);//M교수 선택창 사라지도록
        wOptionFrame.setVisibility(View.GONE);//W교수 선택창 사라지도록
        youtubeBtnFrame.setVisibility(View.GONE); // 유튜브 보러가기 창 Gone

        knock = (Button) findViewById(R.id.knockBtn); //노크 한다 버튼
        knockBack = (Button)findViewById(R.id.knockQuitBtn);  //돌아간다 버튼
        oneQuit = (Button)findViewById(R.id.quitBtn); // 교수가 없을때 돌아간다 버튼
        stroke = (Button)findViewById(R.id.strokeBtn); //  쓰다듬는다 버튼
        feed = (Button)findViewById(R.id.feedBtn); // 간식준다 버튼
        dotoriBack = (Button)findViewById(R.id.dotoirQuitBtn); //도토리 3선택 창 돌아가기 버튼
        lookBack = (Button)findViewById(R.id.lookBackBtn); //돌아본다 버튼
        introduce = (Button)findViewById(R.id.introduceBtn); //공포학과 소개 버튼
        horrorStoryBtn = (Button)findViewById(R.id.horrorStoryBtn);//무서운이야기 들려주세요 버튼
        bothOptionBack = (Button)findViewById(R.id.bothBackBtn); // 교수 면담 뒤로가기
        dream = (Button)findViewById(R.id.dreamBtn); // 꿈자리가 사나워요 버튼
        paralysis = (Button)findViewById(R.id.paralysisBtn);//가위에 눌려요 버튼
        follow = (Button)findViewById(R.id.followBtn); //누가 따라와요 버튼
        reaper = (Button)findViewById(R.id.reaperBtn);//저승사자 버튼
        noBtn = (Button)findViewById(R.id.noBtn); //말하기 싫어요 버튼
        mBack = (Button)findViewById(R.id.mBackBtn); //m교수 뒤로가기 버튼
        wBack = (Button)findViewById(R.id.wBackBtn); //w교수 뒤로가기 버튼
        mHorrorStory = (Button)findViewById(R.id.mHorrorStoryBtn); //m교수 무서운이야기 버튼
        wHorrorStory = (Button)findViewById(R.id.wHorrorStoryBtn); //w교수 무서운이야기 버튼
        toLookGhost = (Button)findViewById(R.id.toLookGhostBtn); //귀신을 보는 법을 알려주세요 버튼
        ghostSpotBtn = (Button)findViewById(R.id.ghostSpotBtn); //흉가탐방이 가고 싶어요 버튼
        aboutGhost = (Button)findViewById(R.id.aboutGhostBtn); // 귀신이란 무엇인가요 버튼
        mostHorror = (Button)findViewById(R.id.mostHorrorBtn); // 가장 무서운것은 무엇인가요 버튼

        layoutHandler = new Handler();
        imageviewHandler = new Handler();
        answerHandler = new Handler();

        effectText.setTypeface(nanumBold);

        introduceText.setText("공포학과는 2016년 1월 11일부터 시작한 페이스북 페이지로 공포 전문 플랫폼입니다.\n" +
                "공포 학과는 M교수, W교수가 대표로 있으며 광고 하나 없이 청정한 순수 공포 콘텐츠만을 다루는 플랫폼으로, 활동량 국내 NO.1의 공포 페이지 입니다.\n" +
                "5만 명이 훌쩍 넘는 공포 매니아들의 성원에 힘입어 현재는 유튜브에서 라디오/게임 방송과 공포 어플리케이션, 공포 매거진(잡지)까지 플랫폼을 확장하여 많은 콘텐츠를 양산하고 있습니다.\n" +
                "괴담, 실화, 만화, 로어, 미스테리, 사건/사고, 민속학 등 다양한 공포 장르를 통해 공포의 대중화라는 큰 목표를 향해 나아가고 있습니다." );

        //-------fadeout 애니메이션 설정------

        fadeout = new AlphaAnimation(0.00f, 1.00f);
        fadeout.setDuration(1000);

        fadeout.setAnimationListener(new Animation.AnimationListener() {

            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            public void onAnimationEnd(Animation animation) {
                interview.setVisibility(View.VISIBLE);

            }
        });


        knock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //-------노크하기 버튼 눌렀을때의 뷰변경------

                if(random==0 || random==2 || random==3 || random==4) {
                    knocksound.start();
                }
                else if(random==1){
                    knockbark.start();
                }

                effectText.setVisibility(View.VISIBLE);
                setStory("똑 똑 똑..", 200);

                twoOptionKnockFrame.setVisibility(View.GONE); // 노크하기, 돌아간다 프레임 사라짐
                storyFrame.setVisibility(View.VISIBLE);

                switch (random){

                    case 0:
                        //-------방안에 아무도 없을 경우에 대한 뷰변경------

                        (new Thread(){
                            @Override
                            public void run(){

                                answerHandler.postDelayed(new Runnable(){
                                    public void run(){
                                        setStory(enter.get(random));
                                    }
                                }, 2000);
                            }
                        }).start();

                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                effectText.setVisibility(View.GONE);
                                knocksound.stop();
                                knocksound.release();

                                storyFrame.setVisibility(View.GONE);
                                oneQuitFrame.setVisibility(View.VISIBLE);
                            }
                        });
                        break;

                    case 1:
                        //-------도토리만 방안에 있는 상황에 대한 뷰변경------

                        (new Thread(){
                            @Override
                            public void run(){

                                answerHandler.postDelayed(new Runnable(){
                                    public void run(){
                                        setStory(enter.get(random));
                                    }
                                }, 2500);
                            }
                        }).start();


                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        effectText.setVisibility(View.GONE);

                                        knockbark.stop();
                                        knockbark.release();
                                        setStory("도토리가 안에 있는 것 같다. 들어갈까요?");

                                        storyFrame.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                storyFrame.setVisibility(View.GONE);
                                                twoOptionKnockFrame.setVisibility(View.VISIBLE);

                                                knock.setText("들어가기");
                                                knock.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {

                                                        dooropen.start();

                                                        twoOptionKnockFrame.setVisibility(View.GONE);
                                                        storyFrame.setVisibility(View.GONE);

                                                        (new Thread(){
                                                            @Override
                                                            public void run(){

                                                                imageviewHandler.postDelayed(new Runnable(){
                                                                    public void run(){
                                                                        interview.setVisibility(View.VISIBLE);
                                                                        interview.startAnimation(fadeout);
                                                                    }
                                                                }, 500);
                                                            }
                                                        }).start();

                                                        (new Thread(){
                                                            @Override
                                                            public void run(){

                                                                imageviewHandler.postDelayed(new Runnable(){
                                                                    public void run(){
                                                                        dooropen.stop();
                                                                        dooropen.release();
                                                                        storyFrame.setVisibility(View.VISIBLE);
                                                                        setStory("도토리가 혼자 놀고 있다. 당신에게 놀아달라는 듯이 바라본다.");
                                                                    }
                                                                }, 1500);
                                                            }
                                                        }).start();

                                                        interview.setVisibility(View.GONE);
                                                        interview.setImageResource(R.drawable.room);
                                                        screen.setBackgroundColor(Color.BLACK);

                                                        word1.setText("");
                                                        word4.setText("");


                                                        (new Thread(){
                                                            @Override
                                                            public void run(){
                                                                for(i=0; i<255; i++){
                                                                    layoutHandler.post(new Runnable(){
                                                                        public void run(){
                                                                            screen.setBackgroundColor(Color.argb(255, i, i, i));
                                                                        }
                                                                    });
                                                                    // next will pause the thread for some time
                                                                    try{
                                                                        sleep(30);
                                                                    }
                                                                    catch(InterruptedException e){
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }).start();

                                                        storyFrame.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                storyFrame.setVisibility(View.GONE);
                                                                dotoriSelectFrame.setVisibility(View.VISIBLE);

                                                            }
                                                        });
                                                    }

                                                });

                                            }
                                        });

                                    }
                                });


                        break;
                    case 2:

                        //-------교수 두명이 안에 있는 상황에 대한 뷰 변경------

                        (new Thread(){
                            @Override
                            public void run(){

                                answerHandler.postDelayed(new Runnable(){
                                    public void run(){
                                        setStory(enter.get(random));
                                    }
                                }, 2000);
                            }
                        }).start();

                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                storyFrame.setVisibility(View.GONE);
                                twoOptionKnockFrame.setVisibility(View.VISIBLE);

                                effectText.setVisibility(View.GONE);
                                knocksound.stop();
                                knocksound.release();

                                knock.setText("들어가기");
                                knock.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dooropen.start();
                                        twoOptionKnockFrame.setVisibility(View.GONE);
                                        storyFrame.setVisibility(View.GONE);

                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){

                                                        interview.setVisibility(View.VISIBLE);
                                                        interview.startAnimation(fadeout);
                                                        bothOptionFrame.setVisibility(View.VISIBLE);
                                                        bothOptionFrame.startAnimation(fadeout);
                                                    }
                                                }, 500);
                                            }
                                        }).start();

                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){

                                                        dooropen.stop();
                                                        dooropen.release();
                                                    }
                                                }, 1000);
                                            }
                                        }).start();

                                        interview.setVisibility(View.GONE);
                                        interview.setImageResource(R.drawable.room);
                                        screen.setBackgroundColor(Color.BLACK);

                                        word1.setVisibility(View.GONE);
                                        word4.setVisibility(View.GONE);

                                        setStory("");

                                        (new Thread(){
                                            @Override
                                            public void run(){
                                                for(i=0; i<255; i++){
                                                    layoutHandler.post(new Runnable(){
                                                        public void run(){
                                                            screen.setBackgroundColor(Color.argb(255, i, i, i));
                                                        }
                                                    });
                                                    // next will pause the thread for some time
                                                    try{
                                                        sleep(30);
                                                    }
                                                    catch(InterruptedException e){
                                                        break;
                                                    }
                                                }
                                            }
                                        }).start();

                                    }
                                });

                            }
                        });
                        break;

                    case 3:
                        //-----------ㅡm교수만 있는 상황--------------
                        (new Thread(){
                            @Override
                            public void run(){

                                answerHandler.postDelayed(new Runnable(){
                                    public void run(){
                                        setStory(enter.get(random));
                                    }
                                }, 2000);
                            }
                        }).start();

                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                storyFrame.setVisibility(View.GONE);
                                twoOptionKnockFrame.setVisibility(View.VISIBLE);

                                effectText.setVisibility(View.GONE);
                                knocksound.stop();
                                knocksound.release();

                                knock.setText("들어가기");
                                knock.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dooropen.start();
                                        twoOptionKnockFrame.setVisibility(View.GONE);
                                        storyFrame.setVisibility(View.GONE);

                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){

                                                        interview.setVisibility(View.VISIBLE);
                                                        interview.startAnimation(fadeout);
                                                        mOptionFrame.setVisibility(View.VISIBLE);
                                                        mOptionFrame.startAnimation(fadeout);
                                                    }
                                                }, 500);
                                            }
                                        }).start();

                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){

                                                        dooropen.stop();
                                                        dooropen.release();
                                                    }
                                                }, 1000);
                                            }
                                        }).start();

                                        interview.setVisibility(View.GONE);
                                        interview.setImageResource(R.drawable.room);
                                        screen.setBackgroundColor(Color.BLACK);

                                        word1.setVisibility(View.GONE);
                                        word4.setVisibility(View.GONE);

                                        setStory("");

                                        (new Thread(){
                                            @Override
                                            public void run(){
                                                for(i=0; i<255; i++){
                                                    layoutHandler.post(new Runnable(){
                                                        public void run(){
                                                            screen.setBackgroundColor(Color.argb(255, i, i, i));
                                                        }
                                                    });
                                                    // next will pause the thread for some time
                                                    try{
                                                        sleep(30);
                                                    }
                                                    catch(InterruptedException e){
                                                        break;
                                                    }
                                                }
                                            }
                                        }).start();

                                    }
                                });
                            }
                        });
                        break;
                    case 4:
                        //-----------ㅡw교수만 있는 상황--------------
                        (new Thread(){
                            @Override
                            public void run(){

                                answerHandler.postDelayed(new Runnable(){
                                    public void run(){
                                        setStory(enter.get(random));
                                    }
                                }, 2000);
                            }
                        }).start();

                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                storyFrame.setVisibility(View.GONE);
                                twoOptionKnockFrame.setVisibility(View.VISIBLE);

                                effectText.setVisibility(View.GONE);
                                knocksound.stop();
                                knocksound.release();

                                knock.setText("들어가기");
                                knock.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dooropen.start();
                                        twoOptionKnockFrame.setVisibility(View.GONE);
                                        storyFrame.setVisibility(View.GONE);

                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){

                                                        interview.setVisibility(View.VISIBLE);
                                                        interview.startAnimation(fadeout);
                                                        wOptionFrame.setVisibility(View.VISIBLE);
                                                        wOptionFrame.startAnimation(fadeout);
                                                    }
                                                }, 500);
                                            }
                                        }).start();

                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){

                                                        dooropen.stop();
                                                        dooropen.release();
                                                    }
                                                }, 1000);
                                            }
                                        }).start();

                                        interview.setVisibility(View.GONE);
                                        interview.setImageResource(R.drawable.room);
                                        screen.setBackgroundColor(Color.BLACK);

                                        word1.setVisibility(View.GONE);
                                        word4.setVisibility(View.GONE);

                                        setStory("");

                                        (new Thread(){
                                            @Override
                                            public void run(){
                                                for(i=0; i<255; i++){
                                                    layoutHandler.post(new Runnable(){
                                                        public void run(){
                                                            screen.setBackgroundColor(Color.argb(255, i, i, i));
                                                        }
                                                    });
                                                    // next will pause the thread for some time
                                                    try{
                                                        sleep(30);
                                                    }
                                                    catch(InterruptedException e){
                                                        break;
                                                    }
                                                }
                                            }
                                        }).start();

                                    }
                                });
                            }
                        });
                        break;



                }
            }
        });
        //-------저승사자를 본 것 같아요 버튼------
        reaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dreamOption.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory(reaperStory.get(count++));

                for(int i=0; i<40; i++){
                    storyFrame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setStory(reaperStory.get(count++));

                            if(count==25){
                                ringonce.start();
                            }

                            if(count==27){
                                ringonce.stop();
                            }

                            if(count==31){
                                ringseveral.start();
                            }

                            if(count==33){
                                ringseveral.stop();
                            }

                            if(count==41){
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        storyFrame.setVisibility(View.GONE);
                                        bothOptionFrame.setVisibility(View.VISIBLE);
                                        count=0;
                                    }
                                });
                            }
                        }
                    });
                }

            }
        });

        //-------누가 따라와요 버튼---------
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dreamOption.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory(followStory.get(count++));

                for(int i=0; i<24; i++){
                    storyFrame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setStory(followStory.get(count++));

                            if(count==23){
                                grandmother.start();
                            }

                            if(count==25){
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        grandmother.stop();
                                        storyFrame.setVisibility(View.GONE);
                                        bothOptionFrame.setVisibility(View.VISIBLE);
                                        count=0;
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });

        //-------가위에 눌려요 버튼---------
        paralysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dreamOption.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory(paralysisStory.get(count++));

                for(int i=0; i<20; i++){
                    storyFrame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setStory(paralysisStory.get(count++));

                            if(count==14){
                                girllaugh.start();
                            }

                            if(count==15){
                                girllaugh.stop();
                            }

                            if(count==21){
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        storyFrame.setVisibility(View.GONE);
                                        bothOptionFrame.setVisibility(View.VISIBLE);
                                        count=0;
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });

        //-------말하기 싫어요-------------
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dreamOption.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory(noTalk.get(count++));

                for(int i=0; i<3; i++){
                    storyFrame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setStory(noTalk.get(count++));
                            if(count==5){
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        interview.setImageResource(R.drawable.dotori);
                                        setStory("되게 귀엽죠?? 도토리의 응원이 힘이 되셨으면 좋겠습니다. 자 다시 면담을 진행해보죠!");
                                        storyFrame.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                count=0;
                                                interview.setImageResource(R.drawable.room);
                                                storyFrame.setVisibility(View.GONE);
                                                bothOptionFrame.setVisibility(View.VISIBLE);
                                            }
                                        });
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });

        //-------귀신 보는 법 알려주세요 버튼 --------
        toLookGhost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOptionFrame.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory(watchGhost.get(count++));
                for(int i=0; i<24; i++){
                    storyFrame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setStory(watchGhost.get(count++));
                            if(count==10){
                                interview.setImageResource(R.drawable.ready);
                            }
                            if(count==11){
                                interview.setImageResource(R.drawable.cotton);
                            }
                            if(count==14){
                                interview.setImageResource(R.drawable.ghosttv);
                            }
                            if(count==15){
                                interview.setImageResource(R.drawable.needle);
                            }
                            if(count==17){
                                interview.setImageResource(R.drawable.hiding);
                            }
                            if(count==19){
                                interview.setImageResource(R.drawable.room);
                            }
                            if(count==24){
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        count=0;
                                        mOptionFrame.setVisibility(View.VISIBLE);
                                        storyFrame.setVisibility(View.GONE);
                                    }
                                });

                            }
                        }
                    });
                }
            }
        });
        //흉가 탐방이 가고 싶어요
        ghostSpotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOptionFrame.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory(ghostSpot.get(count++));

                for(int i=0; i<14; i++){
                    storyFrame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setStory(ghostSpot.get(count++));

                            if(count==14){
                                youtubeBtnFrame.setVisibility(View.VISIBLE);
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        count=0;
                                        mOptionFrame.setVisibility(View.VISIBLE);
                                        youtubeBtnFrame.setVisibility(View.GONE);
                                        storyFrame.setVisibility(View.GONE);
                                    }
                                });
                            }

                        }
                    });
                }
            }
        });
        // 가장 무서운것은 무엇인가요? 버튼
        mostHorror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wOptionFrame.setVisibility(View.INVISIBLE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory(mostHorrible.get(count++));

                for(int i=0; i<8; i++){
                    storyFrame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setStory(mostHorrible.get(count++));

                            if(count==8){
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        count=0;
                                        wOptionFrame.setVisibility(View.VISIBLE);
                                        storyFrame.setVisibility(View.GONE);
                                    }
                                });
                            }

                        }
                    });
                }


            }
        });
        //-------흉가탐방 유튜브 보러가기-----
        youtubeBtnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GhostSpotYoutube.class);
                startActivity(intent);
            }
        });

        //-------공포학과 배경 버튼---------
        introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduceFrame.setVisibility(View.VISIBLE);
                introduceFrame.startAnimation(topShow);
                bothOptionFrame.setVisibility(View.GONE);
            }
        });

        //-------창닫기 버튼--------
        closeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduceFrame.setVisibility(View.INVISIBLE);
                introduceFrame.startAnimation(topHide);
                bothOptionFrame.setVisibility(View.VISIBLE);
            }
        });

        //------교수 둘다 무서운이야기 들려주세요 버튼------

        horrorStoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bothOptionFrame.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory("무서운이야기요??     흠.........");
                storyFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setStory("그냥 무서운 이야기는 그렇고..좀 많이 무서우실텐데 괜찮으시겠어요??");
                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setStory("좋습니다...  직접 들려드리겠습니다. 마음의 준비 단단히 하고 듣기를 권장합니다.");
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){
                                                        storyFrame.setVisibility(View.GONE);
                                                        bothOptionFrame.setVisibility(View.VISIBLE);
                                                    }
                                                }, 500);
                                            }
                                        }).start();

                                        Intent intent = new Intent(getApplicationContext(), HorrorListActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        //------m교수 무서운이야기 들려주세요 버튼------

        mHorrorStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOptionFrame.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory("무서운이야기요??     흠.........");
                storyFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setStory("그냥 무서운 이야기는 그렇고..좀 많이 무서우실텐데 괜찮으시겠어요??");
                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setStory("좋습니다...  직접 들려드리겠습니다. 마음의 준비 단단히 하고 듣기를 권장합니다.");
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){
                                                        storyFrame.setVisibility(View.GONE);
                                                        mOptionFrame.setVisibility(View.VISIBLE);
                                                    }
                                                }, 500);
                                            }
                                        }).start();

                                        Intent intent = new Intent(getApplicationContext(), HorrorListActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        //------w교수 무서운이야기 들려주세요 버튼------

        wHorrorStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wOptionFrame.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory("무서운이야기요??     흠.........");
                storyFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setStory("그냥 무서운 이야기는 그렇고..좀 많이 무서우실텐데 괜찮으시겠어요??");
                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setStory("좋습니다...  직접 들려드리겠습니다. 마음의 준비 단단히 하고 듣기를 권장합니다.");
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        (new Thread(){
                                            @Override
                                            public void run(){

                                                imageviewHandler.postDelayed(new Runnable(){
                                                    public void run(){
                                                        storyFrame.setVisibility(View.GONE);
                                                        wOptionFrame.setVisibility(View.VISIBLE);
                                                    }
                                                }, 500);
                                            }
                                        }).start();

                                        Intent intent = new Intent(getApplicationContext(), HorrorListActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        //-------뒤로가기 버튼은 무조건 finish------

        knockBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        oneQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dotoriBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bothOptionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //-------꿈자리가 사나워요 버튼 ----------------
        dream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bothOptionFrame.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory("음...사람한테 잠이 참 중요한데...꿈자리가 사나우면 숙면을 취하기가 힘들죠");
                storyFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setStory("어떤 종류의 꿈인지 물어봐도 될까요??");
                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                storyFrame.setVisibility(View.GONE);
                                dreamOption.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
            }
        });

        //-------쓰다듬는다, 간식을 준다 버튼 -------------
        stroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotoriSelectFrame.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                setStory("쓰담쓰담 해주니 도토리 기분이 좋아 보인다");

                //도토리 이미지 변경

                storyFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        storyFrame.setVisibility(View.GONE);
                        dotoriSelectFrame.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotoriSelectFrame.setVisibility(View.GONE);
                storyFrame.setVisibility(View.VISIBLE);
                eating.start();
                setStory("도토리가 간식을 아주 맛나게 먹는다 ");

                storyFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setStory("배가 부르니 도토리 기분이 아주 좋아 보인다");
                        eating.stop();
                        eating.release();
                        word1.setVisibility(View.GONE);
                        word2.setVisibility(View.GONE);
                        word3.setVisibility(View.GONE);

                        //이미지 변경 들어갈 자리

                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //이미지 변경(으르렁)
                                setStory("갑자기 도토리가 내 뒤를 보며 으르렁 거린다..");
                                growl.start();
                                storyFrame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        setStory("(응? 도토리가 왜이러지....?)");
                                        growl.stop();
                                        growl.release();
                                        storyFrame.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                storyFrame.setVisibility(View.GONE);
                                                oneLookBackFrame.setVisibility(View.VISIBLE);
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        //돌아본다 클릭 후 귀신 사진 나오고 화면 전환환

       lookBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oneLookBackFrame.setVisibility(View.GONE);
                interview.setImageResource(R.drawable.black_screen);

                (new Thread(){
                    @Override
                    public void run(){

                        imageviewHandler.postDelayed(new Runnable(){
                            public void run(){
                                interview.setImageResource(R.drawable.mother_ghost);
                                scream.start();
                            }
                        }, 500);
                    }
                }).start();

                (new Thread(){
                    @Override
                    public void run(){

                        imageviewHandler.postDelayed(new Runnable(){
                            public void run(){
                                interview.setVisibility(View.VISIBLE);
                                interview.startAnimation(fadeout);

                                interview.setVisibility(View.GONE);
                                interview.setImageResource(R.drawable.room);
                                screen.setBackgroundColor(Color.BLACK);

                                storyFrame.setVisibility(View.VISIBLE);
                                setStory("나는 잡귀와 마주치고 기절한 듯 싶다...");


                                (new Thread(){
                                    @Override
                                    public void run(){
                                        scream.stop();
                                        scream.release();
                                        for(i=0; i<255; i++){
                                            layoutHandler.postDelayed(new Runnable(){
                                                public void run(){
                                                    screen.setBackgroundColor(Color.argb(255, i, i, i));
                                                }
                                            }, 500);
                                            // next will pause the thread for some time
                                            try{
                                                sleep(500);
                                            }
                                            catch(InterruptedException e){
                                                break;
                                            }
                                        }
                                    }
                                }).start();
                            }
                        }, 3000);
                    }
                }).start();

                storyFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setStory("주변에 아무것도 없다. 얼른 돌아가는 것이 좋을 것 같다.");
                        storyFrame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                storyFrame.setVisibility(View.GONE);
                                oneQuitFrame.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });

            }
        });
        enter.add("교수님이 안 계시는것 같다..돌아가도록 하자");
        enter.add("멍! 멍멍! 왈왈!! 멍멍멍!!");
        enter.add("M,W교수 : 들어오세요~~~~");
        enter.add("M교수 : 들어오십시오~~~");
        enter.add("W교수 : 들어와요~~~");

        paralysisStory.add("흠...가위라...가위에 눌리는 것 만큼 무서운 꿈은 없죠"); paralysisStory.add("근데 사실 가위라는건 현실이라기 보다는 우리가 만든 허상에 가깝습니다");
        paralysisStory.add("과학적으로는 의식의 각성이 불완전하여 뇌는 깨어있지만, 사지는 깨어있지 않은 상태라고 정의하고 있죠");
        paralysisStory.add("주 원인으로는 불규칙적인 생활, 수면 부족, 과로, 스트레스 등이 있습니다");
        paralysisStory.add("이야기를 하다보니 제가 겪었던 가위눌림이 생각나네요....들려드릴까요?");
        paralysisStory.add("그날은 왠지 가위에 눌릴것같은 날이었습니다. 왜냐하면 이틀 밤을 세웠기 때문이죠...");
        paralysisStory.add("씻지도 않고 침대에 눕자마자 잠들었는데 얼마 되지 않아서 인기척에 눈을 떴습니다");
        paralysisStory.add("방안이 훤히 들여다 보이는 상황이었는데 제 방이 뭔가 평소와는 다르다는 느낌을 받았습니다");
        paralysisStory.add("그때 문득 제방 장롱 위를 보니 이상한 형체가 있더군요...뭘까..하는 생각으로 한참을 보고있는데");
        paralysisStory.add("갑자기 그 형체가 장롱 위를 기어다니기 시작했습니다. 얼굴까지 덮는 헝클어진 머리와 검은 드레스를 입은 여자였습니다");
        paralysisStory.add("그 형체가 저의 시선을 의식했는지 거미처럼 슬금슬금 장롱을 기어 내려오기 시작하는겁니다");
        paralysisStory.add("저는 미친듯이 제발 가위에서 깨어나기를 외쳤으나 소리는 나오지를 않고, 눈을 감아도 뜬 것처럼 모든 상황이 다 보였습니다");
        paralysisStory.add("결국 그 검은 드레스를 입은 여자가 제 침대 옆에 서있더군요...");
        paralysisStory.add("그 여자는 한참을 서서 저를 내려다 보다가 갑자기 정신나간 듯한 웃음소리를 내기 시작했습니다");
        paralysisStory.add("저는 이러다 정말 죽을 수도 있겠구나...라는 생각으로 인터넷에서 본 가위푸는 행위들을 다 했습니다. 엄지손가락도 펴보고 주기도문도 외웠습니다");
        paralysisStory.add("그러나 가위는 풀리지 않고 그 여자의 웃음소리는 이제는 머리속에서 울리듯이 커졌습니다");
        paralysisStory.add("그 순간, 그 여자가 미친듯한 웃음 소리와 함께 제 배위에 올라서서 덩실~덩실~ 춤을 추기 시작했습니다");
        paralysisStory.add("저는 도저히 참지 못하고 그대로 기절해버렸습니다....");  paralysisStory.add("깨어보니 잠든지 30분이 채 안되었더군요...");
        paralysisStory.add("그 후로 저는 절대 과로를 하지도 않고 영양제도 챙겨먹으며 두번 다시는 가위에 눌리지 않으리라 노력중입니다..");
        paralysisStory.add("정신적으로 육체적으로 건강을 유지하는 방법 말고는 가위를 피할 방법은 없습니다....");

        followStory.add("음...누가 따라온다구요...?");
        followStory.add("누군가 따라오는 꿈은 당신의 불안한 마음이 투영되는 경우가 많죠");
        followStory.add("혹시 요즘 스트레스를 받거나 심리적으로 압박을 받는 상황에 처해 있으신가요?");
        followStory.add("만약 그렇다면 아무런 생각없이 마음을 평안히 만드는 것이 상당히 중요합니다");
        followStory.add("스트레스는 요즘 현대인에게 만성적인 존재죠 ");
        followStory.add("그만큼 스트레스를 해소하고 스스로를 치유하는 방법을 잘 알고 있어야 합니다");
        followStory.add("좋아하는 장르의 음악을 감상하거나, 운동을 즐기는 방법 등이 있죠...아! 좋은 해결책이 하나 더 있네요!");
        followStory.add("공포학과를 즐기는 방법이죠^^ ㅎㅎ 말이 나온김에 꿈에 관련된 무서운 이야기 하나 해드리죠!");
        followStory.add("저희 공포학과 팔로워중 한분이 뒤숭숭한 꿈자리에 관련하여 제보해주신 내용입니다.");
        followStory.add("이야기가 무섭습니다. 자 그럼 시작하겠습니다!");
        followStory.add("나는 꿈 속에서 숲 속을 달리고 있었다...");
        followStory.add("언제부터 달렸는지 여기가 어딘지 조차도 모르는 그런 이상한 꿈이었다");
        followStory.add("그리고 내 등 뒤에는 내가 지나온 길을 따라 달려오는 의문의 발소리가 들려온다");
        followStory.add("누굴까... 잠시 돌아보니 웬 이상한 남자가 나를 죽일 듯 노려보며 달려오고 있다");
        followStory.add("기겁한 나는 다시 앞을 보고 달렸다. 일단 목적지도 없이...");
        followStory.add("가만 생각해보니까 그 남자가 칼 같은 걸 들고 있었던가? 그랬던 것 같기도 하다");
        followStory.add("긴 생각은 할 새 없이 무작정 달리다보니 점차 남자의 발소리는 멀어졌다");
        followStory.add("그리고 잠시 후 남자의 발걸음이 사라짐과 동시에 저 멀리 불빛이 보이기 시작했다");
        followStory.add("왠지 모르게 빛이 나는 곳으로 가야겠다고 생각한 나는 그곳으로 갔다");
        followStory.add("그곳엔 허름한 집과 인상이 선해 보이는 할머님 한 분이 계셨고, 나는 그 할머니에게 상황을 설명하고 잠시만 숨겨달라고 했다");
        followStory.add("할머니는 나를 집으로 들여보내주셨다");
        followStory.add("미닫이 문을 닫고 집에 들어선 순간 밖에서 할머니의 목소리가 들렸다");
        followStory.add("\"어이 김씨! 여기야!!\"");
        followStory.add("나는 그리고 꿈에서 깨어났다");
        followStory.add("다시 잠들면 나는 어떻게 되는 것일까");

        reaperStory.add("우선 꿈에서 깨어나셨다는 사실이 참 다행입니다");
        reaperStory.add("꿈에 저승사자가 나온다는 것은 보통 나쁜 결과가 있을 확률 많습니다");
        reaperStory.add("저승사자의 정의는 저승의 왕인 염라대왕의 명을 받고 죽은 사람의 넋을 데리러 오는 심부름꾼입니다 ");
        reaperStory.add("죽음에 대한 인간의 원초적인 두려움이 만든 대상이죠");
        reaperStory.add("그렇기 때문에 동서양 문화에 상관없이 모든 곳에 있는 존재입니다");
        reaperStory.add("보통 저승사자를 목격한 사람들이 표현한 저승사자의 생김새는 신장이 3m, 찢어진 입꼬리가 대표적입니다");
        reaperStory.add("하지만 사실 저승사자는 여러가지 모습으로 등장을 한다고 합니다");
        reaperStory.add("옛말에 꿈에 경찰이 나오면 절대 따라가지말라는 이야기도 있고, 혹은 본인이 생각하는 이상적인 외모로 나타나기도 합니다");
        reaperStory.add("저승사자가 등장하는 꿈도 다른 꿈들과 비슷합니다. 결국 몸이 혀약하고 정신적으로 불안정하면 그런 꿈을 꾸게 되는 겁니다.");
        reaperStory.add("항상 마음의 안정과 신체의 건강에 유의하며 생활 하셔야 합니다");
        reaperStory.add("음.....두려움은 두려움으로 극복하시라고 저승사자에 관한 무서운 이야기 하나 해드릴까요???");
        reaperStory.add("도전해보시겠다구요?? ㅎㅎ 좋습니다....바로 시작하겠습니다!");
        reaperStory.add("이야기는 10년 전의 일입니다");
        reaperStory.add("그 당시 저는 고등학교를 다니고 있었고, 그 날은 집이 비어서 친구들을 불러서 술을 마시고 있었습니다");
        reaperStory.add("안주라고 해봐야 오징어 땅콩에 바나나킥이 전부였지만 어린나이에 더 바랄 건 없었죠");
        reaperStory.add("한, 두 시간 우린 맛은 모르지만 이게 인생의 쓴맛 이라며 서로가 의기투합을 했습니다");
        reaperStory.add("분위기는 무르익었고, 많이 마신 탓에 화장실이 급해진 나는 소변을 보러 가게 되었죠");
        reaperStory.add("우리 집 화장실은 당연히 문을 닫으면 안에서 밖이 보이지 않습니다");
        reaperStory.add("그런데 이상한 것은 그 때는 화장실 안에서 밖을 볼 수가 있는 겁니다");
        reaperStory.add("그 순간 이상한 낌새가 느껴졌고, 더 이상한 것은 불과 몇 분 전만해도 지붕이 날아가랴 쩌렁쩌렁 소리만 지르던 친구들 놈들이 쥐 죽은 듯 조용하게 술잔만 따라주며 마시고 있는 겁니다");
        reaperStory.add("아무 말도 안하고 그냥 단순 행동의 무한 반복이었습니다");
        reaperStory.add("순간적으로 너무나도 소름이 돋아, 주머니에 있던 핸드폰으로 아버지, 어머니, 형 모든 가족들에게 전화를 해봤지만 전부 통화권 이탈로 나와 있었습니다");
        reaperStory.add("나는 뭔가 잘못 됐음을 느끼고 화장실에서 나가면 곧바로 집밖을 뛰쳐나갈 궁리를 하고 있었습니다");
        reaperStory.add("그렇게 잠시 뒤, 화장실 문을 박차고 현관문으로 뛰어 갔는데 문을 열라던 찰나에 초인종이 울렸습니다");
        reaperStory.add("\"띵동~  띵동~\"");
        reaperStory.add("부모님께서 돌아오셨다는 생각에 저는 안도의 한숨을 쉬었습니다");
        reaperStory.add("이미 머릿속엔 집이 비었을 때 몰래 술 마셔서 꾸중을 듣는 것 보다 지금 상황을 도피하고 싶다는 마음이 더 컸었습니다");
        reaperStory.add("그렇게 수화기를 들고 인터폰을 바라봤는데 문 앞에 있는 것은 부모님이 아니었습니다");
        reaperStory.add("그저 검은색 막대기 하나가 세워져 있을 뿐이었습니다");
        reaperStory.add("그걸 보고 저는 문을 열기가 무서워졌고 이윽고 문 반대편에 있던 놈의 광기가 전해졌습니다");
        reaperStory.add("\"띵동띵동띵동띵동띵동띵동띵동띵동띵동\"");
        reaperStory.add("그것은 계속해서 초인종을 눌렀고, 인터폰 화면 속 검은 막대기가 움직이기 시작했습니다");
        reaperStory.add("제가 검은 막대기라 생각 했던 것은 사실 그의 다리였던 것입니다.");
        reaperStory.add("그는 허리를 90도 이상으로 꺾으며 수화기 반대편의 저를 응시하고 있었습니다");
        reaperStory.add("그 검은 사내의 손은 사정없이 문고리를 잡아 돌렸고 손잡이가 반쯤 돌아 갈 때 즈음 뒤에서 친구들중 한 놈이 제 어깨에 손을 올리고 말했습니다");
        reaperStory.add("\"□□야 벌써 가려고?\"");
        reaperStory.add("그렇게 저는 눈을 떴고 주변을 둘러보니 저는 병원의 침대에 누워있었습니다");
        reaperStory.add("침대 옆에서는 어머니께서 주무시고 계셨습니다");
        reaperStory.add("사실 제가 화장실에서 소변을 보고 나올 때 미끄러져 기절했었던 것입니다");
        reaperStory.add("제가 꿨던 꿈을 어머니께 말씀드리니 그때 문을 열었으면 큰일 났을 거라고 말하셨습니다");
        reaperStory.add("왜냐하면 문 앞에 있던 것은 저승에서 저를 데리러 온 사자였기 때문입니다");

        noTalk.add("아...이해합니다. 꿈은 지극히 개인적인 것이므로 비밀로 간직하셔도 좋습니다");
        noTalk.add("다만 꿈이라는 것은 실제로 벌어지거나, 미래를 예견한다기 보다는 본인의 심신상태에 따라 무의식이 투영되는 것입니다");
        noTalk.add("그러므로 심리적으로 안정되고, 육체적으로 건강하다면 보다 꿈자리가 편안해지실 것입니다");
        noTalk.add("저희 교수진이 당신의 마음을 정화시킬 선물을 준비했습니다!");
        noTalk.add("작년 2016년도부터 저희 공포학과에 머물고있는 도토리의 응원 메세지입니다");

        watchGhost.add("이 세상에는 정말 많은 귀신들이 존재합니다");
        watchGhost.add("결론부터 말씀드리자면 최대한 귀신을 보지 않고 사는 것이 좋습니다");
        watchGhost.add("대부분의 귀신들은 원한 혹은 원념이라고 하는 이승에 대한 미련을 갖고 존재하는 경우가 많기 때문입니다");
        watchGhost.add("그런 그들을 마주하고 산다는 것은 정신적으로 온전할 수 없는 생활이 되겠죠");
        watchGhost.add("귀신들은 생김새, 등장 배경이 각양각색입니다");
        watchGhost.add("그래서인지 그들과 마주하는 방법도 다양합니다");
        watchGhost.add("그 중 가장 유명한 강령술을 알려드리겠습니다. 다시 한 번 말씀드리지만 절대 실행에 옮기시지는 마시고 이러한 방법이 있다는 것만 알고 계십시오");
        watchGhost.add("저 M교수가 직접 해보았던 나홀로숨바꼭질이라는 강령술입니다. 실제 제가 찍었던 사진과 함께 설명해드리겠습니다");
        watchGhost.add("나홀로숨바꼭질은 체계적으로 만들어진 주술이며, 자신을 강력하게 저주하는 행위입니다");
        watchGhost.add("먼저 준비물이 있습니다. 인형, 쌀, 머리카락 혹은 손톱, 실, 바늘, 소금물, 대야를 준비합니다"); // 준비물 사진 보여주기
        watchGhost.add("먼저 인형에 이름을 정해야 하며( ex) 공실이 ) 인형 안의 솜을 모두 빼고 쌀을 채웁니다");
        watchGhost.add("쌀과 함께 자신의 손톱이나 머리카락도 함께 넣어주고 붉은 실로 꿰매줍니다"); // 꿰맨 사진 보여주기
        watchGhost.add("자신이 숨을 장소를 정하고 그 장소에 소금물을 놓습니다");
        watchGhost.add("모든 창문을 닫고 모든 불을 꺼줍니다. 그리고 오컬트 심령현상을 보기 위해 tv를 켜놓습니다"); // tv사진 보여주기
        watchGhost.add("그 다음 화장실에 대야에 인형을 넣고 바늘을 손에 쥐어 줍니다"); // 바늘 손에 쥔 사진 보여주기
        watchGhost.add("그리고 화장실에서 \"첫 번째 술래는 M교수!\" 라고 말한뒤, 거실에서 열을 세고 다시 화장실로 갑니다");
        watchGhost.add("\"공실이 찾았다!, 다음 술래는 공실이!\"라고 외친 후, 바늘로 인형을 찌른 다음 숨는 장소로 가서 숨습니다"); //장롱 사진 보여주기
        watchGhost.add("도착하자마자 소금물을 입에 머금으면 그 때부터 강령술이 시작됩니다");
        watchGhost.add("이때 소금울을 삼키거나 내뱉으면 상황이 악화되거나 주술이 풀릴 수 있으므로 꼭 머금고만 있어야 합니다");
        watchGhost.add("저는 음기가 가장 세다고 하는 새벽 3시에 강령술을 진행했습니다");
        watchGhost.add("이 강령술을 끝내는 방법은 인형을 찾아서 인형에 대고 소금물을 뱉은 뒤 \"끝났다!\"라고 외치시면 됩니다");
        watchGhost.add("저는 음기가 가장 세다고 하는 새벽 3시에 강령술을 진행하였지만 별다른 현상을 목격하지는 못하였습니다");
        watchGhost.add("다만 제 방 장롱에 숨어있으면서 내방이 이렇게 싸늘하고 무서웠구나 하는 생각을 했습니다");
        watchGhost.add("다시 한 번 말씀드리지만 M교수가 직접 한 것으로 대리만족하시고 직접 해보지는 마십시오");

        ghostSpot.add("기본적으로 흉가/폐가로 나뉩니다. 폐가는 그저 아무도 살지 않는 건물, 흉가는 사람에게 해로운 집을 의미하지요");
        ghostSpot.add("우리나라에는 곤지암 정신병원, 안경공장, 늘봄가든 등 유명한 흉가 말고도 숨어있는 흉가와 폐가가 많습니다");
        ghostSpot.add("하지만 가장 중요한 사실! 이 좁은 땅덩어리에 주인 없이 버려진 집은 없다는 것!");
        ghostSpot.add("즉, 대부분의 흉가, 폐가는 사유지임으로 무단출입 자체가 죄가 될 수 있습니다. 사전에 허락받는 것을 권장합니다");
        ghostSpot.add("그리고 수많은 사람들이 오고가는 곳이기 때문에 깨진 유리병 같은 위험한 물건들이 많죠");
        ghostSpot.add("또, 오래된 건물이 많다보니 추락과 낙하 위험이 높기도 합니다. 귀신보다 더 무섭죠");
        ghostSpot.add("따라서 흉가 탐방 전에 철저한 조사와 준비 과정을 거쳐야 합니다");
        ghostSpot.add("다치지 않기 위해 긴 바지와 옷을 입고, 시야를 확보할 수 있는 강한 불빛의 랜턴 그리고 조심성이 필요합니다");
        ghostSpot.add("마지막으로 가장 중요한 것! 흉가는 괜히 흉가가 된 곳이 아닙니다");
        ghostSpot.add("정말로 악귀가 그곳에 살고 있을 가능성이 높고 저희도 여러 곳을 방문한 결과, 정말 귀신이 많다는 것을 알았습니다");
        ghostSpot.add("흉가탐방을 하실 때는 절대 귀신의 심기를 건드리시면 안 됩니다");
        ghostSpot.add("물건들을 함부로 만진다거나 시끄러운 소음을 내서 혼령을 건드리면 정말로 당신에게 들러붙을 수도 있지요");
        ghostSpot.add("이렇듯 여러모로 신경을 써야 하는 것들이 많기 때문에 사전에 유의하셔야 합니다");
        ghostSpot.add("공포학과 유튜브에 저희가 직접 다녀온 흉가 탐방 영상들이 있으니 간접적으로 체험해보시는 것도 좋은 방법이겠네요");

        mostHorrible.add("그 어느 누구라도 두렵고 무서운 것이 없는 사람은 없을 겁니다");
        mostHorrible.add("하다못해 대통령이라도 무서운 것이 하나쯤은 있겠죠?");
        mostHorrible.add("뭐, 일반적으로 이 세상에서 가장 무서운 것은 귀신을 생각하기 쉽겠지만 가장 공포스러운 것은 다름 아닌 사람입니다");
        mostHorrible.add("사람을 죽이는 것은 결국 사람입니다");
        mostHorrible.add("연쇄 살인, 장기밀매, 강간, 살해는 결국 사람의 손끝에서 만들어지죠");
        mostHorrible.add("생각해보십시오. 어느 늦은 밤 집으로 들어왔는데 내 방에 있는 침대 밑에 무언가가 납작 엎드려있습니다");
        mostHorrible.add("만약 이게 귀신이라면 소금을 뿌린다거나 영혼을 달래서 쫓아내면 되겠지만 만약 이게 사람이라면 어떨까요?");
        mostHorrible.add("생각만 해도 무섭네요...ㄷㄷ");

    }
    public void onBackPressed() {

        AlertDialog.Builder d = new AlertDialog.Builder(this);
        d.setMessage("교수님 면담을 종료하시겠습니까?");
        d.setPositiveButton("예", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // process전체 종료
                finish();
            }
        });
        d.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        d.show();
    }

    //--------이야기창 내용 설정 및 효과주기
    public void setStory(String text){
        storyText.setText("");
        storyText.setCharacterDelay(50);
        storyText.animateText(text);
    }

    public void setStory(String text, int delay){
        effectText.setText("");
        effectText.setCharacterDelay(delay);
        effectText.animateText(text);
    }


}