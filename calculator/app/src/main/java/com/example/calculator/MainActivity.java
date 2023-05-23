package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button add, sub, mul, divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul =findViewById(R.id.mul);
        divide = findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float sum = Float.parseFloat(num1.getText().toString()) + Float.parseFloat(num2.getText().toString());
                Toast.makeText(MainActivity.this, sum.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float sum = Float.parseFloat(num1.getText().toString()) - Float.parseFloat(num2.getText().toString());
                Toast.makeText(MainActivity.this, sum.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float sum = Float.parseFloat(num1.getText().toString()) * Float.parseFloat(num2.getText().toString());
                Toast.makeText(MainActivity.this, sum.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float sum = Float.parseFloat(num1.getText().toString()) / Float.parseFloat(num2.getText().toString());
                Toast.makeText(MainActivity.this, sum.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}