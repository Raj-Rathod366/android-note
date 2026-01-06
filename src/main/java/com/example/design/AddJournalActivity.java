package com.example.design;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class AddJournalActivity extends AppCompatActivity {
    EditText editTitle, editContent;
    RadioGroup moodGroup;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journal);

        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        moodGroup = findViewById(R.id.moodGroup);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String title = editTitle.getText().toString();
            String content = editContent.getText().toString();

            // Get selected mood emoji
            int selectedId = moodGroup.getCheckedRadioButtonId();
            RadioButton selectedMood = findViewById(selectedId);
            String mood = (selectedMood != null) ? selectedMood.getText().toString() : "😊";

            // Save to Database
            Journal newEntry = new Journal(title, mood, content, "Jan 06, 2026");
            AppDatabase.getInstance(this).journalDao().insert(newEntry);

            // Close screen and go back
            finish();
        });
    }
}
