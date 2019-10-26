package com.kencorp.androidanimationexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;


public class PassiveStockFragment extends Fragment {

    private static final String TAG = "PassiveStockFragment";
    private IStockActivity mListener;

    private RecyclerView vList;
    private SwipeRefreshLayout refreshLayout;

    private ArrayList<Equipment> equipmentArrayList = new ArrayList<>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_passive_stock, container, false);

        vList = view.findViewById(R.id.passiveRecyclerView);

        if(vList != null)
        {
            Toast.makeText(getContext(),"on",Toast.LENGTH_LONG).show();
        }


        refreshLayout = view.findViewById(R.id.refresh);

        Equipments equipments = new Equipments();
        for(Equipment equipment: equipments.EQUIPMENTS)
        {
            // if(equipment.status.equals("au magasin")){
            equipmentArrayList.add(equipment);
            //}
        }

        PassiveStockRecyclerAdapter passiveStockRecyclerAdapter = new PassiveStockRecyclerAdapter(equipmentArrayList,getActivity());
        vList.setLayoutManager(new LinearLayoutManager(getActivity()));

        // RecyclerView Animation item
        vList.setItemAnimator(new DefaultItemAnimator());


        vList.setAdapter(passiveStockRecyclerAdapter);
        Toast.makeText(getContext(),"on vlist",Toast.LENGTH_LONG).show();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });

       // initRecyclerView();

        return view;
    }

    public void onBackPressed() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IStockActivity) {
            mListener = (IStockActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }



    private void initRecyclerView()
    {
        Equipments equipments = new Equipments();
        for(Equipment equipment: equipments.EQUIPMENTS)
        {
           // if(equipment.status.equals("au magasin")){
                equipmentArrayList.add(equipment);
            //}
        }

        PassiveStockRecyclerAdapter passiveStockRecyclerAdapter = new PassiveStockRecyclerAdapter(equipmentArrayList,getActivity());
        vList.setLayoutManager(new LinearLayoutManager(getActivity()));
        vList.setAdapter(passiveStockRecyclerAdapter);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });
    }

}
