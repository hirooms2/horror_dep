package com.horrornumber1.horrordepartment.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.horrornumber1.horrordepartment.Fragments.ContentTextFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    String name;
    int size;
    public ViewPagerAdapter(FragmentManager fm, String name, int size) {
        super(fm);
        this.name=name;
        this.size=size;
    }
    @Override
    public Fragment getItem(int position) {
        ContentTextFragment contentTextFragment = new ContentTextFragment().newInstance(name, position);
        return contentTextFragment;
    }
    @Override
    public int getCount() {
        return size;
    }
}
