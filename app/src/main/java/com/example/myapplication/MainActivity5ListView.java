package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5ListView extends AppCompatActivity {

    ListView list1, list2;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_list_view);

        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);
        mySpinner = findViewById(R.id.mySpinner);

        String[] nm = {"1","2","3","4","5","6","7","8","9","10"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nm);

        list1.setAdapter(adapter);
        list2.setAdapter(adapter);

        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item, nm);

        spinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        mySpinner.setAdapter(spinnerAdapter);

        AdapterView.OnItemClickListener listClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity5ListView.this,
                                "Clicked: " + nm[position],
                                Toast.LENGTH_SHORT).show();
                    }
                };

        list1.setOnItemClickListener(listClickListener);
        list2.setOnItemClickListener(listClickListener);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity5ListView.this,
                        "Spinner: " + nm[position],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
