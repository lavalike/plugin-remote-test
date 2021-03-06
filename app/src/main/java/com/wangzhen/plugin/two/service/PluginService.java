package com.wangzhen.plugin.two.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * PluginService
 * Created by wangzhen on 2020/4/7.
 */
public class PluginService extends Service {
    private boolean running = true;

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
        Toast.makeText(getBaseContext(), "PluginService -> onStartCommand", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("TAG", "PluginService -> running " + System.currentTimeMillis());
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "PluginService -> onDestroy");
        Toast.makeText(getBaseContext(), "PluginService -> onDestroy", Toast.LENGTH_SHORT).show();
        running = false;
    }
}
