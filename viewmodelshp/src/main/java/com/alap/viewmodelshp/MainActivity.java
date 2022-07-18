package com.alap.viewmodelshp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.alap.viewmodelshp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel mMyViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMyViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.setData(mMyViewModel);
        binding.setLifecycleOwner(this);
    }

//进行数据的存储
    @Override
    protected void onPause() {
        super.onPause();
        mMyViewModel.save();
    }
}