package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.view.*;
public class MainActivity extends AppCompatActivity {
    EditText email, emailSub, emailBody, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        emailSub = findViewById(R.id.emailSubj);
        emailBody = findViewById(R.id.emailBody);
        mobile = findViewById(R.id.mobile);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSub.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, emailBody.getText().toString());
        intent.setType("message/rc822");
        startActivity(Intent.createChooser(intent, "Select an email client"));
    }

    public void callDialer(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + mobile.getText().toString()));
        startActivity(intent);
    }

    public void call(View view){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + mobile.getText().toString()));
        startActivity(intent);
    }
}