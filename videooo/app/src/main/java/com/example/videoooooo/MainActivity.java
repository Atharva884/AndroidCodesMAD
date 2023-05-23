package com.example.videoooooo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);

        videoView.setVideoURI(Uri.parse("https://encrypted-vtbn0.gstatic.com/video?q=tbn:ANd9GcRHu4xZyNFPFPdsYcNAQvGu4XF-KZbjiN-X_g"));
        videoView.start();

        MediaController mp = new MediaController(this);
        videoView.setMediaController(mp);
        mp.setAnchorView(videoView);
    }
}