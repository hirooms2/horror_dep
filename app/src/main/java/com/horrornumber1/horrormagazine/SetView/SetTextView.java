package com.horrornumber1.horrormagazine.SetView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.Activities.Board;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;


/**
 * Created by 김태호 on 2017-01-13.
 */

public class SetTextView {

    Context context;
    Activity activity;

    Typeface daum, nanumgothic, yeonsung, hanna, jua;
    // Home 화면 TextView
    private TextView region_title, millitary_title, real_title, college_title, cartoon_title, roar_title, understand_title, city_title,
            region_more, millitary_more, real_more, college_more, cartoon_more, roar_more, understand_more, city_more;
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

    public void HomeFont()
    {

        region_title = (TextView) activity.findViewById(R.id.region_title);
        millitary_title = (TextView) activity.findViewById(R.id.millitary_title);
        real_title = (TextView) activity.findViewById(R.id.real_title);
        college_title = (TextView) activity.findViewById(R.id.college_title);
        //cartoon_title = (TextView) activity.findViewById(R.id.cartoon_title);
        roar_title = (TextView) activity.findViewById(R.id.roar_title);
        understand_title = (TextView) activity.findViewById(R.id.understand_title);
        city_title = (TextView) activity.findViewById(R.id.city_title);

        region_more = (TextView) activity.findViewById(R.id.region_more);
        region_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Board.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(0));
                context.startActivity(intent);
            }
        });

        millitary_more = (TextView) activity.findViewById(R.id.millitary_more);
        millitary_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Board.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(1));
                context.startActivity(intent);
            }
        });

        real_more = (TextView) activity.findViewById(R.id.real_more);
        real_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Board.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(2));
                context.startActivity(intent);
            }
        });
        college_more = (TextView) activity.findViewById(R.id.college_more);
        college_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Board.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(3));
                context.startActivity(intent);
            }
        });

        /*
        cartoon_more = (TextView) activity.findViewById(R.id.cartoon_more);
        cartoon_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Board.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(4));
                context.startActivity(intent);
            }
        });
        */
        roar_more = (TextView) activity.findViewById(R.id.roar_more);
        roar_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Board.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(4));
                context.startActivity(intent);
            }
        });
        understand_more = (TextView) activity.findViewById(R.id.understand_more);
        understand_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Board.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(5));
                context.startActivity(intent);
            }
        });
        city_more = (TextView) activity.findViewById(R.id.city_more);
        city_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Board.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Board.PARAM_INPUT_NAME, DataHouse.title.get(6));
                context.startActivity(intent);
            }
        });
        toolbar_title = (TextView) activity.findViewById(R.id.main_toolbar_title);

        toolbar_title.setTypeface(yeonsung);

        region_title.setTypeface(jua);
        roar_title.setTypeface(jua);
        millitary_title.setTypeface(jua);
        real_title.setTypeface(jua);
        college_title.setTypeface(jua);
        //cartoon_title.setTypeface(jua);
        roar_title.setTypeface(jua);
        understand_title.setTypeface(jua);
        city_title.setTypeface(jua);

        region_more.setTypeface(nanumgothic);
        millitary_more.setTypeface(nanumgothic);
        real_more.setTypeface(nanumgothic);
        college_more.setTypeface(nanumgothic);
        //cartoon_more.setTypeface(nanumgothic);
        roar_more.setTypeface(nanumgothic);
        understand_more.setTypeface(nanumgothic);
        city_more.setTypeface(nanumgothic);


    }
    public void BoardFont()
    {
        board_toolbar_title = (TextView) activity.findViewById(R.id.board_toolbar_title);
        board_toolbar_title.setTypeface(yeonsung);

    }

}
