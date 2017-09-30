package com.horrornumber1.horrordepartment.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.horrornumber1.horrordepartment.Fragments.BoardTextFragment;


public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;
    Bundle bundle;
    BoardTextFragment textFragment;
    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                bundle = new Bundle(1);
                bundle.putString("name", "지역괴담");

                textFragment = new BoardTextFragment();
                textFragment.setArguments(bundle);
                return textFragment;
            case 1:
                bundle = new Bundle(1);
                bundle.putString("name", "군대괴담");
                textFragment = new BoardTextFragment();
                textFragment.setArguments(bundle);
                return textFragment;
            case 2:
                bundle = new Bundle(1);
                bundle.putString("name", "실제이야기");
                textFragment = new BoardTextFragment();
                textFragment.setArguments(bundle);
                return textFragment;
            case 3:
                bundle = new Bundle(1);
                bundle.putString("name", "대학괴담");
                textFragment = new BoardTextFragment();
                textFragment.setArguments(bundle);
                return textFragment;

            case 4:
                bundle = new Bundle(1);
                bundle.putString("name", "로어");
                textFragment = new BoardTextFragment();
                textFragment.setArguments(bundle);
                return textFragment;
            case 5:
                bundle = new Bundle(1);
                bundle.putString("name", "이해하면 무서운 이야기");
                textFragment = new BoardTextFragment();
                textFragment.setArguments(bundle);
                return textFragment;
            case 6:
                bundle = new Bundle(1);
                bundle.putString("name", "도시괴담");
                textFragment = new BoardTextFragment();
                textFragment.setArguments(bundle);
                return textFragment;
            case 7:
                bundle = new Bundle(1);
                bundle.putString("name", "투고괴담");
                textFragment = new BoardTextFragment();
                textFragment.setArguments(bundle);
                return textFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
