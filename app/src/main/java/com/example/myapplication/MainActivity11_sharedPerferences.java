package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity11_sharedPerferences extends AppCompatActivity {

    EditText et1;
    Button btn1, btn2;
    TextView txt1;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_activity11_shared_perferences);

        // Initialize views - all IDs match your XML
        txt1 = findViewById(R.id.txt1);
        et1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        // Initialize SharedPreferences
        sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Save button click listener
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et1.getText().toString().trim();

                if (!name.isEmpty()) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("name", name);
                    editor.apply();
                    Toast.makeText(MainActivity11_sharedPerferences.this,
                            "Data Saved: " + name, Toast.LENGTH_SHORT).show();
                    et1.setText(""); // Clear after save
                } else {
                    Toast.makeText(MainActivity11_sharedPerferences.this,
                            "Please enter a name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Load button click listener
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = sp.getString("name", "No Data Found");
                txt1.setText("Saved Name: " + name);
                Toast.makeText(MainActivity11_sharedPerferences.this,
                        "Data Loaded", Toast.LENGTH_SHORT).show();
            }
        });
    }
}