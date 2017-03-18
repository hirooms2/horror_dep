package com.horrornumber1.horrormagazine.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.horrornumber1.horrormagazine.DataModel.MyData;
import com.horrornumber1.horrormagazine.Widget.DrawerItemView;

import java.util.List;

/**
 * Created by 김태호 on 2017-01-13.
 */

public class DrawerAdapter extends BaseAdapter {

    private Context context;
    private List<MyData> contents;

    public DrawerAdapter(Context context, List<MyData> contents)
    {
        this.contents = contents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object getItem(int i) {
        return contents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DrawerItemView drawerItemView;
        if (view == null) {
            drawerItemView = new DrawerItemView(context, contents.get(i));
        } else {
            drawerItemView = (DrawerItemView) view;
            drawerItemView.bind(contents.get(i));
        }
        return drawerItemView;
    }
}
