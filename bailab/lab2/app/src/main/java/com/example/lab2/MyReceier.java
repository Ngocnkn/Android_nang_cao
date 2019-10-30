package com.example.lab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceier extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String input = intent.getStringExtra("td");
        if (input.equals("MEM537128")) {
            Toast.makeText(context, "khuyến mãi 10%", Toast.LENGTH_LONG).show();
        } else if (input.equals("MEM537129")) {
            Toast.makeText(context, "khuyến mãi 20%", Toast.LENGTH_SHORT).show();

        } else if (input.equals("VIP537128")) {
            Toast.makeText(context, "khuyến mãi 30%", Toast.LENGTH_LONG).show();


        } else if (input.equals("VIP537129")) {
            Toast.makeText(context, "khuyến mãi 50%", Toast.LENGTH_LONG).show();


        } else if (input.substring(0, 3).equals("MEM")) {
            Toast.makeText(context, "khuyến mãi 20%", Toast.LENGTH_LONG).show();


        } else if (input.substring(0, 3).equals("VIP")) {
            Toast.makeText(context, "khuyến mãi 10%", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(context, "ko co khuyến mãi", Toast.LENGTH_LONG).show();

        }


    }
}
