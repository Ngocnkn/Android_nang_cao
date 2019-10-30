package com.example.android_lab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceier extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
  String input = intent.getStringExtra("td");
    if (input.equals("MEM537128")){

        Toast.makeText(context,"khuyenmai10%",Toast.LENGTH_LONG).show();
    }
    else if (input.equals("MEM537129")){
        Toast.makeText(context,"khuyenmai20%",Toast.LENGTH_SHORT).show();


    }
    else if (input.equals("VIP537128")){
        Toast.makeText(context,"khuyenmai30%",Toast.LENGTH_LONG).show();


    }
    else if (input.equals("VIP537129")){
        Toast.makeText(context,"khuyenmai50%",Toast.LENGTH_LONG).show();


    }
    else if (input.substring(0,3).equals("MEM")){
        Toast.makeText(context,"khuyenmai20%",Toast.LENGTH_LONG).show();


    }
    else if (input.substring(0,3).equals("VIP")){
        Toast.makeText(context,"khuyenmai10%",Toast.LENGTH_LONG).show();


    }
    else {
        Toast.makeText(context,"ko co khuyenmai",Toast.LENGTH_LONG).show();

    }


    }
}
