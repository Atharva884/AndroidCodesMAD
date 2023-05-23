package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    EditText stringName;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        stringName = findViewById(R.id.textToSpeech);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status){
                if(status == TextToSpeech.SUCCESS){
                    int ttsLang = textToSpeech.setLanguage(Locale.US);
                    if(ttsLang == TextToSpeech.LANG_MISSING_DATA || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(MainActivity.this, "Language Not Supported", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Supported", Toast.LENGTH_SHORT).show();
                        Log.d("Success", "Supported");
                    }
                    Toast.makeText(MainActivity.this, "Initialization Successful", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "failed to initialize", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int status = textToSpeech.speak(stringName.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                if(status == TextToSpeech.ERROR){
                    Toast.makeText(MainActivity.this, "Error while converting text to speech", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}