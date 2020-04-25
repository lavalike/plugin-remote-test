package com.wangzhen.plugin.two.base;

import android.os.Bundle;

import com.wangzhen.plugin.base.PluginBaseActivity;
import com.wangzhen.statusbar.DarkStatusBar;

/**
 * BaseActivity
 * Created by wangzhen on 2020/4/1.
 */
public class BaseActivity extends PluginBaseActivity {
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        DarkStatusBar.get().fitDark(this);
    }

}
