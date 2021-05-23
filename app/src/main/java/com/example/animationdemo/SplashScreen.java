package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    Button btBall;
    TextView tvTitle;
    float alpha=0.f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        btBall=findViewById(R.id.btBall);
        tvTitle=findViewById(R.id.tvTitle);
        tvTitle.setAlpha(alpha);
        ObjectAnimator animator = ObjectAnimator.ofFloat(btBall, "translationY", 300f);
        animator.setInterpolator(new BounceInterpolator());
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                alpha+=0.25;
                tvTitle.setAlpha(alpha);
            }
        });
        animator.setDuration(4000);
        animator.setRepeatCount(0);
        animator.start();
    }
}