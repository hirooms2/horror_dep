package com.horrornumber1.horrormagazine.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horrornumber1.horrormagazine.Adapters.CartoonPagerAdapter;
import com.horrornumber1.horrormagazine.R;

/**
 * Created by 김태호 on 2017-01-23.
 */

public class ContentCartoonFragment extends Fragment{
    ViewPager pager;
    int num=1;
    public static ContentCartoonFragment newInstance(int num) {
        ContentCartoonFragment fragment = new ContentCartoonFragment();
        Bundle args = new Bundle();
        args.putInt("key", num);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_cartoon_content, container, false);

        if(getArguments() != null) {
            num=getArguments().getInt("key");
        }
        pager = (ViewPager) rootView.findViewById(R.id.cartoon_pager);

        CartoonPagerAdapter adapter = new CartoonPagerAdapter(inflater, getActivity(), num);

        pager.setAdapter(adapter);

        return rootView;
    }

    //replace 시 이전 fragment가 정리되는지 알아보기 위함 -> replace하면 전에 있던 fragment는 알아서 리소스 정리됨
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment", "onDestroy: " + Integer.toString(num));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment", "onDetach: " + Integer.toString(num));
    }
}
