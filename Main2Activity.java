package com.example.textmooddetector;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String text = "";
        Bundle bundle = getIntent().getExtras();
    }

    public void switchScreen(View view) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }

    public void analyzeHandler(View view) {
        EditText et = (EditText) findViewById(R.id.editText);
        text = et.getText().toString();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("Passive Aggression: " + new PADetector().paScore(text));
        tv.setVisibility(View.VISIBLE);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setText("Readability: " + new Readability().getReadabilityScore(text));
        tv2.setVisibility(View.VISIBLE);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv3.setText("Formality: " + new Formality().getFormalScore(text));
        tv3.setVisibility(View.VISIBLE);
    }

    public void passiveAggressiveHandler(View view) {
        Button x = (Button) findViewById(R.id.button3);
        x.setVisibility(View.VISIBLE);
        TextView label = (TextView) findViewById(R.id.textView2);
        label.setVisibility(View.VISIBLE);
        label.setText("Passive Aggressiveness");
        label.setTextSize(20);
        EditText descrip = (EditText) findViewById(R.id.editText2);
        descrip.setVisibility(View.VISIBLE);
        descrip.setText(new PADetector().paReport(text));
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setVisibility(View.INVISIBLE);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setVisibility(View.INVISIBLE);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv3.setVisibility(View.INVISIBLE);
    }

    public void readabilityHandler(View view) {
        Button x = (Button) findViewById(R.id.button3);
        x.setVisibility(View.VISIBLE);
        TextView label = (TextView) findViewById(R.id.textView2);
        label.setVisibility(View.VISIBLE);
        label.setText("Readability");
        EditText descrip = (EditText) findViewById(R.id.editText2);
        descrip.setVisibility(View.VISIBLE);
        descrip.setText(new Readability().getReadabilityReport(text));
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setVisibility(View.INVISIBLE);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setVisibility(View.INVISIBLE);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv3.setVisibility(View.INVISIBLE);
    }

    public void formalityHandler(View view) {
        Button x = (Button) findViewById(R.id.button3);
        x.setVisibility(View.VISIBLE);
        TextView label = (TextView) findViewById(R.id.textView2);
        label.setVisibility(View.VISIBLE);
        label.setText("Formality");
        EditText descrip = (EditText) findViewById(R.id.editText2);
        descrip.setVisibility(View.VISIBLE);
        descrip.setText(new Formality().getFormalReport(text));
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setVisibility(View.INVISIBLE);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setVisibility(View.INVISIBLE);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv3.setVisibility(View.INVISIBLE);
    }

    public void xHandler(View view) {
        Button x = (Button) findViewById(R.id.button3);
        x.setVisibility(View.INVISIBLE);
        TextView label = (TextView) findViewById(R.id.textView2);
        label.setVisibility(View.INVISIBLE);
        EditText descrip = (EditText) findViewById(R.id.editText2);
        descrip.setVisibility(View.INVISIBLE);
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setVisibility(View.VISIBLE);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setVisibility(View.VISIBLE);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv3.setVisibility(View.VISIBLE);
    }

    public void editTextHandler(View view) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setVisibility(View.INVISIBLE);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setVisibility(View.INVISIBLE);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv3.setVisibility(View.INVISIBLE);
    }
}
