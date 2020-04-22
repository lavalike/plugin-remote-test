package com.wangzhen.plugin.two.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * TestViewModel
 * Created by wangzhen on 2020/4/22.
 */
public class TestViewModel extends AndroidViewModel {
    private MutableLiveData<String> liveData = new MutableLiveData<>();

    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getLiveData() {
        return liveData;
    }

    public void setLiveData(String data) {
        liveData.setValue(data);
    }
}
