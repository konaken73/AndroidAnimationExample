package com.kencorp.androidanimationexample;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class Main6Activity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private boolean isDetailLayout=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        constraintLayout = findViewById(R.id.constraintLayout);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                if (isDetailLayout) {
                    // switch to default layout
                    swapFrames(R.layout.activity_main6);
                }else{
                // switch to detail layout

                    swapFrames(R.layout.activity_main_detail);
            }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void swapFrames(int layoutId){

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this,layoutId);

        TransitionManager.beginDelayedTransition(constraintLayout);

        constraintSet.applyTo(constraintLayout);

        isDetailLayout = true;
    }
}
