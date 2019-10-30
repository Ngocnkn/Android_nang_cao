package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bai3(View view) {
        Intent intent =new Intent(MainActivity.this,Bai3.class);
        startActivity(intent);
    }

    public void bai2(View view) {
        Intent intent =new Intent(MainActivity.this,Bai2.class);
        startActivity(intent);
    }
}
