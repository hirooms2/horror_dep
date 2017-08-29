package com.horrornumber1.horrordepartment.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.horrornumber1.horrordepartment.Adapters.ChannelAdapter;
import com.horrornumber1.horrordepartment.R;

public class HorrorGameActivity extends AppCompatActivity {
    private ListView gameList;
    String games_arr[] = {
            "2D게임 미사오",
            "2D게임 아오오님",
            "폐병원 탈출 공포 갑툭튀 Araya",
            "공포의 무한반복 Continuously",
            "갑툭튀 갑오브갑 Monstrum"
    };
    int gameImage_arr[] = {
            R.drawable.misao,
            R.drawable.aooni,
            R.drawable.araya,
            R.drawable.continuously,
            R.drawable.monstrum
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror_game);

        gameList = (ListView) findViewById(R.id.horrorGameListView);
        ChannelAdapter adapter = new ChannelAdapter(getApplication(), R.layout.list_item_template, games_arr, gameImage_arr);
        gameList.setAdapter(adapter);
    }
}
