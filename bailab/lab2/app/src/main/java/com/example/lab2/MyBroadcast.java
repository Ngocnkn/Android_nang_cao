package com.example.android_lab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentMessage = intent.getStringExtra("sms");
        Toast.makeText(context,intentMessage,Toast.LENGTH_LONG).show();
    }
}
