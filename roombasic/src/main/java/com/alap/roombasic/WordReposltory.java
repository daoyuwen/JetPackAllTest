package com.alap.roombasic;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordReposltory {
    private final LiveData<List<Word>> allWordsLive;
    private final WorldDao worldDao;

    public WordReposltory(Context context) {
        WordDatabase wordDatabase = WordDatabase.getDatabase(context);
        worldDao = wordDatabase.getWordDao();
        allWordsLive = worldDao.getAllWordsLive();
    }

    void insertWords(Word... words) {
        new InsertAsynnTask(worldDao).execute(words);
    }

    void updateWords(Word... words) {
        new UpdateAsyncTask(worldDao).execute(words);
    }

    void deleteWords(Word... words) {
        new DeleteAsyncTask(worldDao).execute(words);
    }

    void deleteAllWords(Word... words) {
        new DeleteAllAsyncTask(worldDao).execute();
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    static class InsertAsynnTask extends AsyncTask<Word, Void, Void> {
        private final WorldDao worldDao;

        public InsertAsynnTask(WorldDao worldDao) {
            this.worldDao = worldDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            worldDao.insertWords(words);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Word, Void, Void> {
        private final WorldDao worldDao;

        public UpdateAsyncTask(WorldDao worldDao) {
            this.worldDao = worldDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            worldDao.upDateWords(words);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void> {
        private final WorldDao worldDao;

        public DeleteAsyncTask(WorldDao worldDao) {
            this.worldDao = worldDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            worldDao.deleteWords(words);
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private final WorldDao worldDao;

        public DeleteAllAsyncTask(WorldDao worldDao) {
            this.worldDao = worldDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            worldDao.deleteAllWords();
            return null;
        }
    }
}
