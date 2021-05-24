package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewAnimation extends AppCompatActivity {

    ImageView Object;
    Animation animFadein, animBlink, animFadeOut, animMove,
            animRotate, animSlideUp, animSlideDown,
            animSequential, animTogether, animZoomIn, animZoomOut;
    Button fadeIn, fadeOut, blink, move, rotate, slideUp, slideDown, sequential, together, zoomIn, zoomOut;
    Button btReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        Object = findViewById(R.id.Object);

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        animMove = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        animSequential = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.squential);
        animTogether = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);


        Object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Object was clicked !!", Toast.LENGTH_SHORT).show();
            }
        });

        fadeIn = findViewById(R.id.btFade_in);
        fadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animFadein);
            }
        });

        fadeOut = findViewById(R.id.btFade_out);
        fadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animFadeOut);
            }
        });

        blink = findViewById(R.id.btBlink);
        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animBlink);
            }
        });

        move = findViewById(R.id.btMove);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animMove);
            }
        });

        rotate = findViewById(R.id.btRotate);
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animRotate);
            }
        });

        slideUp = findViewById(R.id.btSlide_up);
        slideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animSlideUp);
            }
        });

        slideDown = findViewById(R.id.btSlide_down);
        slideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animSlideDown);
            }
        });

        sequential = findViewById(R.id.btSequential);
        sequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animSequential);
            }
        });

        together = findViewById(R.id.btTogether);
        together.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animTogether);
            }
        });

        zoomIn = findViewById(R.id.btZoom_in);
        zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animZoomIn);
            }
        });

        zoomOut = findViewById(R.id.btZoom_out);
        zoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(animZoomOut);
            }
        });

        Animation reset =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.reset);
        btReset = findViewById(R.id.btReset);
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object.startAnimation(reset);
            }
        });

    }
}