package com.alap.livedatatest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


/**
 * livedata底层数据改变时，自动通知界面
 */
public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    TextView textView;
    ImageButton imageButton, imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);


        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        //观察者模式，如果框里发生变化则通知
        myViewModel.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                //自动刷新view
                textView.setText(String.valueOf(integer));
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.add(1);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.add(-1);
            }
        });


    }
}