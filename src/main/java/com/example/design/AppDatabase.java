package com.example.design;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.design.Journal;
import com.example.design.JournalDao;

@Database(entities = {Journal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract JournalDao journalDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "journal_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // Only for learning; usually we use background threads
                    .build();
        }
        return instance;
    }
}