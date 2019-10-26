package com.kencorp.androidanimationexample.shared_transition_element.recycler_view;

import android.widget.ImageView;


public interface AnimalItemClickListener {
    void onAnimalItemClick(int pos, AnimalItem animalItem, ImageView shareImageView);
}