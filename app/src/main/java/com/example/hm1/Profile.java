package com.example.hm1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class Profile extends AppCompatActivity
{
    private TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        welcomeMessage = findViewById(R.id.welcomeMessage);
        String userName = getIntent().getStringExtra("user name");
        welcomeMessage.setText("Welcome " + userName);
    }
}