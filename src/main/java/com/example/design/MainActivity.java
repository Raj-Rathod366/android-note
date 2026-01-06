package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.JournalAdapter;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MaterialButton btnAdd = findViewById(R.id.btnAddJournal);
        btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddJournalActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Every time you come back to this screen, refresh the list
        loadJournals();
    }

    private void loadJournals() {
        // Get all journals from the database
        List<Journal> list = AppDatabase.getInstance(this).journalDao().getAllJournals();

        // Setup the adapter with the list
        JournalAdapter adapter = new JournalAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}