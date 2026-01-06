package com.example.design;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class JournalDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_detail);

        TextView title = findViewById(R.id.detailTitle);
        TextView date = findViewById(R.id.detailDate);
        TextView mood = findViewById(R.id.detailMood);
        TextView content = findViewById(R.id.detailContent);

        // Get the data passed from the Adapter
        String journalTitle = getIntent().getStringExtra("title");
        String journalDate = getIntent().getStringExtra("date");
        String journalMood = getIntent().getStringExtra("mood");
        String journalContent = getIntent().getStringExtra("content");
        int journalId = getIntent().getIntExtra("id", -1);

        // Set the text
        title.setText(journalTitle);
        date.setText(journalDate);
        mood.setText(journalMood);
        content.setText(journalContent);

        ImageButton btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(v -> {
            // Delete from database
            AppDatabase.getInstance(this).journalDao().deleteById(journalId);

            // Show a message and go back
            Toast.makeText(this, "Journal Deleted", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
