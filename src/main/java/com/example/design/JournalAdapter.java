package com.example.design;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder> {

    private final List<Journal> journalList;

    public JournalAdapter(List<Journal> journalList) {
        this.journalList = journalList;
    }

    @NonNull
    @Override
    public JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This connects the Java code to your "item_journal.xml" layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_journal, parent, false);
        return new JournalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalViewHolder holder, int position) {
        // This puts the real data into the text views
        Journal currentJournal = journalList.get(position);
        holder.textTitle.setText(currentJournal.title);
        holder.textDate.setText(currentJournal.date);
        holder.textMoodIcon.setText(currentJournal.mood);

        // Add this Click Listener:
        holder.itemView.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(v.getContext(), JournalDetailActivity.class);

            // Pass the data to the next screen
            intent.putExtra("title", currentJournal.title);
            intent.putExtra("date", currentJournal.date);
            intent.putExtra("mood", currentJournal.mood);
            intent.putExtra("content", currentJournal.content);
            intent.putExtra("id", currentJournal.id);

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return journalList.size();
    }

    // This class finds the views inside item_journal.xml
    public static class JournalViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textDate, textMoodIcon;

        public JournalViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDate = itemView.findViewById(R.id.textDate);
            textMoodIcon = itemView.findViewById(R.id.textMoodIcon);
        }
    }


}