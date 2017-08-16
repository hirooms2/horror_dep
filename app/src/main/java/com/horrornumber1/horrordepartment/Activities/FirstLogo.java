package com.horrornumber1.horrordepartment.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.horrornumber1.horrordepartment.DBManager;
import com.horrornumber1.horrordepartment.R;
import com.horrornumber1.horrordepartment.Network.Download;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

//import com.horrornumber1.horrordepartment.Service.Download;

public class FirstLogo extends AppCompatActivity {
    RequestReceiver requestReceiver;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_logo);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                IntentFilter filter = new IntentFilter(RequestReceiver.PROCESS_RESPONSE);
                requestReceiver = new RequestReceiver();
                registerReceiver(requestReceiver, filter);
                Intent conn = new Intent(getApplicationContext(), Download.class);
                startService(conn);
            }
        }, 1000L);
    }

    public class RequestReceiver extends BroadcastReceiver {

        public static final String PROCESS_RESPONSE = "response";
        public static final String SUCEESS = "success";
        public static final String FAIL = "fail";

        @Override
        public void onReceive(Context context, Intent intent) {

            String responseMessage = intent.getStringExtra(Download.RESPONSE_MESSAGE);
            if(responseMessage.equals(SUCEESS)) {
                //************************SQLite************************************************************
                DataHouse.dbManager = new DBManager(getApplicationContext(), "myDB", null, 1);

                Intent main = new Intent(FirstLogo.this, MainActivity.class);
                main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(main);
                finish();
            } else if(responseMessage.equals(FAIL)) {
                DialogSimple();
            }
        }
    }
    @Override
    protected void onDestroy() {
        this.unregisterReceiver(requestReceiver);
        super.onDestroy();
    }
    private void DialogSimple(){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setMessage("네트워크 연결이 불안정합니다").setCancelable(
                false).setPositiveButton("닫기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'Yes' Button
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);;
                    }
                });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }
}
