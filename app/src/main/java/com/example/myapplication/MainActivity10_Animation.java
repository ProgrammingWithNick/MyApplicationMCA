package com.example.myapplication;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity10_Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity10_animation);

        TextView textView = findViewById(R.id.textView);
        Button alpha = findViewById(R.id.alpha);
        Button rotate = findViewById(R.id.rotate);
        Button scale = findViewById(R.id.scale);
        Button translate = findViewById(R.id.translate);

        alpha.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
            textView.startAnimation(animation);
        });

        rotate.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
            textView.startAnimation(animation);
        });

        scale.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
            textView.startAnimation(animation);
        });

        translate.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
            textView.startAnimation(animation);
        });
    }
}