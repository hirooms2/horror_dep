package com.horrornumber1.horrordepartment.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.horrornumber1.horrordepartment.R;

import uk.co.senab.photoview.PhotoViewAttacher;



public class CustomPagerAdapter extends PagerAdapter {
    int[] mResources = {
            R.drawable.magazine1,
            R.drawable.magazine2,
            R.drawable.magazine3,
            R.drawable.magazine4,
            R.drawable.magazine5,
            R.drawable.magazine6,
            R.drawable.magazine7,
            R.drawable.magazine8,
            R.drawable.magazine9,
            R.drawable.magazine10,
            R.drawable.magazine11,
            R.drawable.magazine12,
            R.drawable.magazine13,
            R.drawable.magazine14,
            R.drawable.magazine15,
            R.drawable.magazine16,
            R.drawable.magazine17,
            R.drawable.magazine18,
            R.drawable.magazine19,
            R.drawable.magazine20,
            R.drawable.magazine21,
            R.drawable.magazine22,
            R.drawable.magazine23,
            R.drawable.magazine24,
            R.drawable.magazine25,
            R.drawable.magazine26,
            R.drawable.magazine27,
            R.drawable.magazine28
    };
    Context mContext;
    LayoutInflater mLayoutInflater;

    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        PhotoViewAttacher attacher;
        ImageView imageView = (ImageView) itemView.findViewById(R.id.magazine_img);
        imageView.setImageResource(mResources[position]);
        attacher = new PhotoViewAttacher(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}

