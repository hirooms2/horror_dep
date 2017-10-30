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
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;

public class HorrorSpotListActivity extends AppCompatActivity {
    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<ListItem> items;

    int whichContent=-1;
    Intent from;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror_spot_list);
        mContext = getApplicationContext();

        from = getIntent();

        whichContent = from.getIntExtra("whichContent", -1);

        recyclerView = (RecyclerView)findViewById(R.id.spot_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        items = new ArrayList<>();

        switch (whichContent){
            case 0:
                items.add(new ListItem(R.drawable.jookai, "자살숲 아오키가하라 #Full"));
                break;
            case 1:
                items.add(new ListItem(R.drawable.euijungboo, "의정부 폐건물 탐방 #Full"));
                break;
            case 2:
                items.add(new ListItem(R.drawable.choongil, "대전 충일여고 폐교 탐방 #Full"));
                break;
            case 3:
                items.add(new ListItem(R.drawable.hongeundong, "서울 홍은동 폐가 탐방 #Full"));
                break;
            case 4:
                items.add(new ListItem(R.drawable.cheonanghost, "천안 모 폐교 4인 스쿼드 #Full"));
                break;

            default:return;
        }
        Adapter = new ListAdapter(items, mContext);
        recyclerView.setAdapter(Adapter);

        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(mContext, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                        intent.putExtra("whichContent", whichContent);
                        intent.putExtra("position", position);
                        intent.putExtra("fromWhere", 2);
                        startActivity(intent);
                    }
                })
        );
    }
    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        private Context context;
        private ArrayList<ListItem> mItems;
        private int lastPosition = -1;

        public ListAdapter(ArrayList<ListItem> items, Context mContext) {
            mItems = items;
            context = mContext;
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.countsil_item_cardview, parent, false);
            return new ListAdapter.ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position) {
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

        private void setAnimation(View viewToAnimate, int position) {
            if (position > lastPosition) {
                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
        }
    }
}