package com.example.assigment;

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

    public void btnCourse(View view) {
        Intent intent=new Intent(MainActivity.this,CoursesActivity.class);
        startActivity(intent);
    }

    public void btnMap(View view) {
        Intent intent=new Intent(MainActivity.this,MapsActivity.class);
        startActivity(intent);
    }

    public void btnNews(View view) {
        Intent intent=new Intent(MainActivity.this,TinTucActivity.class);
        startActivity(intent);
    }

    public void btnSocial(View view) {
        Intent intent=new Intent(MainActivity.this,Bai3Activity.class);
        startActivity(intent);
    }
}
