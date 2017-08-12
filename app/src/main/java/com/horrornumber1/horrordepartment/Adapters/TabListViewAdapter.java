package com.horrornumber1.horrordepartment.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.horrornumber1.horrordepartment.DataModel.MyData;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.List;
public class TabListViewAdapter extends ArrayAdapter<MyData> {

    Context context;
    List<MyData> contents;
    int rowResourceId;
    String board;

    public TabListViewAdapter(Context context, int rowResourceId, List<MyData> contents, String name) {
        super(context, rowResourceId, contents);
        this.context = context;
        this.contents = contents;
        this.rowResourceId = rowResourceId;
        this.board = whichTable(name);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(this.rowResourceId, null);
        }
        MyData model = contents.get(position);
        TextView title = (TextView) v.findViewById(R.id.listlow_title);
        title.setText(model.getTitle());
        Log.i("string: ", board + " " + position);
        if (DataHouse.dbManager.FindData(board, position)) {
            Log.i("gray", board + " " + position);
            title.setTextColor(Color.GRAY);
        } else {
            title.setTextColor(Color.WHITE);
        }
        return v;
    }

    private String whichTable(String name) {
        switch (name) {
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
}