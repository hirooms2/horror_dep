package com.horrornumber1.horrordepartment.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.horrornumber1.horrordepartment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by 이승헌 on 2017-08-29.
 */

public class ChannelAdapter extends ArrayAdapter<String> {
    private Context context;
    ImageView gameImage;
    TextView gameDescription;
    int lastPosition = -1;

    ArrayList<String> descriptions_arr = new ArrayList<>();

    ArrayList<String> images_arr = new ArrayList<>();

    public ChannelAdapter(Context context, int resource, ArrayList<String> descriptions_arr, ArrayList<String> images_arr) {
        super(context, resource, descriptions_arr);
        this.context = context;
        this.descriptions_arr = descriptions_arr;
        this.images_arr = images_arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item_template,parent,false);

        gameImage = (ImageView) row.findViewById(R.id.game_image);

        Picasso.with(context).load(images_arr.get(position)).into(gameImage);

        gameDescription = (TextView) row.findViewById(R.id.txt_game_name);
        gameDescription.setText(descriptions_arr.get(position));

        Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        row.startAnimation(animation);
        lastPosition = position;

        return row;
    }

}
