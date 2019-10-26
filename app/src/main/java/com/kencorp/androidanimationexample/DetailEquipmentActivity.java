package com.kencorp.androidanimationexample;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kencorp.androidanimationexample.shared_transition_element.recycler_view.recycler_view_to_activity.RecyclerViewActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetailEquipmentActivity extends AppCompatActivity  {

    private ImageView image_detail;
    private Toolbar toolbar;

    private Equipment equipment;

    public TextView name;
    public TextView isbn;
    public TextView status;
    public ImageView imageView;

    public TextView cat;
    private TextView modele;
    private TextView manufacturer;
    private TextView dateDeMiseEnService;
    private TextView dateFabrique;
    private Equipment equipment1;
    private String Tag=" ";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_equipment);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        image_detail = findViewById(R.id.image_detail);


        equipment1 = (Equipment) getIntent().getParcelableExtra(PreferenceKeys.INTENT_DETAILS_EQUIPMENT);
        Tag = getIntent().getStringExtra(PreferenceKeys.INTENT_PARENT_NAME);


        toolbar.setTitle(equipment1.getName());
/*
        Glide.with(this)
                .load(equipment1.getImageEquipment())
                .transition()
                .into(image_detail);
*/


    /*
        ViewDetailsEquipmentFragment viewDetailsEquipmentFragment = new ViewDetailsEquipmentFragment();

        Bundle bundle = new Bundle();

        bundle.putParcelable(PreferenceKeys.INTENT_DETAILS_EQUIPMENT,equipment);

        viewDetailsEquipmentFragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame,viewDetailsEquipmentFragment,getString(R.string.tag_viewDetail_fragment));
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        transaction.addToBackStack(getString(R.string.tag_viewDetail_fragment));

        transaction.commit();
    */

        name =findViewById(R.id.name_equipment);
        isbn = findViewById(R.id.SerialNumber);
        imageView = findViewById(R.id.img_equipment);
        status = findViewById(R.id.status_equipment);
        cat = findViewById(R.id.typeEquip);

        modele = findViewById(R.id.modeleEquip);
        manufacturer = findViewById(R.id.manufacturer);
        dateDeMiseEnService = findViewById(R.id.dateDeMiseEnService);
        dateFabrique = findViewById(R.id.dateFabrique);


/*
        Glide.with(this)
                .load(equipment1.getImageEquipment())
                .into(imageView);
*/

        name.setText(equipment1.getName());
        isbn.setText(equipment1.getIsbn());
        status.setText(equipment1.getStatus());
        cat.setText(equipment1.getCategory());
        modele.setText("V8");
        manufacturer.setText("Tesla");
        dateDeMiseEnService.setText("10/09/2001");
        dateFabrique.setText("01/06/96");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = getIntent().getStringExtra(PreferenceKeys.INTENT_DETAILS_PARAMS);
            imageView.setTransitionName(imageTransitionName);
        }
        Picasso.with(this)
                .load(equipment1.getImageEquipment())
                .noFade()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError() {
                        supportStartPostponedEnterTransition();
                    }
                });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:



                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
        }



  @Override
   protected void onResume()
  {
      super.onResume();
      if(!equipment1.getName().isEmpty()){
          toolbar.setTitle(equipment1.getId());
      }else{
          toolbar.setTitle(equipment1.getName());
      }

      Tag = getIntent().getStringExtra(PreferenceKeys.INTENT_PARENT_NAME);

  }
}
