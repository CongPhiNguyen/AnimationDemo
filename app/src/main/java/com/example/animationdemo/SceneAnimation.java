package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SceneAnimation extends AppCompatActivity {

    Scene scene1, scene2, scene3;
    Button btStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_animation);

        ViewGroup rootScene=findViewById(R.id.sceneRoot);
        scene1=Scene.getSceneForLayout(rootScene,R.layout.scene1, this);
        scene2=Scene.getSceneForLayout(rootScene,R.layout.scene2, this);
        scene3=Scene.getSceneForLayout(rootScene,R.layout.scene3, this);
        scene1.enter();
    }
    public void onClick1(View view)
    {
        Transition Fade=new Fade();
        TransitionManager.go(scene2, Fade);
    }
    public void onClick2(View view)
    {
        Transition Explode= new Explode();
        TransitionManager.go(scene3, Explode);
    }
    public void onClick3(View view)
    {
        TransitionManager.go(scene1);
    }
}