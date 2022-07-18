package com.alap.basketballtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.alap.basketballtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
    myViewModel = new ViewModelProvider(this).get(MyViewModel.class);




        //dataBinding数据回绑定，设置数据进去
        binding.setData(myViewModel);
//观察数据
        binding.setLifecycleOwner(this);


    }
}