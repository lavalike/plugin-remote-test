package com.wangzhen.plugin.two.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * PluginService02
 * Created by wangzhen on 2020/4/7.
 */
public class PluginService02 extends Service {

    private boolean running = true;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "PluginService02 -> onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "PluginService02 -> onStartCommand");
        Toast.makeText(getBaseContext(), "PluginService02 -> onStartCommand", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("TAG", "PluginService02 -> running " + System.currentTimeMillis());
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "PluginService02 -> onDestroy");
        Toast.makeText(getBaseContext(), "PluginService02 -> onDestroy", Toast.LENGTH_SHORT).show();
        running = false;
    }
}
