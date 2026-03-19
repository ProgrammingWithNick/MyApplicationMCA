package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity10VideoView extends AppCompatActivity {
    Button btn1;
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_activity10_video_view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        vv = findViewById(R.id.vv);
        btn1 = findViewById(R.id.btn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your video file path or URL here
                // For local video in res/raw folder: "android.resource://" + getPackageName() + "/" + R.raw.your_video_file
                // For online video: "https://www.example.com/video.mp4"

                String videoPath = "android.resource://raw" + getPackageName() + "/" + R.raw.sample_video;
                Uri localUri = Uri.parse(videoPath);
                vv.setVideoURI(localUri);
                vv.start();
            }
        });
    }
}