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

public class HorrorGameListActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_horror_game_list);

        mContext = getApplicationContext();

        from = getIntent();

        whichContent = from.getIntExtra("whichContent", -1);

        recyclerView = (RecyclerView)findViewById(R.id.game_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        items = new ArrayList<>();

        switch (whichContent){
            case 0:
                items.add(new ListItem(R.drawable.aooni, "제1화 아오오니 #1"));
                items.add(new ListItem(R.drawable.aooni, "제2화 아오오니 #2"));
                items.add(new ListItem(R.drawable.aooni, "제3화 아오오니 #3"));
                items.add(new ListItem(R.drawable.aooni, "제4화 아오오니 #4"));
                items.add(new ListItem(R.drawable.aooni, "제5화 아오오니 #5"));
                items.add(new ListItem(R.drawable.aooni, "제6화 아오오니 #최종화"));
                break;
            case 1:
                items.add(new ListItem(R.drawable.araya, "제1화 Araya #1"));
                items.add(new ListItem(R.drawable.araya, "제2화 Araya #2"));
                items.add(new ListItem(R.drawable.araya, "제3화 Araya #3"));
                items.add(new ListItem(R.drawable.araya, "제4화 Araya #4"));
                items.add(new ListItem(R.drawable.araya, "제5화 Araya #5"));
                items.add(new ListItem(R.drawable.araya, "제6화 Araya #최종화"));
                break;
            case 2:
                items.add(new ListItem(R.drawable.continuously, "Continuously #Full"));
                break;
            case 3:
                items.add(new ListItem(R.drawable.misao, "제1화 미사오 #1"));
                items.add(new ListItem(R.drawable.misao, "제2화 미사오 #2"));
                items.add(new ListItem(R.drawable.misao, "제3화 미사오 #3"));
                items.add(new ListItem(R.drawable.misao, "제4화 미사오 #최종화"));

                break;
            case 4:
                items.add(new ListItem(R.drawable.monstrum, "제1화 몬스트럼 #1"));
                items.add(new ListItem(R.drawable.monstrum, "제2화 몬스트럼 #2"));
                items.add(new ListItem(R.drawable.monstrum, "제3화 몬스트럼 #3"));

                break;
            case 5:
                items.add(new ListItem(R.drawable.red_mask, "빨간마스크 #Full"));
                break;
            case 6:
                items.add(new ListItem(R.drawable.home_sweet_home, "Home Sweet Home #Full"));
                break;
            case 7:
                items.add(new ListItem(R.drawable.outlast, "공포 띵작 \"아웃라스트1\" #1화 "));
                items.add(new ListItem(R.drawable.outlast, "공포 띵작 \"아웃라스트1\" #2화 "));
                items.add(new ListItem(R.drawable.outlast, "공포 띵작 \"아웃라스트1\" #3화 "));
                break;
            case 8:
                items.add(new ListItem(R.drawable.shadow_corridor, "일본에서 작정하고 만든 공포게임 #1화"));
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
                        intent.putExtra("fromWhere", 0);
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
