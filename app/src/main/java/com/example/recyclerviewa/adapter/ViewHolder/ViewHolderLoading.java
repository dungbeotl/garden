package com.example.recyclerviewa.adapter.ViewHolder;

import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderLoading extends RecyclerView.ViewHolder {

    public ProgressBar progressBar;

    public ViewHolderLoading(@NonNull View itemView) {
        super(itemView);
    }
}
