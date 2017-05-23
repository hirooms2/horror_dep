package com.horrornumber1.horrormagazine.Widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.DataModel.MyData;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.ScrollViewListener;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by 김태호 on 2017-01-17.
 *
 *  activity_content 의 ViewPager( id: pager ) 화면을 설정하는 클래스
 *  이 클래스에서 스크롤과 배경화면등을 처리하고
 *  Text 내용을 설정한다
 *  이무이의 경우에는 Answer Text와 Button도 같이 설정한다
 */



public class ContentPage extends LinearLayout{

    Activity activity;
    Context context;
    List<MyData> contents;
    int position;
    ScrollViewExt scrollView;
    TextView content_scroll_Title, content_scroll_Text, content_scroll_AnswerText;
    Button content_scroll_AnswerBtn;
    ViewPager pager;
    LinearLayout content_bottom;
    StringBuffer buffer;
    boolean t=true;
    float alp;
    FrameLayout rug;
    Handler h;
    public ContentPage(Activity activity, Context context, List<MyData> contents, int position, ViewPager pager)
    {
        super(context);
        this.activity = activity;
        this.contents = contents;
        this.position = position;
        this.pager = pager;

        init(context);
    }
    private void init(final Context context)
    {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_text_scroll, this, true);

        alp = (float)1.0;
        rug = (FrameLayout) findViewById(R.id.content_rug);
        rug.setAlpha(alp);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<200;i++) {
                        alp *= (float)0.9;
                        Log.i("alpha", "run: " + alp);
                        sleep(5*1000);
                        rug.setAlpha(alp);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        view.setOnClickListener(new View.OnClickListener(){
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

        ImageView content_logo = (ImageView) findViewById(R.id.content_logo);
        if(contents.equals(DataHouse.region)) {
            content_logo.setImageResource(R.drawable.region_logo);
        } else if(contents.equals(DataHouse.millitary)) {
            content_logo.setImageResource(R.drawable.millitary_logo);
        } else if(contents.equals(DataHouse.real)) {
            content_logo.setImageResource(R.drawable.real_logo);
        } else if(contents.equals(DataHouse.college)) {
            content_logo.setImageResource(R.drawable.college_logo);
        } else if(contents.equals(DataHouse.lore)) {
            content_logo.setImageResource(R.drawable.lore_logo);
        } else if(contents.equals(DataHouse.understand)) {
            content_logo.setImageResource(R.drawable.understand_logo);
        } else if(contents.equals(DataHouse.city)) {
            content_logo.setImageResource(R.drawable.city_logo);
        }

        content_bottom = (LinearLayout) activity.findViewById(R.id.content_bottom);

        //화면처리
        scrollView = (ScrollViewExt) findViewById(R.id.content_scroll);
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


        /*
        background = ((ScrollView)findViewById(R.id.content_scroll)).getBackground();
        background.setAlpha(220);
        */

        // 컨텐츠 텍스트 처리
        Typeface nanumgothic = Typeface.createFromAsset(context.getAssets(), "fonts/nanumgothic.ttf");
        Typeface jua = Typeface.createFromAsset(context.getAssets(), "fonts/JUA.ttf");
        Typeface yeonsung = Typeface.createFromAsset(context.getAssets(), "fonts/YEONSUNG.ttf");
        content_scroll_Title = (TextView) findViewById(R.id.content_scroll_title);
        content_scroll_Title.setText(contents.get(position).getTitle());
        content_scroll_Title.setTypeface(yeonsung);

        content_scroll_Text = (TextView) findViewById(R.id.content_scroll_text);

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

        content_scroll_AnswerText = (TextView) findViewById(R.id.content_scroll_answerText);
        content_scroll_AnswerBtn = (Button) findViewById(R.id.content_scroll_answerBtn);

        //이무이 경우에만 Answer Text 설정
        if(contents == DataHouse.understand) {
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
    }
    private StringBuffer readText(int num) {

        String str = null;
        StringBuffer buffer = new StringBuffer();

        try {

            InputStream inputStream = context.getResources().openRawResource(num);
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
/*
    private StringBuffer readText2(String path) {

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
*/
}
