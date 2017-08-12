package com.horrornumber1.horrordepartment.SetView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.horrornumber1.horrordepartment.R;


public class SetTextView {

    Context context;
    Activity activity;

    Typeface daum, nanumgothic, yeonsung, hanna, jua;
    // Home 화면 TextView

    private TextView toolbar_title;
    // Board 화면 TextView
    private TextView board_toolbar_title;

    public SetTextView(Context context, Activity activity)
    {
        this.context = context;
        this.activity = activity;
        daum = Typeface.createFromAsset(context.getAssets(), "fonts/daum.ttf");
        nanumgothic = Typeface.createFromAsset(context.getAssets(), "fonts/nanumgothic.ttf");
        yeonsung = Typeface.createFromAsset(context.getAssets(), "fonts/YEONSUNG.ttf");
        jua = Typeface.createFromAsset(context.getAssets(), "fonts/JUA.ttf");

    }

    public void BoardFont()
    {
        board_toolbar_title = (TextView) activity.findViewById(R.id.board_toolbar_title);
        board_toolbar_title.setTypeface(yeonsung);

    }

}
