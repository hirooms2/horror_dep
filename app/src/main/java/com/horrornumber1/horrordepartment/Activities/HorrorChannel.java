package com.horrornumber1.horrordepartment.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.horrornumber1.horrordepartment.Network.Download;
import com.horrornumber1.horrordepartment.Network.Youtube_key_con;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;

public class HorrorChannel extends AppCompatActivity {

    private FrameLayout notifyFrame; // 공지사항 프레임 레이아웃
    private Animation bottomShow, bottomHide; // 위에서 떨어지고 올라가는 공지사항 애니메이션
    private ImageView announce, horrorGame, horrorRadio, horrorSpot; // 공지사항 버튼
    private TextView closeNotify; // 창닫기 버튼
    private ImageView kakaoFriend, facebook; //카카오 플러스친구, 페이스북

    ArrayList<String> games_arr = new ArrayList<>(); // 호러게임 제목
    ArrayList<Integer> gameImage_arr = new ArrayList<>(); // 호러게임 이미지

    ArrayList<String> radios_arr = new ArrayList<>(); // 호러라디오 제목
    ArrayList<Integer> radioImage_arr = new ArrayList<>(); // 호러라디오 이미지

    ArrayList<String> horror_spot_arr = new ArrayList<>(); // 흉가 탐방 제목
    ArrayList<Integer> horror_spot_img_arr = new ArrayList<>(); // 흉가 탐방 이미지

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror_channel);

        // ----------HorrorGame Data Init---------- //
        games_arr.add("가장 유명한 공포게임 아오오니");
        games_arr.add("역대급 태국산 공포게임 Araya");
        games_arr.add("공포의 무한반복 Continuously");
        games_arr.add("학교 안에서 벌어지는 섬뜩한 일들");
        games_arr.add("갑툭튀가 너무 많은 탈출 게임 Monstrum");
        games_arr.add("인디게임인데 진심 더럽게 무서움... 빨간마스크");
        games_arr.add("제발 집 좀 가자...아줌마 귀신 레전드.." +'\n'+
                "Home Sweet Home");
        games_arr.add("공포 띵작 \"아웃라스트1\"" +'\n'+
                "Outlast1");
        games_arr.add("일본에서 작정하고 만든 공포게임" +'\n'+
                "그림자 복도");


        gameImage_arr.add(R.drawable.aooni);
        gameImage_arr.add(R.drawable.araya);
        gameImage_arr.add(R.drawable.continuously);
        gameImage_arr.add(R.drawable.misao);
        gameImage_arr.add(R.drawable.monstrum);
        gameImage_arr.add(R.drawable.red_mask);
        gameImage_arr.add(R.drawable.home_sweet_home);
        gameImage_arr.add(R.drawable.outlast);
        gameImage_arr.add(R.drawable.shadow_corridor);
        // ---------HorrorGame Data Init----------- //

        // ---------HorrorRadio Data Init----------- //
        radios_arr.add("직접 보고 듣는 신개념 공포라디오");
        radios_arr.add("성인이 아니면 이해할 수 없는 이야기");
        radios_arr.add("내 여보");
        radios_arr.add("청취자 투고 공포실화");
        radios_arr.add("상상하면 오금이 저리는 이야기");
        radios_arr.add("당장이라도 당신에게 일어날 수 있는 이야기");
        radios_arr.add("공포 매니아들도 무서워하는 이야기");

        radioImage_arr.add(R.drawable.radio_main);
        radioImage_arr.add(R.drawable.adult_radio);
        radioImage_arr.add(R.drawable.my_honey);
        radioImage_arr.add(R.drawable.follower_story);
        radioImage_arr.add(R.drawable.strange_story);
        radioImage_arr.add(R.drawable.city_story);
        radioImage_arr.add(R.drawable.horror_story);

        // ---------HorrorRadio Data Init----------- //

        // ---------HorrorRadio Data Init----------- //
        horror_spot_arr.add("1200명이 죽었다는 숲 아오키가하라");
        horror_spot_arr.add("의정부 폐건물 탐방");
        horror_spot_arr.add("대전 충일여고 폐교 탐방");
        horror_spot_arr.add("서울 홍은동 폐가 탐방");
        horror_spot_arr.add("천안 폐교 4인 스쿼드 의문의 소리의 정체는...?");

        horror_spot_img_arr.add(R.drawable.jookai);
        horror_spot_img_arr.add(R.drawable.euijungboo);
        horror_spot_img_arr.add(R.drawable.choongil);
        horror_spot_img_arr.add(R.drawable.hongeundong);
        horror_spot_img_arr.add(R.drawable.cheonanghost);


        // ---------HorrorRadio Data Init----------- //


        notifyFrame = (FrameLayout) findViewById(R.id.notifyFrame);
        notifyFrame.setVisibility(View.GONE); // 기본적으로는 안보이는 상태로

        bottomShow = AnimationUtils.loadAnimation(this, R.anim.bottom_in); //애니메이션 세팅
        bottomHide = AnimationUtils.loadAnimation(this, R.anim.bottom_out);

        announce = (ImageView) findViewById(R.id.announceBtn); //공지사항, 호러게임, 공포라디오, 흉가탐방 이미지
        horrorGame = (ImageView) findViewById(R.id.horrorGameBtn);
        horrorRadio = (ImageView) findViewById(R.id.horrorRadioBtn);
        horrorSpot = (ImageView) findViewById(R.id.horrorSpotBtn);

        kakaoFriend = (ImageView) findViewById(R.id.kakaoFriend);
        facebook = (ImageView) findViewById(R.id.facebookimg);

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

        closeNotify = (TextView) findViewById(R.id.notifyCloseBtn);
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
                Intent i = new Intent(HorrorChannel.this, HorrorChannelSelect.class);
                i.putExtra("whichBtn", 0);
                i.putStringArrayListExtra("horrorgameString", games_arr);
                i.putIntegerArrayListExtra("horrorgameImg", gameImage_arr);
                startActivity(i);
            }
        });
        horrorRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HorrorChannel.this, HorrorChannelSelect.class);
                i.putExtra("whichBtn", 1);
                i.putStringArrayListExtra("horrorradioString", radios_arr);
                i.putIntegerArrayListExtra("horrorradioImg", radioImage_arr);
                startActivity(i);
            }
        });
        horrorSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HorrorChannel.this, HorrorChannelSelect.class);
                i.putExtra("whichBtn", 2);
                i.putStringArrayListExtra("horrorspotString", horror_spot_arr);
                i.putIntegerArrayListExtra("horrorspotImg", horror_spot_img_arr);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("공포 방송국을 나가시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        HorrorChannel.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

}