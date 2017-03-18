package com.horrornumber1.horrormagazine.SetView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.horrornumber1.horrormagazine.Activities.Content;
import com.horrornumber1.horrormagazine.Adapters.MyAdapter;
import com.horrornumber1.horrormagazine.Adapters.SimpleRecyclerAdapter;
import com.horrornumber1.horrormagazine.RecyclerItemClickListener;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;
import com.horrornumber1.horrormagazine.R;

/**
 * Created by 김태호 on 2017-01-13.
 */

public class SetRecycler {

    Context context;
    Activity activity;

    //Home Recycler
    RecyclerView millitaryRecycler, collegeRecycler, roarRecycler, cityRecycler;

    public SetRecycler(Context context, Activity activity)
    {
        this.context = context;
        this.activity = activity;
    }

    public void HomeRecycler()
    {
        millitaryRecycler = (RecyclerView) activity.findViewById(R.id.millitaryRecyclerView);
        collegeRecycler = (RecyclerView) activity.findViewById(R.id.collegeRecyclerView);
        roarRecycler = (RecyclerView) activity.findViewById(R.id.roarRecyclerView);
        cityRecycler = (RecyclerView) activity.findViewById(R.id.cityRecyclerView);

        //군대
        millitaryRecycler.setLayoutManager(new LinearLayoutManager(activity));
        MyAdapter militaryAdapter = new MyAdapter(DataHouse.millitary2.subList(0, 4));
        millitaryRecycler.setAdapter(militaryAdapter);
        millitaryRecycler.setItemAnimator(new DefaultItemAnimator());
        millitaryRecycler.setNestedScrollingEnabled(false);

        millitaryRecycler.addOnItemTouchListener(new RecyclerItemClickListener(context, millitaryRecycler, new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, Content.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Content.PARAM_INPUT_NAME, DataHouse.title.get(1));
                intent.putExtra(Content.PARAM_INPUT_FROM, "A");
                intent.putExtra(Content.PARAM_INPUT_INDEX, position);
                context.startActivity(intent);
            }
        }));


        //대학별 귀신이야기
        collegeRecycler.setLayoutManager(new LinearLayoutManager(activity));
        MyAdapter collegeAdapter = new MyAdapter(DataHouse.college2.subList(0, 4));
        collegeRecycler.setAdapter(collegeAdapter);
        collegeRecycler.setItemAnimator(new DefaultItemAnimator());
        collegeRecycler.setNestedScrollingEnabled(false);

        collegeRecycler.addOnItemTouchListener(new RecyclerItemClickListener(context, collegeRecycler, new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, Content.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Content.PARAM_INPUT_NAME, DataHouse.title.get(3));
                intent.putExtra(Content.PARAM_INPUT_FROM, "A");
                intent.putExtra(Content.PARAM_INPUT_INDEX, position);
                context.startActivity(intent);
            }
        }));


        //로어 이야기
        roarRecycler.setLayoutManager(new LinearLayoutManager(activity));
        SimpleRecyclerAdapter roarAdapter = new SimpleRecyclerAdapter(DataHouse.lore2.subList(0,6));
        roarRecycler.setAdapter(roarAdapter);
        roarRecycler.setItemAnimator(new DefaultItemAnimator());
        roarRecycler.setNestedScrollingEnabled(false);

        roarRecycler.addOnItemTouchListener(new RecyclerItemClickListener(context, roarRecycler, new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, Content.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Content.PARAM_INPUT_NAME, DataHouse.title.get(4));
                intent.putExtra(Content.PARAM_INPUT_FROM, "A");
                intent.putExtra(Content.PARAM_INPUT_INDEX, position);
                context.startActivity(intent);
            }
        }));


        //도시괴담
        cityRecycler.setLayoutManager(new LinearLayoutManager(activity));
        MyAdapter cityAdapter = new MyAdapter(DataHouse.city2.subList(0, 4));
        cityRecycler.setAdapter(cityAdapter);
        cityRecycler.setItemAnimator(new DefaultItemAnimator());
        cityRecycler.setNestedScrollingEnabled(false);

        cityRecycler.addOnItemTouchListener(new RecyclerItemClickListener(context, cityRecycler, new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, Content.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Content.PARAM_INPUT_NAME, DataHouse.title.get(6));
                intent.putExtra(Content.PARAM_INPUT_FROM, "A");
                intent.putExtra(Content.PARAM_INPUT_INDEX, position);
                context.startActivity(intent);
            }
        }));



    }

}
