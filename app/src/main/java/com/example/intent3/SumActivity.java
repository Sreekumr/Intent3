package com.example.intent3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SumActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sum);

        // Initialize TextView
        textView = findViewById(R.id.textView);

        // Get the numbers from the Intent
        String num1 = getIntent().getStringExtra("num1");
        String num2 = getIntent().getStringExtra("num2");

        // Calculate and display the sum
        try {
            int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
            textView.setText("Sum: " + sum);
        } catch (NumberFormatException e) {
            textView.setText("Invalid input. Please enter numbers.");
        }

        // Set up window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}