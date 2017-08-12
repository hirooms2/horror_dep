package com.horrornumber1.horrordepartment.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.horrornumber1.horrordepartment.DataModel.FavoriteModel;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;


public class FavoriteListViewAdapter extends BaseAdapter implements View.OnClickListener{

    public interface ListBtnClickListener {
        void onListBtnClick(int position);
    }

    Context context;
    ArrayList<FavoriteModel> list;
    private  ListBtnClickListener listBtnClickListener;

    public FavoriteListViewAdapter(Context context, ArrayList<FavoriteModel> list, ListBtnClickListener listBtnClickListener) {
        this.context = context;
        this.list = list;
        this.listBtnClickListener = listBtnClickListener;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(v==null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.favorite_listlow, null);
        }
        TextView title = (TextView) v.findViewById(R.id.favorite_listview_title);
        title.setText(list.get(i).getTitle());
        TextView board = (TextView) v.findViewById(R.id.favorite_listview_board);
        board.setText(whichBoard(list.get(i).getBoard()));
        TextView date = (TextView) v.findViewById(R.id.favorite_listview_date);
        date.setText(list.get(i).getDate());

        ImageView delete = (ImageView) v.findViewById(R.id.favorite_listview_delete);
        delete.setTag(i);
        delete.setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {
        if(this.listBtnClickListener != null) {
            this.listBtnClickListener.onListBtnClick((int)v.getTag());
        }
    }
    private String whichBoard(String str) {

        switch (str) {
            case "REGION":
                return "지역괴담. ";
            case "MILLITARY":
                return "군대괴담. ";
            case "REAL":
                return "실화괴담. ";
            case "COLLEGE":
                return "대학괴담. ";
            case "LORE":
                return "로어. ";
            case "UNDERSTAND":
                return "이무이. ";
            case "CITY":
                return "도시괴담. ";
        }
        return null;
    }

}
