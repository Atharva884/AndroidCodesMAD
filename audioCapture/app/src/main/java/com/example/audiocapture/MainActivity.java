package com.example.audiocapture;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {Manifest.permission.RECORD_AUDIO}, 100);
        }
    }

    public void start(View v){
        try {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(getOutputFile());
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();
            mediaRecorder.start();

            Toast.makeText(this, "Recording Audio", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    
    public void stop(View v){
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;

        Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
    }
    
    public void play(View v){
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(getOutputFile());
            mediaPlayer.prepare();
            mediaPlayer.start();

            Toast.makeText(this, "Playing Recording", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    public String getOutputFile(){
        ContextWrapper contextWrapper = new ContextWrapper(this);
        File file = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file1 = new File(file, "test" + ".mp3");
        return file1.getPath();
    }
}