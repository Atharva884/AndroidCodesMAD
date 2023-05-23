package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.database.*;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, age, search;
    Button btn;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        search = findViewById(R.id.searchName);

        btn = findViewById(R.id.btn);
    
        sqLiteDatabase = openOrCreateDatabase("Demo", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BC(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, age INTEGER)");
        Toast.makeText(this, "Table Created Successfully", Toast.LENGTH_SHORT).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stmt = "INSERT INTO BC(name, age) VALUES('" + name.getText().toString() + "', '" + Integer.parseInt(age.getText().toString()) + "')";
                sqLiteDatabase.execSQL(stmt);
                Toast.makeText(MainActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void search(View v){
        String stmt = "SELECT * FROM BC WHERE age=" + search.getText().toString();
        Cursor cursor = sqLiteDatabase.rawQuery(stmt, null);
        while (cursor.moveToNext()){
            Toast.makeText(this, "The name is: " + cursor.getString(1) + "\nThe Age is: " + cursor.getInt(2), Toast.LENGTH_SHORT).show();
        }
    }

}