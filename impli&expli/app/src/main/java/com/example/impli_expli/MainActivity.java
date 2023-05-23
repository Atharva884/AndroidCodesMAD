package com.example.impli_expli;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.content.*;
public class MainActivity extends AppCompatActivity {
    EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = findViewById(R.id.url);
    }


    public void submit(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url.getText().toString()));
        startActivity(intent);
    }

    public void goToNext(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
