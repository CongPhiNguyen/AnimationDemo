package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btViewAnimation, btPropertyAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btViewAnimation=findViewById(R.id.btViewAnimation);
        btViewAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ViewAnimation.class);
                startActivity(intent);
            }
        });
        btPropertyAnimation=findViewById(R.id.btPropertyAnimation);
        btPropertyAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PropertyAnimation.class);
                startActivity(intent);
            }
        });
    }
}