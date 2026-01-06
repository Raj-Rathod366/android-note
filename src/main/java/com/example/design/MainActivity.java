package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button we made in the XML
        View btnAdd = findViewById(R.id.btnAddJournal);

        // Tell it to open the AddJournalActivity when clicked
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddJournalActivity.class);
            startActivity(intent);
        });
    }
}