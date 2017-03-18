package com.horrornumber1.horrormagazine.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.Widget.CardViewHolder;

import java.util.List;

/**
 * Created by 이승헌 on 2017-01-04.
 */

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    List<Model> list;

    //ajouter un constructeur prenant en entrée une liste
    public CardAdapter(List<Model> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards,viewGroup,false);
        return new CardViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
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
