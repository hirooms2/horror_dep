package com.horrornumber1.horrormagazine.Widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.DataModel.MyData;
import com.horrornumber1.horrormagazine.R;
import com.squareup.picasso.Picasso;

/**
 * Created by 김태호 on 2017-01-13.
 * view 에 들어갈 내용을 구체적으로 설정
 */

public class DrawerItemView extends LinearLayout {

    TextView data;
    ImageView icon;
    Context context;

    public DrawerItemView(Context context, MyData myData)
    {
        super(context);
        this.context=context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.drawer_item, this, true);

        data = (TextView) findViewById(R.id.nav_text1);
        data.setText(myData.getTitle());
        icon = (ImageView) findViewById(R.id.nav_icon);
        Picasso.with(context).load(myData.getIcon()).into(icon);

    }

    public void bind(MyData drawerItem)
    {
        data.setText(drawerItem.getTitle());
        icon.setImageResource(drawerItem.getIcon());
        //Picasso.with(context).load(drawerItem.getIcon()).into(icon);

    }
}
