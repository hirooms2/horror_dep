package com.horrornumber1.horrormagazine.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 김태호 on 2017-01-21.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<String> parentList;
    private HashMap<String, List<Model>> childHashMap;

    public ExpandableAdapter(Context context, ArrayList<String> parentList, HashMap<String, List<Model>> childHashMap)
    {
        this.context = context;
        this.parentList = parentList;
        this.childHashMap = childHashMap;
    }
    @Override
    public Object getGroup(int i) {
        return parentList.get(i);
    }

    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater groupInfla = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = groupInfla.inflate(R.layout.expandable_parent_item, viewGroup, false);
        }
        TextView title = (TextView)view.findViewById(R.id.board_parent_title);
        title.setText(parentList.get(i));
        return view;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childHashMap.get(parentList.get(groupPosition)).get(childPosition);
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return childHashMap.get(parentList.get(groupPosition)).size();
    }



    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_low, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.listlow_title);
        textView.setText(((Model) getChild(groupPosition, childPosition)).getTitle());
        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

}
