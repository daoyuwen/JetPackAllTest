package com.alap.roombasic;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 去副线程操作数据库
 */
public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    MyAdapter myAdapter1, myAdapter2;
    private Button mButtonInsert;
    private Button mButton4Clear;
    private WordViewModel wordViewModel;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        //鲜活的
        wordViewModel = new ViewModelProvider(this,
                new SavedStateViewModelFactory(getApplication(),
                        this)).get(WordViewModel.class);
        //再赋值
        myAdapter1 = new MyAdapter(false,wordViewModel);
        myAdapter2 = new MyAdapter(true,wordViewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter1);
        aSwitch = findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                recyclerView.setAdapter(myAdapter2);
            } else {
                recyclerView.setAdapter(myAdapter1);
            }
        });




        wordViewModel.getAllWordsLive().observe(this, words -> {
            int temp = myAdapter1.getItemCount();
            myAdapter1.setAllWords(words);
            myAdapter2.setAllWords(words);
            if (temp!= words.size()){
                myAdapter1.notifyDataSetChanged();
                myAdapter2.notifyDataSetChanged();
            }
        });

        mButtonInsert = findViewById(R.id.button);
        mButton4Clear = findViewById(R.id.button4);

        initData();

    }

    void initData() {
        mButtonInsert.setOnClickListener(v -> {
            String[] english = {
                    "Hello",
                    "World",
                    "Android",
                    "Google",
                    "Studio",
                    "Project",
                    "Database",
                    "Recycler",
                    "View", "String", "Value", "Integer"
            };
            String[] chinese = {
                    "你好", "世界", "android系统",
                    "谷歌公司", "工作室",
                    "项目", "数据库", "回收站",
                    "视图", "字符串", "价值", "整数类型"
            };
            for (int i = 0; i < english.length; i++) {
                wordViewModel.insertWords(new Word(english[i], chinese[i]));
            }

        });

        mButton4Clear.setOnClickListener(v -> {
            wordViewModel.deleteAllWords();
        });

    }

}