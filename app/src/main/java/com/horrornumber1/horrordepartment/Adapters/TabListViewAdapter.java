package com.horrornumber1.horrordepartment.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.Module.Which;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class TabListViewAdapter extends ArrayAdapter<Model> {

    Context context;
    List<Model> contents;
    int rowResourceId;
    String board;
    Which w = new Which();
    String TAG = "TRANSPARENT";
    public TabListViewAdapter(Context context, int rowResourceId, List<Model> contents, String name) {
        super(context, rowResourceId, contents);
        this.context = context;
        this.contents = contents;
        this.rowResourceId = rowResourceId;
        this.board = w.whichTable(name);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(this.rowResourceId, null);
        }
        Model model = contents.get(position);
        TextView title = (TextView) v.findViewById(R.id.listlow_title);
        TextView date = (TextView) v.findViewById(R.id.listlow_new);
        TextView like = (TextView) v.findViewById(R.id.listlow_like);
        TextView likenum = (TextView) v.findViewById(R.id.listlow_likenum);

        title.setText(model.getTitle());
        likenum.setText(String.valueOf(model.getLike()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if(sdf.format(new Date()).equals(model.getDate())){
            date.setText("new");
        } else {
            date.setText("");
        }
        Log.d(TAG, "getView: " + model.getNo());
        if (DataHouse.dbManager.FindData(board, model.getNo())) {
            Log.d(TAG, "getView: gray " + model.getNo());
            title.setTextColor(Color.GRAY);
            like.setTextColor(Color.GRAY);
            likenum.setTextColor(Color.GRAY);
        } else {
            Log.d(TAG, "getView: white " + model.getNo());
            title.setTextColor(Color.WHITE);
            like.setTextColor(Color.WHITE);
            likenum.setTextColor(Color.WHITE);
        }
        return v;
    }


}