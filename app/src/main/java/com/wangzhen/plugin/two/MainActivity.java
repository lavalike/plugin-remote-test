package com.wangzhen.plugin.two;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.wangzhen.plugin.two.base.BaseActivity;
import com.wangzhen.plugin.two.service.PluginService;
import com.wangzhen.plugin.two.service.PluginService02;
import com.wangzhen.plugin.two.widget.TestDialog;
import com.wangzhen.statusbar.DarkStatusBar;
import com.wangzhen.statusbar.listener.StatusBar;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private boolean isDark = true;
    private static final String action = "plugin-two";
    private BroadcastReceiver mReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        init();
    }

    private void init() {
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (action.equals(intent.getAction())) {
                    String data = intent.getStringExtra("data");
                    Toast.makeText(context, "收到广播 data -> " + data, Toast.LENGTH_SHORT).show();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        registerReceiver(mReceiver, intentFilter);
    }

    private void initViews() {
        findViewById(R.id.btn_dark_status).setOnClickListener(this);
        findViewById(R.id.btn_toast).setOnClickListener(this);
        findViewById(R.id.btn_recycler).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_start_service).setOnClickListener(this);
        findViewById(R.id.btn_stop_service).setOnClickListener(this);
        findViewById(R.id.btn_start_service02).setOnClickListener(this);
        findViewById(R.id.btn_stop_service02).setOnClickListener(this);
        findViewById(R.id.btn_dialog).setOnClickListener(this);
        findViewById(R.id.btn_broadcast).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_broadcast:
                broadcast();
                break;
            case R.id.btn_dialog:
                dialog();
                break;
            case R.id.btn_start_service02:
                startService(new Intent(getActivity(), PluginService02.class));
                break;
            case R.id.btn_stop_service02:
                stopService(new Intent(getActivity(), PluginService02.class));
                break;
            case R.id.btn_start_service:
                startService(new Intent(getActivity(), PluginService.class));
                break;
            case R.id.btn_stop_service:
                stopService(new Intent(getActivity(), PluginService.class));
                break;
            case R.id.btn_call:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                    } else {
                        call();
                    }
                } else {
                    call();
                }
                break;
            case R.id.btn_recycler:
                startActivity(new Intent(getActivity(), RecyclerViewActivity.class));
                break;
            case R.id.btn_toast:
                Toast.makeText(getActivity(), "this is a toast in plugin", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_dark_status:
                StatusBar statusBar = DarkStatusBar.get();
                if (isDark) {
                    statusBar.fitLight(getActivity());
                } else {
                    statusBar.fitDark(getActivity());
                }
                isDark = !isDark;
                break;
        }
    }

    private void broadcast() {
        Intent intent = new Intent(action);
        intent.putExtra("data", "test data");
        sendBroadcast(intent);
    }

    private void dialog() {
        new TestDialog(getActivity()).show();
    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:18368865748"));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                call();
            } else {
                Toast.makeText(getActivity(), "需要拨打电话权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
