package com.horrornumber1.horrormagazine.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 이승헌 on 2017-01-04.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Model> itemData;
    private Context context;

    public MyAdapter(List<Model> itemData){
        this.itemData = itemData;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        context=parent.getContext();
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_itemview, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        viewHolder.txtViewTitle.setText(itemData.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.listener(new Picasso.Listener()
        {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
            {
                Toast.makeText(context, "e", Toast.LENGTH_LONG).show();
            }
        });
        builder.build().load(itemData.get(position).getIcon()).into(viewHolder.imgViewIcon);

        //Picasso.with(context).load(itemData.get(position).getIcon()).into(viewHolder.imgViewIcon);
        //viewHolder.imgViewIcon.setImageResource(itemData.get(position).getIcon());
    }

    public static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }
    }
    @Override
    public int getItemCount(){
        return itemData.size();
    }
}
