package com.example.mobileapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int clickCount = 0;
    private TextView counterText;
    private Button incrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        counterText = findViewById(R.id.counterText);
        incrementButton = findViewById(R.id.incrementButton);

        // Set click listener for button
        incrementButton.setOnClickListener(v -> {
            clickCount++;
            updateCounterDisplay();
        });
    }

    private void updateCounterDisplay() {
        counterText.setText("Clicks: " + clickCount);
    }
}
