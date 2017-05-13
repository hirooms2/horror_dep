package com.horrornumber1.horrormagazine.Adapters;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 김태호 on 2017-01-18.
 */

public class CartoonPagerAdapter extends PagerAdapter {
    LayoutInflater inflater;
    Activity activity;
    int num;
    List<Integer> cartoons0 = new ArrayList<>();
    List<Integer> cartoons1 = new ArrayList<>();
    private View hidden_bottomview, hidden_topview;
    private Animation bottomShow, bottomHide, topShow, topHide;
    private TextView numText, titleText;
    View view;
    private boolean open = true;


    public static final int VIEW_COUNT = 4;

    public CartoonPagerAdapter(LayoutInflater inflater, Activity activity, int num) {
        this.inflater=inflater;
        this.activity = activity;
        this.num = num;
    }

    @Override
    public int getCount() {
        return VIEW_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        view= inflater.inflate(R.layout.fragment_cartoon_layout, null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidden();
            }
        });

        //setup Top Bottom Bar
        setBar();

        //Image setup
        ImageView img= (ImageView)view.findViewById(R.id.cartoon_pager_image);
        setCartoons0();
        setCartoons1();

        switch (num) {
            case 0:
                img.setImageResource(cartoons0.get(position));
                container.addView(view);
                break;
            case 1:
                img.setImageResource(cartoons1.get(position));
                container.addView(view);
                break;
        }


        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View v, Object obj) {

        return v==obj;
    }
    private void setCartoons0(){
        cartoons0.add(R.drawable.cartoon_first1);
        cartoons0.add(R.drawable.cartoon_first2);
        cartoons0.add(R.drawable.cartoon_first3);
        cartoons0.add(R.drawable.cartoon_first4);
    }
    private void setCartoons1(){
        //cartoons1.add(R.drawable.cartoon_second1);
        //cartoons1.add(R.drawable.cartoon_second2);
        //cartoons1.add(R.drawable.cartoon_second3);
        //cartoons1.add(R.drawable.cartoon_second4);
    }
    private void setBar() {
        // top bottom button
        hidden_topview = activity.findViewById(R.id.hidden_topview);
        //hidden_topview.setVisibility(View.GONE);
        hidden_bottomview = activity.findViewById(R.id.hidden_bottomview);
        //hidden_bottomview.setVisibility(View.GONE);
        bottomShow = AnimationUtils.loadAnimation(view.getContext(), R.anim.bottom_in);
        bottomHide = AnimationUtils.loadAnimation(view.getContext(), R.anim.bottom_out);
        topShow = AnimationUtils.loadAnimation(view.getContext(), R.anim.top_in);
        topHide = AnimationUtils.loadAnimation(view.getContext(), R.anim.top_out);

        numText = (TextView)activity.findViewById(R.id.number);
        titleText = (TextView)activity.findViewById(R.id.title);
        numText.setText("0"+(num+1)+"화");
        titleText.setText(DataHouse.cartoon2.get(num).getTitle());

    }

    public void hidden(){
        if (!open) {
            hidden_topview.setVisibility(View.VISIBLE);
            hidden_topview.startAnimation(topShow);
            hidden_bottomview.setVisibility(View.VISIBLE);
            hidden_bottomview.startAnimation(bottomShow);
            open = true;
        } else {
            hidden_bottomview.startAnimation(bottomHide);
            hidden_bottomview.setVisibility(View.GONE);
            hidden_topview.startAnimation(topHide);
            hidden_topview.setVisibility(View.GONE);
            open = false;
        }
    }
}
