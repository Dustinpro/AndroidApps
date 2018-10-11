package com.example.dustin.apythonquiz;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void setTx() {
        TextView tx = (TextView) findViewById(R.id.q1_text_view);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Times New Roman.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q1_1_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/Times New Roman.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q1code_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/SourceCodePro-Medium.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q2_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/Times New Roman.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q2_1_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/Times New Roman.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q2code_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/SourceCodePro-Medium.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q3_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/Times New Roman.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q4_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/Times New Roman.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q4_1_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/Times New Roman.ttf");
        tx.setTypeface(custom_font);
        tx = (TextView) findViewById(R.id.q4code_text_view);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/SourceCodePro-Medium.ttf");
        tx.setTypeface(custom_font);
    }

    TextView messageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTx();
        messageTextView = (TextView) findViewById(R.id.text_view);
//        TextView mem=(TextView) findViewById(R.id.text_view);
//        super.onCreate(savedInstanceState); // Always call the superclass first
//        // Check whether we're recreating a previously destroyed instance
//        if (savedInstanceState != null) {
//            // Restore value of members from saved state
//            mem.setText(savedInstanceState.getString("Data"));
//        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView tv = (TextView) findViewById(R.id.text_view);
        outState.putString("Data", tv.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView tv = (TextView) findViewById(R.id.text_view);
        tv.setText(savedInstanceState.getString("Data"));
        super.onRestoreInstanceState(savedInstanceState);
    }

//        TextView mem=(TextView) findViewById(R.id.text_view);
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        // Always call the superclass so it can restore the view hierarchy
//        super.onRestoreInstanceState(savedInstanceState);
//
//        // Restore state members from saved instance
//        mem.setText(savedInstanceState.getCharSequence("data"));
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        // Save the user's current game state
//
//        savedInstanceState.putCharSequence("data",mem.getText());
//        // Always call the superclass so it can save the view hierarchy state
//        super.onSaveInstanceState(savedInstanceState);
//    }
//    TextView messageTextView = (TextView) findViewById(R.id.text_view);
    public void displayMessage(String message) {
        messageTextView.setText(message);
    }

    public void handle(View view) {
        int score = 0;
        if (((RadioButton) findViewById(R.id.a1_radio_button)).isChecked()) {
            score += 5;
        }
        if (((RadioButton) findViewById(R.id.a2_radio_button)).isChecked()) {
            score += 5;
        }
        if (!((CheckBox) findViewById(R.id.num2_checkbox)).isChecked() && ((CheckBox) findViewById(R.id.num1_checkbox)).isChecked()
                && ((CheckBox) findViewById(R.id.num3_checkbox)).isChecked() && ((CheckBox) findViewById(R.id.num4_checkbox)).isChecked()) {
            score += 5;
        }
        EditText question4 = (EditText) findViewById(R.id.description_view);
        if (question4.getText().toString().equals(getString(R.string.ans))) {
            score += 5;
        }
        displayMessage(getString(R.string.feedback1) + score + getString(R.string.feedback2));
    }


}
