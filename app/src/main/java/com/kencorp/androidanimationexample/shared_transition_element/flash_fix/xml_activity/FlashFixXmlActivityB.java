package com.kencorp.androidanimationexample.shared_transition_element.flash_fix.xml_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.kencorp.androidanimationexample.R;

public class FlashFixXmlActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_fix_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        supportPostponeEnterTransition();

        TextView detailTextView = (TextView) findViewById(R.id.flash_fix_activity_b_text);
        detailTextView.setText(getString(R.string.pig_blurb));

        ImageView imageView = (ImageView) findViewById(R.id.flash_fix_activity_b_imageView);
/*
        Glide.with(this)
                .load(FlashFixXmlActivityA.PIG_PIC_URL)
                .centerCrop()
                .dontAnimate()
                .listener(new RequestListener<String, DrawableResource>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<String> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(String resource, Object model, Target<String> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onException(Exception e, String model, Target<DrawableResource> target, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(DrawableResource resource, String model, Target<DrawableResource> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }
                })
                .into(imageView);*/
    }
}