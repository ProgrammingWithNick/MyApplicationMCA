package com.example.myapplication;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7_calculator extends AppCompatActivity {

    EditText num1, num2;
    TextView result;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Animation scaleAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity7_calculator);

        // Views
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        // Load animation
        scaleAnim = AnimationUtils.loadAnimation(this, R.anim.button_scale);

        btnAdd.setOnClickListener(v -> {
            v.startAnimation(scaleAnim);
            calculate('+');
        });

        btnSub.setOnClickListener(v -> {
            v.startAnimation(scaleAnim);
            calculate('-');
        });

        btnMul.setOnClickListener(v -> {
            v.startAnimation(scaleAnim);
            calculate('*');
        });

        btnDiv.setOnClickListener(v -> {
            v.startAnimation(scaleAnim);
            calculate('/');
        });
    }

    private void calculate(char operator) {

        if (num1.getText().toString().trim().isEmpty() ||
                num2.getText().toString().trim().isEmpty()) {

            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());
        double res;

        switch (operator) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                if (b == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = a / b;
                break;
            default:
                return;
        }

        // Animate result
        result.setAlpha(0f);
        result.setText("Result: " + res);
        result.animate().alpha(1f).setDuration(500).start();
    }
}
