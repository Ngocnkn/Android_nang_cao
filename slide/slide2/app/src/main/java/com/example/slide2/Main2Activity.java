package com.example.slide2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void sendMessage(View view) {
        Intent intent= new Intent("ABC");
        intent.putExtra("sms","abc");
        sendBroadcast(intent);
    }
}
