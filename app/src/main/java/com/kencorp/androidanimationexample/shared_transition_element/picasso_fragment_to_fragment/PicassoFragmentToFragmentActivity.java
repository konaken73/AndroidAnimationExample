package com.kencorp.androidanimationexample.shared_transition_element.picasso_fragment_to_fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kencorp.androidanimationexample.R;


public class PicassoFragmentToFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, PicassoFragmentA.newInstance())
                    .commit();
        }
    }
}