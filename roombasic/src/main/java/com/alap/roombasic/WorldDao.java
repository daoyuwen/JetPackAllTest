package com.alap.roombasic;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//@Dao 是访问数据库的一个接口，所有的增删改查都要在这里声明
@Dao
public interface WorldDao {


    /**
     * 添加,,   ...三个点表示可以添加多个参数
     */
    @Insert
    void insertWords(Word... words);

    /**
     * 修改
     */
    @Update
    void upDateWords(Word... words);

    /**
     * 删除
     */
    @Delete
    void deleteWords(Word... words);

    /**
     * 清空
     */
    @Query("DELETE FROM WORD")
    void deleteAllWords();

    /**
     *     降序排列
     */

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    //List<Word> getAllWords();
    LiveData<List<Word>>getAllWordsLive();

}
