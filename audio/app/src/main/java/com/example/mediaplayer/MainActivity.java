package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.media.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view){
        mp = MediaPlayer.create(this, R.raw.audio);
        mp.start();
    }

    public void pause(View view){
//        Intent intent = new Intent(this, MainActivity.class)
        mp.pause();
    }

    public void stop(View view){
        mp.stop();
    }
}