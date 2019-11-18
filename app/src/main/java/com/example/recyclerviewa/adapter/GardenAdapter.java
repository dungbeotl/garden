package com.example.recyclerviewa.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewa.GardenDetailActivity;
import com.example.recyclerviewa.R;
import com.example.recyclerviewa.adapter.ViewHolder.FlowerViewHolder;
import com.example.recyclerviewa.adapter.ViewHolder.FruitViewHolder;
import com.example.recyclerviewa.adapter.ViewHolder.GardenViewHolder;
import com.example.recyclerviewa.adapter.ViewHolder.ViewHolderLoading;
import com.example.recyclerviewa.model.Garden;

import java.util.ArrayList;

public class  GardenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   private final int  VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private final int  VIEW_TYPE_ITEM_FRUIT = 2;
    private final int  VIEW_TYPE_ITEM_FLOWER = 3;

    private GardenAdapterClickListener gardenAdapterClickListener;
    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading;

    private Context context;
    public CardView cardView;

    private ArrayList<Garden> gardens;

    private ArrayList<Garden> getAdapterData(){
        return gardens;
    }

    public GardenAdapter(Context context,GardenAdapterClickListener gardenAdapterClickListener, OnLoadMoreListener onLoadMoreListener, ArrayList<Garden> gardens) {
        this.context = context;
        this.gardenAdapterClickListener = gardenAdapterClickListener;
        this.onLoadMoreListener = onLoadMoreListener;
        this.gardens = gardens;
    }

    public void updateGardenData(ArrayList<Garden> list){
        isLoading = false;
        int gardenSize = gardens.size();
        gardens.addAll(list);
        notifyItemRangeInserted(gardenSize,list.size());
        //notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item,parent,false);
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, parent, false);
            return new GardenViewHolder(view, gardenAdapterClickListener);
        }
        if (viewType == VIEW_TYPE_ITEM_FRUIT){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit,parent,false);
            return new GardenViewHolder(view,gardenAdapterClickListener);
        } else if (viewType == VIEW_TYPE_ITEM_FLOWER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flower,parent,false);
            return new GardenViewHolder(view,gardenAdapterClickListener);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_loading_item,parent,false);
            return new ViewHolderLoading(view);
        }
        //return new GardenViewHolder(view,gardenAdapterClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {


        //((GardenViewHolder) holder).bind(gardens.get(position));
        if(holder instanceof GardenViewHolder) {
//            ((GardenViewHolder) holder).imItem.setImageResource(gardens.get(position).getThumbnail());
//            ((GardenViewHolder) holder).tvTitle.setText(gardens.get(position).getName());
            ((GardenViewHolder) holder).bind(gardens.get(position));
        }
        if(holder instanceof FlowerViewHolder) {
            ((FlowerViewHolder) holder).bind(gardens.get(position));
        }
        if(holder instanceof FruitViewHolder) {
            ((FruitViewHolder) holder).bind(gardens.get(position));
        }

        if(isLoading && (position == gardens.size() - 1)){
            isLoading = true;
            if (onLoadMoreListener != null){
                onLoadMoreListener.onLoadMore();
            }
        }
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context,GardenDetailActivity.class);
//                intent.putExtra("Name",gardens.get(position).getName());
//                intent.putExtra("Category",gardens.get(position).getCategory());
//                intent.putExtra("Description",gardens.get(position).getDescription());
//                intent.putExtra("Thumbnail",gardens.get(position).getThumbnail());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemViewType(int position) {
        if(position < getItemCount() - 1){
            //return VIEW_TYPE_ITEM;
            if(gardens.get(position).getCategory().equals("Fruit"))
                return VIEW_TYPE_ITEM_FRUIT;
            else if (gardens.get(position).getCategory().equals("Flower"))
                return VIEW_TYPE_ITEM_FLOWER;
            else return VIEW_TYPE_ITEM;
        }
        return VIEW_TYPE_LOADING;
    }

    @Override
    public int getItemCount() {
        return gardens.size();
    }
//    public class GardenChilHodel extends GardenViewHolder {
//        public GardenChilHodel(@NonNull View itemView, GardenAdapterClickListener listener) {
//            super(itemView, listener);
//            cardView = itemView.findViewById(R.id.cardView);
//        }
//    }
}
