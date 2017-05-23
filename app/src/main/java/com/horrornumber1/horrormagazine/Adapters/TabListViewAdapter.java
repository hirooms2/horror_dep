package com.horrornumber1.horrormagazine.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.DataModel.MyData;
import com.horrornumber1.horrormagazine.R;

import java.util.List;

/**
 * Created by 김태호 on 2017-01-21.
 */

public class TabListViewAdapter extends ArrayAdapter<MyData> {

    Context context;
    List<MyData> contents;
    int rowResourceId;

    public TabListViewAdapter(Context context, int rowResourceId, List<MyData> contents)
    {
        super(context, rowResourceId, contents);
        this.context = context;
        this.contents = contents;
        this.rowResourceId = rowResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(this.rowResourceId, null);
        }
        MyData model = contents.get(position);
        TextView title = (TextView) v.findViewById(R.id.listlow_title);
        title.setText(model.getTitle());
        return v;
    }
}
