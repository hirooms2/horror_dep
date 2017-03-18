package com.horrornumber1.horrormagazine.SetView;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.horrornumber1.horrormagazine.Activities.Content;
import com.horrornumber1.horrormagazine.Adapters.CardAdapter;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.RecyclerItemClickListener;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

/**
 * Created by 김태호 on 2017-01-13.
 */

public class SetCard {

    Context context;
    Activity activity;

    RecyclerView realRecycler, understandRecycler;


    public SetCard(Context context, Activity activity)
    {
        this.context = context;
        this.activity = activity;
    }

    public void HomeCard()
    {
        realRecycler = (RecyclerView) activity.findViewById(R.id.realRecyclerView);
        understandRecycler = (RecyclerView) activity.findViewById(R.id.understandRecyclerView);

        //실제
        realRecycler.setLayoutManager(new GridLayoutManager(activity, 2));
        realRecycler.setAdapter(new CardAdapter(DataHouse.real2.subList(0, 4)));
        realRecycler.setNestedScrollingEnabled(false);

        realRecycler.addOnItemTouchListener(new RecyclerItemClickListener(context, realRecycler, new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, Content.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Content.PARAM_INPUT_NAME, DataHouse.title.get(2));
                intent.putExtra(Content.PARAM_INPUT_FROM, "A");
                intent.putExtra(Content.PARAM_INPUT_INDEX, position);
                context.startActivity(intent);
            }
        }));

        //이무이

        understandRecycler.setLayoutManager(new GridLayoutManager(activity, 2));
        understandRecycler.setAdapter(new CardAdapter(DataHouse.understand2.subList(0, 4)));
        understandRecycler.setNestedScrollingEnabled(false);

        understandRecycler.addOnItemTouchListener(new RecyclerItemClickListener(context, understandRecycler, new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, Content.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Content.PARAM_INPUT_NAME, DataHouse.title.get(5));
                intent.putExtra(Content.PARAM_INPUT_FROM, "A");
                intent.putExtra(Content.PARAM_INPUT_INDEX, position);
                context.startActivity(intent);
            }
        }));
    }


}
