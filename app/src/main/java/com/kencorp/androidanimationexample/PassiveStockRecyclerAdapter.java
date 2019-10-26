package com.kencorp.androidanimationexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PassiveStockRecyclerAdapter extends RecyclerView.Adapter<PassiveStockRecyclerAdapter.Viewholder>{

    private ArrayList<Equipment> equipmentArrayList = new ArrayList<>();
    private Context context;

    private IStockActivity iMainActivity;

    public PassiveStockRecyclerAdapter(ArrayList<Equipment> equipmentArrayList, Context context) {
        this.equipmentArrayList = equipmentArrayList;
        this.context = context;

        Toast.makeText(context,"on builder  "+String.valueOf(equipmentArrayList.size()),Toast.LENGTH_LONG).show();

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_equipments,parent,false);
        Toast.makeText(context,"onCreate",Toast.LENGTH_LONG).show();

        return new Viewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Toast.makeText(context,equipmentArrayList.get(position).getId(),Toast.LENGTH_LONG).show();

        // if(equipmentArrayList.get(position).status.equals("au magasin"))
        //{

            holder.Bind(equipmentArrayList.get(position),position);
       // }
    }

    @Override
    public int getItemCount() {
        return equipmentArrayList.size();
    }


    public void removeItem(int position) {
        equipmentArrayList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, equipmentArrayList.size());
    }

    public void addItem(int position, Equipment equipment) {
        equipmentArrayList.add(position, equipment);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, equipmentArrayList.size());
    }

    public  class Viewholder extends RecyclerView.ViewHolder {

      public TextView name;
      public TextView isbn;
      public TextView status;
      public ImageView imageView;
      public View view;
        public CardView cardView;

        public ImageView delete;
        public ImageView autorenew;

        public Viewholder(@NonNull View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.name_equipment);
            isbn = itemView.findViewById(R.id.isbn_equipment);
            status = itemView.findViewById(R.id.status);
            imageView = itemView.findViewById(R.id.img_equipment);
            view = itemView ;
            cardView = itemView.findViewById(R.id.cardView);

            delete = itemView.findViewById(R.id.delete);
            autorenew = itemView.findViewById(R.id.autorenew);

        }



        public void Bind(final Equipment equipment, final int position)
        {
            Toast.makeText(context,equipment.getId(),Toast.LENGTH_LONG).show();


            name.setText(equipment.getName());

            isbn.setText(String.valueOf(equipment.getIsbn()));


            status.setText(equipment.getStatus());

            status.setTextColor(view.getResources().getColor(R.color.colorPrimaryDark));
            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_store_passive_24dp);


            Glide.with(view.getContext())
                    .load(equipment.getImageEquipment())
                    .apply(requestOptions)
                    .into(imageView);


            ViewCompat.setTransitionName(imageView, equipment.getName());


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iMainActivity.inflateViewDetailEquipement(equipment,imageView);
                }
            });




            /*
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animalItemClickListener.onAnimalItemClick(holder.getAdapterPosition(), animalItem, holder.animalImageView);
                }
            });*/


            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItem(position);
                }
            });
            autorenew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem(position,equipment);
                }
            });

        }


    }






    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        iMainActivity = (IStockActivity) context;
    }
}
