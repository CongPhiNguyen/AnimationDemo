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
import android.widget.ImageButton;
import android.widget.TextView;

public class SceneAnimation extends AppCompatActivity {

    Scene scene1, scene_earth, scene_mars, scene_jupiter, scene_mercury;
    ImageButton btEarth, btMars, btJupiter, btMercury;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_animation);

        ViewGroup rootScene=findViewById(R.id.sceneRoot);
        scene1=Scene.getSceneForLayout(rootScene,R.layout.scene1, this);
        scene_earth=Scene.getSceneForLayout(rootScene,R.layout.scene_earth, this);
        scene_mars=Scene.getSceneForLayout(rootScene,R.layout.scene_mars, this);
        scene_jupiter=Scene.getSceneForLayout(rootScene,R.layout.scene_jupiter, this);
        scene_mercury=Scene.getSceneForLayout(rootScene,R.layout.scene_mercury, this);
        scene1.enter();
    }

    public void Back(View view) {
        Transition fade=new Fade();
        TransitionManager.go(scene1, fade);
    }
    public void EarthOnClick(View view) {
        Transition explode=new Explode();
        TransitionManager.go(scene_earth, explode);
    }
    public void MarsOnClick(View view) {
        Transition explode=new Explode();
        TransitionManager.go(scene_mars, explode);
    }
    public void MercuryOnClick(View view){
        Transition explode=new Explode();
        TransitionManager.go(scene_mercury, explode);
    }
    public void JupiterOnClick(View view){
        Transition explode=new Explode();
        TransitionManager.go(scene_jupiter, explode);
    }
}