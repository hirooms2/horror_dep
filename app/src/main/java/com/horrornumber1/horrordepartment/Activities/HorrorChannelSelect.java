package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.horrornumber1.horrordepartment.Adapters.ChannelAdapter;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;

public class HorrorChannelSelect extends AppCompatActivity {

    private ListView list;
    private ArrayList<String> string_arr = new ArrayList<>();
    private ArrayList<Integer> image_arr = new ArrayList<>();
    private int whichBtn=-1;
    private ChannelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror_channel_select);

        Intent i = getIntent();
        whichBtn = i.getIntExtra("whichBtn", -1);
        list = (ListView) findViewById(R.id.horrorListView);

        switch (whichBtn){
            case 0:
                string_arr = i.getStringArrayListExtra("horrorgameString");
                image_arr = i.getIntegerArrayListExtra("horrorgameImg");
                adapter = new ChannelAdapter(getApplication(), R.layout.list_item_template, string_arr, image_arr);
                list.setAdapter(adapter);

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(HorrorChannelSelect.this, HorrorGameListActivity.class);

                        switch (position){
                            case 0:
                                i.putExtra("whichContent", 0);
                                break;
                            case 1:
                                i.putExtra("whichContent", 1);
                                break;
                            case 2:
                                i.putExtra("whichContent", 2);
                                break;
                            case 3:
                                i.putExtra("whichContent", 3);
                                break;
                            case 4:
                                i.putExtra("whichContent", 4);
                                break;
                            case 5:
                                i.putExtra("whichContent", 5);
                                break;
                            case 6:
                                i.putExtra("whichContent", 6);
                                break;
                            case 7:
                                i.putExtra("whichContent", 7);
                                break;
                            case 8:
                                i.putExtra("whichContent", 8);
                                break;
                            default:return;
                        }
                        startActivity(i);
                    }
                });

                break;
            case 1:
                string_arr = i.getStringArrayListExtra("horrorradioString");
                image_arr = i.getIntegerArrayListExtra("horrorradioImg");
                adapter = new ChannelAdapter(getApplication(), R.layout.list_item_template, string_arr, image_arr);
                list.setAdapter(adapter);

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(HorrorChannelSelect.this, HorrorListActivity.class);

                        switch (position){
                            case 0:
                                i.putExtra("whichContent", 0);
                                break;
                            case 1:
                                i.putExtra("whichContent", 1);
                                break;
                            case 2:
                                i.putExtra("whichContent", 2);
                                break;
                            case 3:
                                i.putExtra("whichContent", 3);
                                break;
                            case 4:
                                i.putExtra("whichContent", 4);
                                break;
                            case 5:
                                i.putExtra("whichContent", 5);
                                break;
                            case 6:
                                i.putExtra("whichContent", 6);
                                break;

                            default:return;
                        }
                        startActivity(i);
                    }
                });

                break;
            case 2:
                string_arr = i.getStringArrayListExtra("horrorspotString");
                image_arr = i.getIntegerArrayListExtra("horrorspotImg");
                adapter = new ChannelAdapter(getApplication(), R.layout.list_item_template, string_arr, image_arr);
                list.setAdapter(adapter);

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(HorrorChannelSelect.this, HorrorSpotListActivity.class);

                        switch (position){
                            case 0:
                                i.putExtra("whichContent", 0);
                                break;
                            case 1:
                                i.putExtra("whichContent", 1);
                                break;
                            case 2:
                                i.putExtra("whichContent", 2);
                                break;
                            case 3:
                                i.putExtra("whichContent", 3);
                                break;

                            default:return;
                        }
                        startActivity(i);
                    }
                });

                break;

            default: return;
        }
    }
}