package com.example.design;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "journal_table")
public class Journal {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String mood;
    public String content;
    public String date;

    // Constructor
    public Journal(String title, String mood, String content, String date) {
        this.title = title;
        this.mood = mood;
        this.content = content;
        this.date = date;
    }
}