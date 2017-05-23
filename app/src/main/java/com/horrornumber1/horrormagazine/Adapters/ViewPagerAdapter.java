package com.horrornumber1.horrormagazine.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.DataModel.MyData;
import com.horrornumber1.horrormagazine.Widget.ContentPage;

import java.util.List;

/**
 * Created by 김태호 on 2017-01-17.
 *
 *  Activity에서 ViewPager을 설정하기 위한 Adapter이다
 *  구체적인 내용은 ContentPage에서 설정하기에
 *  이 곳에서는 ContentPage 클래스를 선언하고 AddView만 진행한다
 *
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Activity activity;
    private Context context;
    List<MyData> contents;
    ViewPager pager;
    public ViewPagerAdapter(Activity activity, Context context, List<MyData> contents, ViewPager pager) {
        this.activity = activity;
        this.context = context;
        this.contents = contents;
        this.pager = pager;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ContentPage page = new ContentPage (activity, context, contents, position, pager);
        ((ViewPager)container).addView(page);
        return page;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

}
