package com.wangzhen.plugin.two.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzhen.plugin.two.R;

import java.util.ArrayList;
import java.util.List;

/**
 * PluginRecyclerAdapter
 * Created by wangzhen on 2020/4/3.
 */
public class PluginRecyclerAdapter extends RecyclerView.Adapter {
    private List<String> mDatas;

    public PluginRecyclerAdapter() {
        this.mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add(String.valueOf(i));
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InternalHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public static class InternalHolder extends RecyclerView.ViewHolder {

        public InternalHolder(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plugin_holder_layout, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "click position -> " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
