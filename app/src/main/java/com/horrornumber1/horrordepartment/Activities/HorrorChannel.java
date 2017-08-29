package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.horrornumber1.horrordepartment.R;

public class HorrorChannel extends AppCompatActivity {
    private FrameLayout notifyFrame; // 공지사항 프레임 레이아웃
    private Animation bottomShow, bottomHide; // 위에서 떨어지고 올라가는 공지사항 애니메이션
    private ImageView announce, horrorGame, horrorRadio, horrorSpot; // 공지사항 버튼
    private TextView closeNotify; // 창닫기 버튼
    private ImageView kakaoFriend, facebook; //카카오 플러스친구, 페이스북
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror_channel);

        notifyFrame = (FrameLayout)findViewById(R.id.notifyFrame);
        notifyFrame.setVisibility(View.GONE); // 기본적으로는 안보이는 상태로

        bottomShow = AnimationUtils.loadAnimation(this, R.anim.bottom_in); //애니메이션 세팅
        bottomHide = AnimationUtils.loadAnimation(this, R.anim.bottom_out);

        announce = (ImageView)findViewById(R.id.announceBtn); //공지사항, 호러게임, 공포라디오, 흉가탐방 이미지
        horrorGame = (ImageView)findViewById(R.id.horrorGameBtn);
        horrorRadio = (ImageView)findViewById(R.id.horrorRadioBtn);
        horrorSpot = (ImageView)findViewById(R.id.horrorSpotBtn);

        kakaoFriend = (ImageView)findViewById(R.id.kakaoFriend);
        facebook = (ImageView)findViewById(R.id.facebookimg);

        announce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyFrame.setVisibility(View.VISIBLE);
                notifyFrame.startAnimation(bottomShow); //애니메이션 동작하면서 안보이던 공지사항 프레임 등장

                announce.setVisibility(View.GONE); // 프레임 레이아웃이다 보니까 버튼을 안없애면 온클릭이 계속먹는다 날리자
                horrorGame.setVisibility(View.GONE);
                horrorRadio.setVisibility(View.GONE);
                horrorSpot.setVisibility(View.GONE);
            }
        });

        closeNotify = (TextView)findViewById(R.id.notifyCloseBtn);
        closeNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyFrame.setVisibility(View.GONE);
                notifyFrame.startAnimation(bottomHide); //애니메이션 동작하면서 안보이던 공지사항 프레임 안보이게

                announce.setVisibility(View.VISIBLE); // 컴백
                horrorGame.setVisibility(View.VISIBLE);
                horrorRadio.setVisibility(View.VISIBLE);
                horrorSpot.setVisibility(View.VISIBLE);
            }
        });

        kakaoFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://pf.kakao.com/_Glgxdxl"));
                startActivity(i);

            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/horrorNo.1"));
                startActivity(i);
            }
        });

        horrorGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HorrorChannel.this, HorrorGameActivity.class );
                startActivity(i);
            }
        });


    }}
