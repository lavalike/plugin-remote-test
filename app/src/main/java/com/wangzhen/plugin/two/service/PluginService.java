package com.wangzhen.plugin.two.service;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.wangzhen.plugin.base.PluginBaseService;

/**
 * PluginService
 * Created by wangzhen on 2020/4/7.
 */
public class PluginService extends PluginBaseService {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "PluginService -> onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "PluginService -> onStartCommand");
        Toast.makeText(getContext(), "PluginService -> onStartCommand", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "PluginService -> onDestroy");
        Toast.makeText(getContext(), "PluginService -> onDestroy", Toast.LENGTH_SHORT).show();
    }
}
