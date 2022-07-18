package com.alap.viewmodelsavedstate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.alap.viewmodelsavedstate.databinding.ActivityMainBinding;

/**
 * 进程在后台即使被杀死，数据也保存.
 */
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    MyViewModel mMyViewModel;
    final static String KEY_NUMBER="my_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMyViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        mBinding.setData(mMyViewModel);
        mBinding.setLifecycleOwner(this);

    }

}