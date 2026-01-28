package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JournalAdapter adapter;
    private EditText editSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize Views
        recyclerView = findViewById(R.id.recyclerView);
        editSearch = findViewById(R.id.editSearch);
        MaterialButton btnAdd = findViewById(R.id.btnAddJournal);

        // 2. Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. Setup Search Logic
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                performSearch(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // 4. Setup "New Journal" Button
        btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddJournalActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the list when returning to this screen
        loadJournals();
    }

    private void loadJournals() {
        List<Journal> list = AppDatabase.getInstance(this).journalDao().getAllJournals();
        adapter = new JournalAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void performSearch(String query) {
        // Find journals matching the search query
        String searchQuery = "%" + query + "%";
        List<Journal> filteredList = AppDatabase.getInstance(this).journalDao().searchJournals(searchQuery);

        // Update the screen with filtered results
        adapter = new JournalAdapter(filteredList);
        recyclerView.setAdapter(adapter);
    }
}