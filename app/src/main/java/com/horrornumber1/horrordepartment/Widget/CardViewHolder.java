package com.horrornumber1.horrordepartment.Widget;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.R;
import com.squareup.picasso.Picasso;



public class CardViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewView;
    private ImageView imageView;

    //itemView est la vue correspondante à 1 cellule
    public CardViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(final Model myObject) {
        textViewView.setText(myObject.getTitle());
        Picasso.Builder builder = new Picasso.Builder(imageView.getContext());
        builder.listener(new Picasso.Listener()
        {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
            {
                Toast.makeText(imageView.getContext(), "e", Toast.LENGTH_LONG).show();            }
        });
        //builder.build().load(myObject.getIcon()).centerCrop().fit().into(imageView);
        //Picasso.with(imageView.getContext()).load(myObject.getIcon()).centerCrop().fit().into(imageView);
    }
}
