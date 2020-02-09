package com.example.textmooddetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UnreadableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unreadable);
    }

    public void switchScreen(View view){
        Intent intent = new Intent(UnreadableActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}