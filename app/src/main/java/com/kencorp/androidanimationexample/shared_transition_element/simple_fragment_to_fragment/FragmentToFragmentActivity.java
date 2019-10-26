package com.kencorp.androidanimationexample.shared_transition_element.simple_fragment_to_fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kencorp.androidanimationexample.R;


public class FragmentToFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, SimpleFragmentA.newInstance())
                .commit();
    }
}