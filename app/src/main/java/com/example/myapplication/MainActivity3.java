package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5;
    Button btn1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        et5=findViewById(R.id.et5);
        btn1=findViewById(R.id.btn1);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = et1.getText().toString().trim();
                String str1 = et2.getText().toString().trim();
                String str2 = et3.getText().toString().trim();
                String str3 = et4.getText().toString().trim();
                String str4 = et5.getText().toString().trim();

                if (str.isEmpty()) {
                    Toast.makeText(MainActivity3.this,
                            "Please enter something",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity3.this,
                        str,
                        Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                i.putExtra("nm", str);
                i.putExtra("ln", str1);
                i.putExtra("mn", str2);
                i.putExtra("ei", str3);
                i.putExtra("pw", str4);
                startActivity(i);
            }
        });

    }
}