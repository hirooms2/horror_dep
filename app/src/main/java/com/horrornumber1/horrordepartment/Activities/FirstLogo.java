package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.horrornumber1.horrordepartment.DBManager;
import com.horrornumber1.horrordepartment.R;
//import com.horrornumber1.horrordepartment.Service.Download;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

public class FirstLogo extends AppCompatActivity {
    //RequestReceiver requestReceiver;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_logo);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                DataHouse.dbManager = new DBManager(getApplicationContext(), "myDB", null, 1);

                Intent intent = new Intent(FirstLogo.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }, 2000L);

    }
}
