package com.kencorp.androidanimationexample;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

public class Main5Activity extends AppCompatActivity {


    private  Scene scene1;
    private  Scene scene2;
    private  Scene currentScene;
    private  Transition transition;
    private  ViewGroup sceneRoot;
    private TransitionSet transitionSet;


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

       // transition = TransitionInflater.from(this).inflateTransition(R.transition.example_2);

        ChangeBounds cbTransition = new ChangeBounds();
        cbTransition.setDuration( 500);
        cbTransition.setInterpolator(new LinearInterpolator());

        Fade fadeInTransition = new Fade(Fade.IN);
        fadeInTransition.setDuration(250);
        fadeInTransition.setStartDelay(400);
        fadeInTransition.addTarget(R.id.txvTitle);

        Fade fadeOutTransition = new Fade(Fade.OUT);
        fadeOutTransition.setDuration(50);
        fadeOutTransition.addTarget(R.id.txvTitle);

        transitionSet = new TransitionSet();
        transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);

        transitionSet.addTransition(cbTransition);
        transitionSet.addTransition(fadeInTransition);
        transitionSet.addTransition(fadeOutTransition);



        scene1.enter();
        currentScene = scene1;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick(View view) {

        // Step 3: Call TransitionManager.go() to run animation

        if(currentScene == scene1){
        //    TransitionManager.go(scene2,transition);
            TransitionManager.go(scene2,transitionSet);

            currentScene=scene2;
        }else{
            //TransitionManager.go(scene1,transition);
            TransitionManager.go(scene1,transitionSet);
            currentScene=scene1;

        }
    }
}
