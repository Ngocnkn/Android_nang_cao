package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab1.bai1.Bai1Activity;
import com.example.lab1.bai2.Bai2Activity;
import com.example.lab1.bai3.Bai3Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bai1(View view) {
        Intent intent = new Intent(this, Bai1Activity.class);
        startActivity(intent);
    }

    public void bai2(View view) {
        Intent intent = new Intent(this, Bai2Activity.class);
        startActivity(intent);
    }

    public void bai3(View view) {
        Intent intent = new Intent(this, Bai3Activity.class);
        startActivity(intent);
    }

    public void bai4(View view) {
    }
}
