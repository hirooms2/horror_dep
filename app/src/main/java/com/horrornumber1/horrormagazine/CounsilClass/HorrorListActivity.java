package com.horrornumber1.horrormagazine.CounsilClass;

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
import android.widget.Toast;

import com.horrornumber1.horrormagazine.R;

import java.util.ArrayList;

public class HorrorListActivity extends AppCompatActivity {

    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<ListItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counsil_horror_list);

        mContext = getApplicationContext();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        items = new ArrayList<>();

        items.add(new ListItem(R.drawable.radio, "할머니의 일기"));
        items.add(new ListItem(R.drawable.radio, "그 여자를 따라갔다"));
        items.add(new ListItem(R.drawable.radio, "발자국 소리"));
        items.add(new ListItem(R.drawable.radio, "귀신과 대화하는 방법"));
        items.add(new ListItem(R.drawable.radio, "아는 누나"));
        items.add(new ListItem(R.drawable.radio, "임상병리사"));
        items.add(new ListItem(R.drawable.radio, "생명의 은인"));
        items.add(new ListItem(R.drawable.radio, "소개팅"));
        items.add(new ListItem(R.drawable.radio, "사랑의 결실"));
        items.add(new ListItem(R.drawable.radio, "성인사이트"));

        layoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        Adapter = new ListAdapter(items, mContext);
        recyclerView.setAdapter(Adapter);

        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(mContext, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                        intent.putExtra("position", position);
                        startActivity(intent);
                    }
                })
        );
    }
    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
        private Context context;
        private ArrayList<ListItem> mItems;

        private int lastPosition = -1;

        public ListAdapter(ArrayList<ListItem> items, Context mContext){
            mItems = items;
            context = mContext;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.countsil_item_cardview, parent, false);

            return new ViewHolder(v);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            holder.imageView.setImageResource(mItems.get(position).image);
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
        private void setAnimation(View viewToAnimate, int position)
        {
            if (position > lastPosition)
            {
                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
        }
    }
}
