package com.oneday.videodemo.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private List<T> mDatas;
    private int layoutId;
    private int brId;
    private ItemClickListener clickListener;

    public CommonAdapter(List<T> mDatas, int layoutId, int brId){
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        this.brId = brId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        ViewHolder mViewHolder = new ViewHolder(binding.getRoot());
        mViewHolder.setBinding(binding);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.getBinding().setVariable(brId, mDatas.get(position));
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null){
                    clickListener.onItemClickListener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public interface ItemClickListener{
        public void onItemClickListener(int item);
    }

    public void setOnItemClick(ItemClickListener listener){
        this.clickListener = listener;
    }
}
