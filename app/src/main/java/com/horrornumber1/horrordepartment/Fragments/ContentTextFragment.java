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

import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.ScrollViewListener;
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
    TextView content_scroll_Title, content_scroll_Text, content_scroll_AnswerText;
    Button content_scroll_AnswerBtn;
    LinearLayout content_bottom;
    StringBuffer buffer;
    ImageView prev, next;
    boolean t=true;
    ViewGroup rootView;
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
            String board = whichTable(name);
            if (!DataHouse.dbManager.FindData(board, position)) {
                DataHouse.dbManager.insert("insert into " + board + " values(null, '" + board + "', '" + Integer.toString(position) + "'); ");
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt("position");
            name = getArguments().getString("name");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_text_scroll, container, false);

        contents = whichContents(name);
        if(contents==null)
            Log.i("error msg", "onCreateView: ");
        content_bottom = (LinearLayout) rootView.findViewById(R.id.content_bottom);

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
                Log.i("scroll", "getbottom: " + Integer.toString(view.getBottom()));
                Log.i("scroll", "getHeight: " + Integer.toString(scrollView.getHeight()));
                Log.i("scroll", "getScrollY: " + Integer.toString(scrollView.getScrollY()));
                Log.i("scroll", "diff: " + Integer.toString(diff));
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

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                content_scroll_Text.setText(buffer);
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                buffer=readText(contents.get(position).getFile());
                handler.sendEmptyMessage(0);
            }
        }).start();

        content_scroll_Text.setTypeface(nanumgothic);

        content_scroll_AnswerText = (TextView) rootView.findViewById(R.id.content_scroll_answerText);
        content_scroll_AnswerBtn = (Button) rootView.findViewById(R.id.content_scroll_answerBtn);

        //이무이 경우에만 Answer Text 설정
        if(contents == DataHouse.understand2) {
            content_scroll_AnswerText.setText(DataHouse.understandAnswer.get(position)); //답변도 같은 위치의 내용으로 셋팅
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
        } catch (IOException e) {

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
    private List<Model> whichContents(String name) {
        switch (name) {
            case "지역괴담":
                return DataHouse.region2;
            case "군대괴담":
                return DataHouse.millitary2;
            case "실제이야기":
                return DataHouse.real2;
            case "대학괴담":
                return DataHouse.college2;
            case "로어":
                return DataHouse.lore2;
            case "이해하면 무서운 이야기":
                return DataHouse.understand2;
            case "도시괴담":
                return DataHouse.city2;
        }
        return null;
    }
}
