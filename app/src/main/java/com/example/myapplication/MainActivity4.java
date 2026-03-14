package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4, txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);

        // Receive data from MainActivity3

        String nm = getIntent().getStringExtra("nm");
        String ln = getIntent().getStringExtra("ln");
        String mn = getIntent().getStringExtra("mn");
        String ei = getIntent().getStringExtra("ei");
        String pw = getIntent().getStringExtra("pw");


            txt1.setText(nm);
            txt2.setText(ln);
            txt3.setText(mn);
            txt4.setText(ei);
            txt5.setText(pw);

    }
}
