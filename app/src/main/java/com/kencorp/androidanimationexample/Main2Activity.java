package com.kencorp.androidanimationexample;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    AnimationDrawable batteryAnimation = new AnimationDrawable();
    private ImageView targetImage;
    private FloatingActionButton fab;
    private boolean isChecked ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        isChecked = true;

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChecked) {
                    checkToClose();
                    isChecked = false;
                } else {
                    closeToChech();
                    isChecked = true;
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        targetImage = findViewById(R.id.targetImage);

    }

    private void closeToChech() {
        fab.setImageResource(R.drawable.avd_close_check);
        AnimatedVectorDrawable animationDrawable =(AnimatedVectorDrawable) fab.getDrawable();
        animationDrawable.start();

    }


    private void checkToClose() {
       fab.setImageResource(R.drawable.avd_anim);
       AnimatedVectorDrawable animationDrawable =(AnimatedVectorDrawable) fab.getDrawable();
       animationDrawable.start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        targetImage.setImageResource(R.drawable.battery_animation_list);

        batteryAnimation = (AnimationDrawable) targetImage.getDrawable()  ;
        batteryAnimation.start();

    }

    public void startStopAnimation(View view){


    }

}
