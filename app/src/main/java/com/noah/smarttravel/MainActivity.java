package com.noah.smarttravel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnChooseFlight;
    private Button btnViewHistory;
    private ImageView imgPlane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the layout
        setContentView(R.layout.activity_main);

        // Find views by ID
        imgPlane = findViewById(R.id.imgPlane);
        btnChooseFlight = findViewById(R.id.btnChooseFlight);
        btnViewHistory = findViewById(R.id.btnViewHistory);

        // Choose Flight button click
        btnChooseFlight.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FlightSelectionActivity.class);
            startActivity(intent);
        });

        // View History button click (placeholder)
        btnViewHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });
    }
}
