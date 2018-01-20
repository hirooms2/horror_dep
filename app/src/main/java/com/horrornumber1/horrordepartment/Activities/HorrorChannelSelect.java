package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.horrornumber1.horrordepartment.Adapters.ChannelAdapter;
import com.horrornumber1.horrordepartment.DataModel.Youtube_con;
import com.horrornumber1.horrordepartment.Module.Youtube_Util;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.ArrayList;
import java.util.List;


public class HorrorChannelSelect extends AppCompatActivity {

    private ListView list;
    private ArrayList<String> string_arr = new ArrayList<>();
    private ArrayList<String> image_arr = new ArrayList<>();
    private List<Youtube_con> con_list = new ArrayList<>();
    private int whichBtn=-1;
    private ChannelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror_channel_select);

        Intent i = getIntent();
        whichBtn = i.getIntExtra("whichBtn", -1);
        list = (ListView) findViewById(R.id.horrorListView);

        Youtube_Util youtube_util = new Youtube_Util();
        con_list = youtube_util.searchTab1_All(whichBtn);

        for(int k=0; k<con_list.size(); k++){
            image_arr.add(youtube_util.whichImg(whichBtn,k));
            string_arr.add(con_list.get(k).getName());
        }
                adapter = new ChannelAdapter(getApplication(), R.layout.list_item_template, string_arr, image_arr);
                list.setAdapter(adapter);

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(HorrorChannelSelect.this, BroadcastActivity.class);

                                i.putExtra("whichBtn",whichBtn);
                                i.putExtra("whichContent", position);

                        startActivity(i);
                    }
                });

        }

}