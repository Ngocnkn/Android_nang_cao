package com.example.lab7.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.lab7.R;

public class Bai1Activity extends AppCompatActivity {
    ImageView all;
    Animation hh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        all =findViewById(R.id.all);
    }

    public void Rotation(View view) {
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(500);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatMode(Animation.RELATIVE_TO_SELF);
        rotate.setRepeatCount(0);
        all.startAnimation(rotate);
    }


    public void Moving(View view) {
//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(all,
//                "translationY",
//                0, -all.getWidth());
//        objectAnimator1.setDuration(6000);
//        objectAnimator1.setRepeatCount(100);
//        objectAnimator1.setRepeatMode(ValueAnimator.RESTART);
//        objectAnimator1.start();

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(all,
                "translationX",
                -all.getWidth(), 0);
        objectAnimator2.setDuration(6000);
        objectAnimator2.setRepeatCount(0);
        objectAnimator2.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator2.start();
    }

    public void Zoom(View view) {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.zoom);
        all.startAnimation(animation);
    }
}
