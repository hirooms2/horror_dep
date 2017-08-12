package com.horrornumber1.horrordepartment.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.Widget.CardViewHolder;

import java.util.List;



public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    List<Model> list;

    public CardAdapter(List<Model> list) {
        this.list = list;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards,viewGroup,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder myViewHolder, final int position) {
        Model myObject = list.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
