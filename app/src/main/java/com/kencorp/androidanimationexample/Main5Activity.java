package com.kencorp.androidanimationexample;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class Main5Activity extends AppCompatActivity {


    private  Scene scene1;
    private  Scene scene2;
    private  Scene currentScene;
    private  Transition transition;
    private  ViewGroup sceneRoot;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        // Step 1: Create a Scene object for both the starting and ending layout
        sceneRoot =(ViewGroup)findViewById(R.id.sceneRoot);

        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this);

        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.scene2, this);


        // Step 2: Create a Transition object to define what type of animation you want

        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_1);

        scene1.enter();
        currentScene = scene1;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick(View view) {

        // Step 3: Call TransitionManager.go() to run animation

        if(currentScene == scene1){
            TransitionManager.go(scene2,transition);
            currentScene=scene2;
        }else{
            TransitionManager.go(scene1,transition);
            currentScene=scene1;

        }
    }
}
