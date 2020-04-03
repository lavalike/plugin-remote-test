package com.wangzhen.plugin.two;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzhen.plugin.two.adapter.PluginRecyclerAdapter;
import com.wangzhen.plugin.two.base.BaseActivity;

public class RecyclerViewActivity extends BaseActivity {

    private RecyclerView mRecycler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initViews();
    }

    private void initViews() {
        mRecycler = findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(new PluginRecyclerAdapter());
    }
}
