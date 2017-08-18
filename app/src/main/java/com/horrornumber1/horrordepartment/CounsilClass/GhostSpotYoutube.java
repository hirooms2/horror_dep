package com.horrornumber1.horrordepartment.CounsilClass;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.horrornumber1.horrordepartment.Module.ApplicationController;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;

public class GhostSpotYoutube extends AppCompatActivity {
    private Context mContext;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    private  ArrayList<ListItem> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counsil_ghost_spot_youtube);
        mContext = getApplicationContext();


        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("GhostSpot Activity");
        t.send(new HitBuilders.AppViewBuilder().build());

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view2);
        recyclerView.setHasFixedSize(true);

        items = new ArrayList<>();

        items.add(new ListItem(R.drawable.ghostspot, "아오키가하라"));
        items.add(new ListItem(R.drawable.ghostspot, "의정부 폐가"));
        items.add(new ListItem(R.drawable.ghostspot, "홍은동 폐가"));
        items.add(new ListItem(R.drawable.ghostspot, "충일여고"));

        layoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        Adapter = new ListAdapter(items, mContext);
        recyclerView.setAdapter(Adapter);

        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(mContext, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                        intent.putExtra("position", position+10);
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
    public void onBackPressed() {

        AlertDialog.Builder d = new AlertDialog.Builder(this);
        d.setMessage("흉가탐방을 종료하시겠습니까?");
        d.setPositiveButton("예", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // process전체 종료
                finish();
            }
        });
        d.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        d.show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }
    @Override
    protected void onStop(){
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }

}