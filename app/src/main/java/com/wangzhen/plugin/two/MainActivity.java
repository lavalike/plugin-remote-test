package com.wangzhen.plugin.two;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wangzhen.plugin.two.base.BaseActivity;
import com.wangzhen.statusbar.DarkStatusBar;
import com.wangzhen.statusbar.listener.StatusBar;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private boolean isDark = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DarkStatusBar.get().fitDark(getActivity());
        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_dark_status).setOnClickListener(this);
        findViewById(R.id.btn_toast).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
}
