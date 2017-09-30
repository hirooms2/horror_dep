package com.horrornumber1.horrordepartment.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.Module.ScrollViewListener;
import com.horrornumber1.horrordepartment.Module.Which;
import com.horrornumber1.horrordepartment.Network.HttpConnect;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;
import com.horrornumber1.horrordepartment.Widget.ScrollViewExt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * Created by KIMTAEHO on 2017-08-11.
 */

public class ContentTextFragment extends Fragment {
    int position=1;
    String name;
    List<Model> contents;
    ScrollViewExt scrollView;
    TextView content_scroll_Title, content_scroll_Text, content_scroll_AnswerText, content_scroll_writer, content_scroll_like;
    Button content_scroll_AnswerBtn;
    LinearLayout content_bottom;
    StringBuffer buffer, buffer2;
    ImageView prev, next;
    ImageView favorite;
    Handler handler, handler2;
    boolean t=true;
    ViewGroup rootView;
    Which w = new Which();
    String TAG = "TRANSPARENT";
    int no;
    public static ContentTextFragment newInstance(String name,int position){
        ContentTextFragment fragment = new ContentTextFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        if(isVisibleToUser && rootView != null){

            String board = w.whichTable(name);
            if (!DataHouse.dbManager.FindData(board, no)) {
                Log.d(TAG, "setUserVisibleHint: " + no);
                DataHouse.dbManager.insert("insert into " + board + " values(null, '" + board + "', '" + no + "'); ");
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt("position");
            name = getArguments().getString("name");
            contents = w.whichContents(name);
            no=contents.get(position).getNo();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_text_scroll, container, false);


        content_bottom = (LinearLayout) rootView.findViewById(R.id.content_bottom);
        favorite = (ImageView) rootView.findViewById(R.id.favorite);
        favorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                HttpConnect httpConnect = new HttpConnect(getContext());
                httpConnect.connect(DataHouse.uid, w.whichBoard(name),contents.get(position).getNo());
            }
        });
        rootView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(t==true) {
                    content_bottom.animate().translationY(content_bottom.getHeight()).setInterpolator(new AccelerateInterpolator(2)).start();
                    t=false;
                } else {
                    content_bottom.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
                    t=true;
                }
            }
        });

        ImageView content_logo = (ImageView) rootView.findViewById(R.id.content_logo);
        if(contents.equals(DataHouse.region2)) {
            content_logo.setImageResource(R.drawable.region_logo);
        } else if(contents.equals(DataHouse.millitary2)) {
            content_logo.setImageResource(R.drawable.millitary_logo);
        } else if(contents.equals(DataHouse.real2)) {
            content_logo.setImageResource(R.drawable.real_logo);
        } else if(contents.equals(DataHouse.college2)) {
            content_logo.setImageResource(R.drawable.college_logo);
        } else if(contents.equals(DataHouse.lore2)) {
            content_logo.setImageResource(R.drawable.lore_logo);
        } else if(contents.equals(DataHouse.understand2)) {
            content_logo.setImageResource(R.drawable.understand_logo);
        } else if(contents.equals(DataHouse.city2)) {
            content_logo.setImageResource(R.drawable.city_logo);
        } else if(contents.equals(DataHouse.togo2)) {
            content_logo.setImageResource(R.drawable.togo_logo);
        }


        //화면처리
        scrollView = (ScrollViewExt) rootView.findViewById(R.id.content_scroll);
        scrollView.scrollTo(0, 0);
        //스크롤이 바닥에 있을 때

        ScrollViewListener scrollViewListener = new ScrollViewListener() {

            @Override
            public void onScrollChanged(ScrollViewExt scrollView, int x, int y, int oldx, int oldy) {

                View view = (View) scrollView.getChildAt(0);
                int diff = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));

                if (diff < 260) {
                    content_bottom.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();

                } else {
                    if(scrollView.getScrollY()<=10)
                        content_bottom.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
                    else
                        content_bottom.animate().translationY(content_bottom.getHeight()).setInterpolator(new AccelerateInterpolator(2)).start();
                }
            }
        };
        scrollView.setScrollViewListener(scrollViewListener);

        // 컨텐츠 텍스트 처리
        Typeface nanumgothic = Typeface.createFromAsset(getContext().getAssets(), "fonts/nanumgothic.ttf");
        Typeface jua = Typeface.createFromAsset(getContext().getAssets(), "fonts/JUA.ttf");
        Typeface yeonsung = Typeface.createFromAsset(getContext().getAssets(), "fonts/YEONSUNG.ttf");
        content_scroll_Title = (TextView) rootView.findViewById(R.id.content_scroll_title);
        content_scroll_Title.setText(contents.get(position).getTitle());
        content_scroll_Title.setTypeface(yeonsung);

        content_scroll_Text = (TextView) rootView.findViewById(R.id.content_scroll_text);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==1)
                    content_scroll_Text.setText(buffer);
                else
                    Toast.makeText(getActivity().getApplicationContext(),"네트워크 연결이 불안정합니다",Toast.LENGTH_SHORT).show();
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                buffer=readText(contents.get(position).getFile());
            }
        }).start();

        content_scroll_Text.setTypeface(nanumgothic);

        content_scroll_writer = (TextView) rootView.findViewById(R.id.content_writer);
        content_scroll_like = (TextView) rootView.findViewById(R.id.content_like);

        content_scroll_writer.setText("writer " + contents.get(position).getWriter());
        content_scroll_like.setText("like +" + contents.get(position).getLike());

        content_scroll_AnswerText = (TextView) rootView.findViewById(R.id.content_scroll_answerText);
        content_scroll_AnswerBtn = (Button) rootView.findViewById(R.id.content_scroll_answerBtn);

        //이무이 경우에만 Answer Text 설정
        if(contents == DataHouse.understand2) {
            //content_scroll_AnswerText.setText(DataHouse.understandAnswer.get(position)); //답변도 같은 위치의 내용으로 셋팅

           handler2= new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    content_scroll_AnswerText.setText(buffer2);
                }
            };
            new Thread(new Runnable() {
                @Override
                public void run() {
                    buffer2=readText(contents.get(position).getFile2());
                    handler2.sendEmptyMessage(0);
                }
            }).start();


            content_scroll_AnswerText.setVisibility(View.INVISIBLE); // 기본적으로는 자리는 차지하고있는데 안보이도록
            content_scroll_AnswerBtn.setText("해설");
            content_scroll_AnswerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation openAnimation = new AlphaAnimation(0, 1);
                    openAnimation.setDuration(1000);
                    content_scroll_AnswerText.setVisibility(View.VISIBLE);                              //답변보기 버튼 눌리면 생기는 애니메이션
                    content_scroll_AnswerText.setAnimation(openAnimation);
                }
            });
        }

        // 이전 다음 버튼은 activity_content layout에서 관리한다
        prev = (ImageView)rootView.findViewById(R.id.prevBtn); //이전 버튼
        next = (ImageView)rootView.findViewById(R.id.nextBtn); //다음 버튼

        if(position==0) {
            prev.setVisibility(View.INVISIBLE); // 시작할때 첫번째 이야기 누르면 이전 버튼 안보이고 시작
            next.setVisibility(View.VISIBLE);
        }
        else if(position ==contents.size()-1) {
            next.setVisibility(View.INVISIBLE); // 시작할때 마지막 이야기 누르면 다음 버튼 안보이고 시작
            prev.setVisibility(View.VISIBLE);
        }

        return rootView;
    }
    private StringBuffer readText(String path) {

        String str = null;
        StringBuffer buffer = new StringBuffer();

        try {

            InputStream inputStream = new URL(path).openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"EUC-KR");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while((str = bufferedReader.readLine())!=null)
            {
                buffer.append(str+"\n");
            }
            handler.sendEmptyMessage(1);
        } catch (IOException e) {
            Log.d("READTEXT", "error: " + contents.get(position).getTitle());
            handler.sendEmptyMessage(0);
        }
        return buffer;
    }

//    private StringBuffer readText(int num) {
//
//        String str = null;
//        StringBuffer buffer = new StringBuffer();
//
//        try {
//
//            InputStream inputStream = getContext().getResources().openRawResource(num);
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"EUC-KR");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            while((str = bufferedReader.readLine())!=null)
//            {
//                buffer.append(str+"\n");
//            }
//        } catch (IOException e) {
//
//        }
//        return buffer;
//    }
        // *****************************Content Activity의 ViewPager를 설정함***********************


    //replace 시 이전 fragment가 정리되는지 알아보기 위함 -> replace하면 전에 있던 fragment는 알아서 리소스 정리됨
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }




}
