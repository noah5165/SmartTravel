package com.noah.smarttravel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView timerText;

    private CountDownTimer timer;

    private static final long WORK_TIME = 25 * 60 * 1000;  // 25 minutes
    private static final long BREAK_TIME = 5 * 60 * 1000;  // 5 minutes

    private long flightRemainingMillis;   // total flight duration
    private boolean isWorkPhase = true;   // start with 25-min work cycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerText = findViewById(R.id.timerText);

        int hours = getIntent().getIntExtra("flightDurationHours", 4);
        flightRemainingMillis = hours * 60 * 60 * 1000;

        startPomodoroCycle();
    }

    private void startPomodoroCycle() {

        if (flightRemainingMillis <= 0) {
            timerText.setText("Flight Completed!");
            timerText.setTextColor(getResources().getColor(android.R.color.white));
            return;
        }

        long duration = isWorkPhase ? WORK_TIME : BREAK_TIME;

        timer = new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                flightRemainingMillis -= 1000;

                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;

                timerText.setText(String.format("%02d:%02d", minutes, seconds));

                if (isWorkPhase) {
                    timerText.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                } else {
                    timerText.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                }
            }

            @Override
            public void onFinish() {
                isWorkPhase = !isWorkPhase;  // switch work/break
                startPomodoroCycle();        // start next cycle
            }
        }.start();
    }
}
