package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity8_RecActivity extends AppCompatActivity {

    private String[] data = {
            "Apple", "Banana", "Mango", "Orange", "Grapes",
            "Apple", "Banana", "Mango", "Orange", "Grapes"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity8_rec);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new SimpleAdapter());
    }

    class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.textView.setText(data[position]);

            holder.imageView.setImageResource(R.drawable.img);

            holder.itemView.setOnClickListener(view ->
                    Toast.makeText(view.getContext(),
                            "Clicked: " + data[position],
                            Toast.LENGTH_SHORT).show()
            );
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;
            ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }
}
