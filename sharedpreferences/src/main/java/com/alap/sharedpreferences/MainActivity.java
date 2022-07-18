package com.alap.sharedpreferences;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//ApplicationContext可以理解为指向App的顶级引用
        MyData myData = new MyData(getApplicationContext());//不能传递this，如果传递this可能会导致内存泄漏

        myData.number = 1000;
        myData.save();
        int y = myData.load();
        String TAG = "myLog";
        Log.d(TAG, "onCreate: " + y);


//      //  SharedPreferences shp = getPreferences(Context.MODE_PRIVATE);
//      SharedPreferences shp =getSharedPreferences("MY_DATA",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = shp.edit();
//        editor.putInt("NUMBER", 600);
//        editor.apply();
//
//        int x = shp.getInt("NUMBER",0);
//        String TAG =  "myLog";
//        Log.d(TAG,"onCreate: "+x);
    }
}