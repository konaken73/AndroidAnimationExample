package com.kencorp.androidanimationexample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kencorp.androidanimationexample.shared_transition_element.recycler_view.recycler_view_to_activity.AnimalDetailActivity;

public class Main3Activity extends AppCompatActivity implements IStockActivity{

   private Scene scene1;
   private Scene scene2;
   private Scene currentScene;
   private Transition transition;

   private ViewGroup sceneRoot;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        sceneRoot = (ViewGroup)findViewById(R.id.main_content_frame);




        //Step 1: Create a Scene object for both the starting and the ending

        scene1 = Scene.getSceneForLayout(sceneRoot,R.layout.fragment_passive_stock,this);

        scene1 = Scene.getSceneForLayout(sceneRoot,R.layout.activity_detail_equipment,this);

        //Step 2 : Create a transition object to define what type of animation you want

        scene1.enter();

        currentScene = scene1;

        inflatePassiveStock();

    }


    @Override
    public void inflatePassiveStock() {

        PassiveStockFragment passiveStockFragment = new PassiveStockFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame, passiveStockFragment, "stock");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        transaction.addToBackStack("stock");
        transaction.commit();
    }

    @Override
    public void inflateViewDetailEquipement(Equipment equipment, ImageView imageView) {

        //image_detail.setBackground(equipment.ImageEquipment);

        Intent intent = new Intent(this, DetailEquipmentActivity.class);
       // intent.putExtra(PreferenceKeys.INTENT_PARENT_NAME,TAG);
        intent.putExtra(PreferenceKeys.INTENT_DETAILS_EQUIPMENT,equipment);

       // intent.putExtra(PreferenceKeys.INTENT_DETAILS_PARAMS,equipment.getId());

        intent.putExtra(PreferenceKeys.INTENT_DETAILS_PARAMS, ViewCompat.getTransitionName(imageView));


        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));

        startActivity(intent, options.toBundle());


//        startActivity(intent);

      //  overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

    //    intent.putExtra(EXTRA_ANIMAL_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(sharedImageView));


    }

    @Override
    public void onEquipementItemClick(int pos, Equipment equipment, ImageView shareImageView) {

    }
}
