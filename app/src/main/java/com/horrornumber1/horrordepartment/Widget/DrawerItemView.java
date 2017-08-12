package com.horrornumber1.horrordepartment.Widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.horrornumber1.horrordepartment.DataModel.MyData;
import com.horrornumber1.horrordepartment.R;
import com.squareup.picasso.Picasso;


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
