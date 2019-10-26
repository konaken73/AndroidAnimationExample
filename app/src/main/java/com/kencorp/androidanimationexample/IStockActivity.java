package com.kencorp.androidanimationexample;


import android.widget.ImageView;


public interface IStockActivity {

    void inflatePassiveStock();
    void inflateViewDetailEquipement(Equipment equipment,ImageView imageView);

    void onEquipementItemClick(int pos, Equipment equipment, ImageView shareImageView);
//    void inflateDashBoard();
    void onBackPressed();
}
