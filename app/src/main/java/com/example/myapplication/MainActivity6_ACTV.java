package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6_ACTV extends AppCompatActivity {

    AutoCompleteTextView av1;
    MultiAutoCompleteTextView mav1;
    ProgressBar progressBar;
    RatingBar ratingBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_activity6_actv);

        av1 = findViewById(R.id.av1);
        mav1 = findViewById(R.id.mav1);
        progressBar = findViewById(R.id.progressBar);
        ratingBar = findViewById(R.id.ratingBar);

        String[] country = {
                "Japan",
                "South Korea",
                "India",
                "Switzerland"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                country
        );

        // AutoCompleteTextView
        av1.setThreshold(1);
        av1.setAdapter(adapter);

        // MultiAutoCompleteTextView
        mav1.setThreshold(1);
        mav1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mav1.setAdapter(adapter);
    }
}
