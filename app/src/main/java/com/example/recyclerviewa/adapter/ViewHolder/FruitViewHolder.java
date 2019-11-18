package com.example.recyclerviewa.adapter.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewa.GardenDetailActivity;
import com.example.recyclerviewa.R;
import com.example.recyclerviewa.adapter.GardenAdapterClickListener;
import com.example.recyclerviewa.model.Garden;

public class FruitViewHolder extends RecyclerView.ViewHolder {

    public static CardView cardView;
    //private CardView cardView;

    private GardenAdapterClickListener listener;
    //widget
    public TextView tvTitle;
    public ImageView imItem;
    String name,category,description;
    int img;
    Context context;


    public FruitViewHolder(@NonNull View itemView) {
        super(itemView);
        this.listener = listener;
        imItem = itemView.findViewById(R.id.ivItem);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        cardView = itemView.findViewById(R.id.cardView);
    }
    public void bind(final Garden garden){
        name = garden.getName();
        img = garden.getThumbnail();
        tvTitle.setText(name);

        imItem.setImageResource(img);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onGardenClick(garden);
                Intent intent = new Intent(itemView.getContext(), GardenDetailActivity.class);
                intent.putExtra("Name",garden.getName());
                intent.putExtra("Category",garden.getCategory());
                intent.putExtra("Description",garden.getDescription());
                intent.putExtra("Thumbnail",garden.getThumbnail());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
