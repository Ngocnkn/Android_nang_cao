package com.example.slide7;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= findViewById(R.id.image);
    }

    public void propertyAnimation(View view) {
        ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(imageView,
                "translationX",-imageView.getWidth(),0f);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(5);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.start();
    }

    public void ViewAnimation(View view) {
        Intent  intent = new Intent(this,SubActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

    }

    public void DrawableAnimation(View view) {
        imageView.setImageResource(R.drawable.abccc);
        AnimationDrawable animationDrawable= (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();

    }
}
