package com.example.textmooddetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PassiveAggressiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passive_agressive);
    }

    public void switchScreen(View view){
        Intent intent = new Intent(PassiveAggressiveActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}