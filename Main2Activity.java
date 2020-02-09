package com.example.textmooddetector;

import androidx.appcompat.app.AppCompatActivity;import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void switchScreen(View view){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }

    public void analyzeHandler(View view){
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("Passive Aggression: " + new PADetector().paScore(text) + "phrases");
        tv.setVisibility(View.VISIBLE);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setText("Readability: " + new Readability().getReadabilityScore(text));
        tv2.setVisibility(View.VISIBLE);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv3.setText("Formality: "+new Formality().getFormalScore(text));
        tv3.setVisibility(View.VISIBLE);
    }

    public void passiveAggressiveHandler(View view){
        Intent intent = new Intent(Main2Activity.this, PassiveAgressiveActivity.class);
        startActivity(intent);
    }

    public void readabilityHandler(View view){
        Intent intent = new Intent(Main2Activity.this, UnreadableActivity.class);
        startActivity(intent);
    }

    public void formalityHandler(View view){
        Intent intent = new Intent(Main2Activity.this, FormalActivity.class);
        startActivity(intent);
    }

    public void punctuationHandler(View view){
        Intent intent = new Intent(Main2Activity.this, PuncActivity.class);
        startActivity(intent);
    }

    public void editTextHandler(View view){
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setVisibility(View.INVISIBLE);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setVisibility(View.INVISIBLE);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv3.setVisibility(View.INVISIBLE);
        TextView tv4 = (TextView) findViewById(R.id.textView5);
        tv4.setVisibility(View.INVISIBLE);
    }

}
