package com.horrornumber1.horrormagazine.Adapters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.R;

import java.util.List;

/**
 * Created by 이승헌 on 2017-01-05.
 */

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder>{

    private List<Model> itemData;

    public SimpleRecyclerAdapter(List<Model> itemData){

        this.itemData = itemData;
    }

    @Override
    public SimpleRecyclerAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.roar_item_view, null);

        SimpleViewHolder viewHolder = new SimpleViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleRecyclerAdapter.SimpleViewHolder viewHolder, int position){
        viewHolder.txtViewTitle.setText(itemData.get(position).getTitle());
    }

    public static class SimpleViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        Typeface font = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/nanumgothic.ttf");

        public SimpleViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.roar_item_title);
            txtViewTitle.setTypeface(font);
        }
    }
    @Override
    public int getItemCount(){
        return itemData.size();
    }

}
