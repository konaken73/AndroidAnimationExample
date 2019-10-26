package com.kencorp.androidanimationexample;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animator.AnimatorListener {

    private ImageView targetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           /*     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
           */
             startActivity(new Intent(MainActivity.this,Main2Activity.class));

            }
        });

        targetImage = findViewById(R.id.targetImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
      //  getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_activity_1) {
            // Check if we're running on Android 5.0 or higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                // Apply activity transition
                // inside your activity (if you did not enable transitions in your theme)

                startActivity(new Intent(this, Main2Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                // set an exit transition
                //        getWindow().setExitTransition(new Explode());

            }
        }else  if (id == R.id.action_activity_2) {
            // Check if we're running on Android 5.0 or higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                // Apply activity transition
                // inside your activity (if you did not enable transitions in your theme)

                startActivity(new Intent(this, Main3Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                // set an exit transition
                //        getWindow().setExitTransition(new Explode());

            }
            return true;
        }else  if (id == R.id.action_activity_3) {
            // Check if we're running on Android 5.0 or higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                // Apply activity transition
                // inside your activity (if you did not enable transitions in your theme)

                startActivity(new Intent(this, Main4Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                // set an exit transition
                //        getWindow().setExitTransition(new Explode());

            }
            return true;
        }else if (id == R.id.action_activity_4) {
            // Check if we're running on Android 5.0 or higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                // Apply activity transition
                // inside your activity (if you did not enable transitions in your theme)

                startActivity(new Intent(this, Main5Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                // set an exit transition
                //        getWindow().setExitTransition(new Explode());

            }
            return true;
        }else if (id == R.id.action_activity_5) {
            // Check if we're running on Android 5.0 or higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                // Apply activity transition
                // inside your activity (if you did not enable transitions in your theme)

                startActivity(new Intent(this, Main6Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                // set an exit transition
                //        getWindow().setExitTransition(new Explode());

            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    public void fadeAnimation(View view) {

        Animator fadeAnimator = AnimatorInflater.loadAnimator(this,R.animator.alpha);
        fadeAnimator.setTarget(targetImage);
        fadeAnimator.addListener(MainActivity.this);
        fadeAnimator.start();
    }


    public void rotateAnimation(View view) {

        Animator rotateAnimator = AnimatorInflater.loadAnimator(this,R.animator.rotate);
        rotateAnimator.setTarget(targetImage);
        rotateAnimator.addListener(MainActivity.this);
        rotateAnimator.start();
    }


    public void translateAnimation(View view) {

        Animator translateAnimator = AnimatorInflater.loadAnimator(this,R.animator.translate);
        translateAnimator.setTarget(targetImage);
        translateAnimator.addListener(MainActivity.this);
        translateAnimator.start();


/*   // from code
        ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(targetImage,"translationX",1.0f,0.0f);

        translateAnimator.setDuration(1000);
        translateAnimator.setRepeatCount(1);
        translateAnimator.setRepeatMode(ValueAnimator.REVERSE);
        translateAnimator.addListener(MainActivity.this);
        translateAnimator.start();*/


    }


    public void scaleAnimation(View view) {

        Animator scaleAnimator = AnimatorInflater.loadAnimator(this,R.animator.scale);
        scaleAnimator.setTarget(targetImage);
        scaleAnimator.addListener(MainActivity.this);
        scaleAnimator.start();
    }

    @Override
    public void onAnimationStart(Animator animation, boolean isReverse) {

    }

    @Override
    public void onAnimationEnd(Animator animation, boolean isReverse) {

    }

    @Override
    public void onAnimationStart(Animator animation) {

        Toast.makeText(this,"Animation Started",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAnimationEnd(Animator animation) {

        Toast.makeText(this,"Animation End",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAnimationCancel(Animator animation) {
        Toast.makeText(this,"Animation Cancelled",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        Toast.makeText(this,"Animation Repeated",Toast.LENGTH_LONG).show();

    }


    public void setFromXml(View view){

        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.set);
        animator.setTarget(targetImage);
        animator.start();

    }

    public void setFromCode(View view)
    {
       // Root Animator Set

        AnimatorSet rootSet = new AnimatorSet();

        // Flip Animation
        ObjectAnimator flip = ObjectAnimator.ofFloat(targetImage,"rotationX",0.0f,360.0f);

        flip.setDuration(500);

        //Child Animator Set

        AnimatorSet childSet = new AnimatorSet();

        //Scale Animations

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(targetImage,"scaleX",1.0f,1.5f);
        scaleX.setDuration(500);
        scaleX.setInterpolator(new BounceInterpolator());

        ObjectAnimator scaleY = ObjectAnimator.ofFloat(targetImage,"scaleY",1.0f,1.5f);
        scaleY.setDuration(500);

        scaleY.setInterpolator(new BounceInterpolator());


       // rootSet.playSequentially(flip,childSet);
       // childSet.playTogether(scaleX,scaleY);

        rootSet.play(flip).before(childSet);
        childSet.play(scaleX).with(scaleY);

        rootSet.start();
    }

    public void viewPropertyAnimator(View view)
    {
       ViewPropertyAnimator vpa = targetImage.animate();

       vpa.setDuration(1000)
               .rotationX(360.0f)
               .scaleX(1.5f)
               .scaleY(1.5f)
               .translationX(200.0f)
               .alpha(0.5f)
               .setInterpolator(new OvershootInterpolator())
               .start();


    }

    public void propertyValuesHolder(View view){

         PropertyValuesHolder rotX = PropertyValuesHolder.ofFloat("rotationX",360.0f);
        PropertyValuesHolder scalX = PropertyValuesHolder.ofFloat("scaleX",1.5f);
        PropertyValuesHolder scalY = PropertyValuesHolder.ofFloat("scaleY",1.5f);

        ObjectAnimator objA = ObjectAnimator.ofPropertyValuesHolder(targetImage,rotX,scalX,scalY);

        objA.setDuration(1000)
                .setInterpolator(new OvershootInterpolator());

        objA.start();

    }
}
