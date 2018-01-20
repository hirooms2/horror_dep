package com.horrornumber1.horrordepartment.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.horrornumber1.horrordepartment.CounsilClass.ListItem;
import com.horrornumber1.horrordepartment.CounsilClass.RecyclerItemClickListener;
import com.horrornumber1.horrordepartment.DataModel.Youtube_key;
import com.horrornumber1.horrordepartment.Module.Youtube_Util;
import com.horrornumber1.horrordepartment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BroadcastActivity extends AppCompatActivity {
    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<ListItem> items;

    int whichBtn = -1;
    int whichContent=-1;
    String img="";

    List<Youtube_key> key_list = new ArrayList<>();
    Intent from;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        Youtube_Util youtube_util = new Youtube_Util();

        mContext = getApplicationContext();

        from = getIntent();

        whichBtn = from.getIntExtra("whichBtn", -1);
        whichContent = from.getIntExtra("whichContent", -1);
        img = youtube_util.whichImg(whichBtn, whichContent);

        recyclerView = (RecyclerView)findViewById(R.id.game_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        items = new ArrayList<>();

        key_list = youtube_util.searchTab2_All(whichBtn, whichContent);

        for(int i=0; i<key_list.size(); i++){
            items.add(new ListItem(img, key_list.get(i).getName()));
        }

        Adapter = new BroadcastAdapter(items, mContext);
        recyclerView.setAdapter(Adapter);

        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(mContext, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                        intent.putExtra("key", key_list.get(position).getKey());
                        startActivity(intent);
                    }
                })
        );
    }
    public class BroadcastAdapter extends RecyclerView.Adapter<BroadcastAdapter.ViewHolder> {

        private Context context;
        private ArrayList<ListItem> mItems;
        private int lastPosition = -1;

        public BroadcastAdapter(ArrayList<ListItem> items, Context mContext) {
            mItems = items;
            context = mContext;
        }

        @Override
        public BroadcastAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.countsil_item_cardview, parent, false);
            return new BroadcastAdapter.ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(BroadcastAdapter.ViewHolder holder, final int position) {

            Picasso.with(context).load(mItems.get(position).getImage()).into(holder.imageView);
            holder.textView.setText(mItems.get(position).imagetitle);
            setAnimation(holder.imageView, position);

        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView imageView;
            public TextView textView;

            public ViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.image);
                textView = (TextView) view.findViewById(R.id.imagetitle);
            }
        }

        private void setAnimation(View viewToAnimate, int position) {
            if (position > lastPosition) {
                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
        }
    }

}
