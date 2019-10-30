package com.example.lab7.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lab7.R;

public class Bai2Activity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        img = findViewById(R.id.allbai2);
    }

    public void Nobita(View view) {
    }

    public void Doraemon(View view) {
    }

    public void All(View view) {
    }

    private void show(String img) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(img," translationX ",0f, 500f);
        anim.setDuration(2000);
    }
}
