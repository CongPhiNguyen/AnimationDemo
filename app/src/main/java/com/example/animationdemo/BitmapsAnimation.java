package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BitmapsAnimation extends AppCompatActivity {
    AnimationDrawable bonkAnimation;
    Button btStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmaps_animation);

        ImageView bonkImage=findViewById(R.id.imageView);
        bonkImage.setBackgroundResource(R.drawable.bonk);

        bonkAnimation=(AnimationDrawable) bonkImage.getBackground();

        btStart=findViewById(R.id.btStartAnimation);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bonkAnimation.start();
                //Dùng để reset animation
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bonkImage.setBackgroundResource(R.drawable.giphy0);
                        bonkImage.setBackgroundResource(R.drawable.bonk);
                        bonkAnimation=(AnimationDrawable) bonkImage.getBackground();
                    }
                }, 1000);
            }
        });

    }
}