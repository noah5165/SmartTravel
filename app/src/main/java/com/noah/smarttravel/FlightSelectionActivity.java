package com.noah.smarttravel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FlightSelectionActivity extends AppCompatActivity {

    private ListView flightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_selection);

        flightList = findViewById(R.id.flightList);

        // Simple example list of flights
        String[] flights = {
                "Florida → NYC (4 hours)"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                flights
        );

        flightList.setAdapter(adapter);

        flightList.setOnItemClickListener((parent, view, position, id) -> {
            Intent i = new Intent(FlightSelectionActivity.this, TimerActivity.class);

            // Florida → NYC = 4 hours
            i.putExtra("flightDurationHours", 4);

            startActivity(i);
        });
    }
}
