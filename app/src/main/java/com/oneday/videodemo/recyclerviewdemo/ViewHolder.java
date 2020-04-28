package com.oneday.videodemo.recyclerviewdemo;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}
