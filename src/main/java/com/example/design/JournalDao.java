package com.example.design;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface JournalDao {
    @Insert
    void insert(Journal journal);

    @Query("SELECT * FROM journal_table ORDER BY id DESC")
    List<Journal> getAllJournals();
}