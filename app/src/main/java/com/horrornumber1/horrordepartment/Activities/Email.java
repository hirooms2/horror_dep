package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.horrornumber1.horrordepartment.R;

public class Email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        Uri uri = Uri.parse("mailto:horrorno2@gmail.com");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(it);
    }
}
