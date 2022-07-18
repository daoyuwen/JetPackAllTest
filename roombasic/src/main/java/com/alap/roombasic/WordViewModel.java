package com.alap.roombasic;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WorldDao worldDao;


private WordReposltory wordReposltory;
    public WordViewModel(@NonNull Application application) {
        super(application);
        wordReposltory =new WordReposltory(application);

    }

    public LiveData<List<Word>> getAllWordsLive() {
        return wordReposltory.getAllWordsLive();
    }

    void insertWords(Word... words) {
        wordReposltory.insertWords(words);
    }

    void updateWords(Word... words) {
      wordReposltory.updateWords(words);
    }

    void deleteWords(Word... words) {
        wordReposltory.deleteWords(words);
    }

    void deleteAllWords(Word... words) {
        wordReposltory.deleteAllWords(words);
    }


}
