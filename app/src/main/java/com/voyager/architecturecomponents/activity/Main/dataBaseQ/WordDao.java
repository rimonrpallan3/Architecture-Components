package com.voyager.architecturecomponents.activity.Main.dataBaseQ;

import com.voyager.architecturecomponents.activity.Main.model.Word;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WordDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();
}
