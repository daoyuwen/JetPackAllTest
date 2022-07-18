package com.alap.viewmodelshp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * 与ViewModel相比，AndroidViewModel的getApplication（）可以对全局资源进行一个访问
 * 如果不用AndroidViewModel的话也可
 */
public class MyViewModel extends AndroidViewModel {

    private final SavedStateHandle handle;
    //定义域
    private final String key = getApplication().getResources().getString(R.string.data_key);
    private final String shpName = getApplication().getResources().getString(R.string.shp_name);


    //private final String shpName = "SHP_NAME";

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        //如果handle里没有想要的数据就从SharedPreferences中读取
        if (!handle.contains(key)) {
            //从SharedPreferences中获取数据
            load();
        }
    }

    public LiveData<Integer> getNumber() {
        return handle.getLiveData(key);
    }

    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        int x = shp.getInt(key, 0);
        //读取的值写到handle中、
        handle.set(key, x);

    }

    //保存
    public void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();

        editor.putInt(key, getNumber().getValue() == null ? 0 : getNumber().getValue());
        editor.apply();
    }

    //做加法减法的
    public void add(final int x) {
        handle.set(key, getNumber().getValue() == null ? 0 : getNumber().getValue() + x);

    }


}
