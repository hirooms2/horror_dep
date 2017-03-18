package com.horrornumber1.horrormagazine.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horrornumber1.horrormagazine.Activities.CartoonContent;
import com.horrornumber1.horrormagazine.Adapters.CardAdapter;
import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.RecyclerItemClickListener;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 김태호 on 2017-01-18.
 */

public class BoardCartoonFragment extends Fragment{

    private List<Model> cartoons = new ArrayList<>();
    RecyclerView cartoonRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.board_fragment_cartoon, container, false);


        cartoonRecycler = (RecyclerView) rootView.findViewById(R.id.fourCutRecyclerView);

        cartoons = DataHouse.cartoon2;

        cartoonRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        cartoonRecycler.setAdapter(new CardAdapter(cartoons));

        cartoonRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), cartoonRecycler, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intentItem = new Intent(getContext(), CartoonContent.class);
                        int input = position;
                        intentItem.putExtra(CartoonContent.PARAM_INPUT_MESSAGE, input);
                        startActivity(intentItem);
                    }
                })
        );

        return rootView;
    }
}
