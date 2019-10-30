package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBai1(View view) {
        startActivity(new Intent(this,Bai1Activity.class));
    }

    public void openBai2(View view) {
        startActivity(new Intent(this,Bai2Activity.class));
    }

    public void openBai3(View view) {
        startActivity(new Intent(this,Bai3Activity.class));
    }
}
