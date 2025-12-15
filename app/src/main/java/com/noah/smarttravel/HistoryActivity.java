package com.noah.smarttravel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView historyText = findViewById(R.id.historyListText);

        // Load saved flights
        String history = FileHelper.readFile(this, "history.txt");
        historyText.setText(history);
    }
}
