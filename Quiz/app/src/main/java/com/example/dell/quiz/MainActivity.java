package com.example.dell.quiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    EditText A5;
    CheckBox A4A;
    CheckBox A4B;
    CheckBox A4C;
    RadioButton A3B;
    RadioButton A2A;
    RadioButton A1B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        calculateScore();
        Context context = getApplicationContext();

        String totalPoints = getString(R.string.msg1);
        totalPoints += score;
        totalPoints += getString(R.string.msg2);
        CharSequence text = totalPoints;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        score = 0;
    }

    public void calculateScore() {
        int correctionSin = getResources().getColor(R.color.correctionSingle);
        int correctionDou = getResources().getColor(R.color.correctionDouble);
        A5 = (EditText) findViewById(R.id.Ans5);
        A4A = (CheckBox) findViewById(R.id.Ans4a);
        A4B = (CheckBox) findViewById(R.id.Ans4b);
        A4C = (CheckBox) findViewById(R.id.Ans4c);
        A3B = (RadioButton) findViewById(R.id.Ans3b);
        A2A = (RadioButton) findViewById(R.id.Ans2a);
        A1B = (RadioButton) findViewById(R.id.Ans1b);

        if (A1B.isChecked()) {
            score += 2;
        } else {
           A1B.setTextColor(correctionSin);
        }

        if (A2A.isChecked()) {
            score += 2;
        } else {
            A2A.setTextColor(correctionSin);
        }

        if (A3B.isChecked()) {
            score += 1;
        } else {
            A3B.setTextColor(correctionSin);
        }

        if (A4A.isChecked() & A4B.isChecked() & A4C.isChecked()) {
            score += 2;
        } else if (!(A4A.isChecked()) & !(A4B.isChecked()) & !(A4C.isChecked())) {
            A4A.setTextColor(correctionDou);
            A4B.setTextColor(correctionDou);
            A4C.setTextColor(correctionDou);
        } else {
            score += 1;
            if (!(A4A.isChecked())) {
                A4A.setTextColor(correctionDou);
            }
            if (!(A4B.isChecked())) {
                A4B.setTextColor(correctionDou);
            }
            if (!(A4C.isChecked())) {
                A4C.setTextColor(correctionDou);
            }
        }

        String standardA5 = getString(R.string.A5);
        String answer = A5.getText().toString();
        if (answer.equals(standardA5) ) {
            score += 3;
        } else {
            A5.setText(standardA5);
            A5.setTextColor(correctionSin);
        }
    }

    public void reset(View view) {
        RadioGroup Q1 = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioGroup Q2 = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioGroup Q3 = (RadioGroup) findViewById(R.id.radioGroup3);
        int blk = getResources().getColor(R.color.black);
        String nul = "";
        A5.setText(nul);
        A5.setTextColor(blk);
        A4A.setTextColor(blk);
        A4B.setTextColor(blk);
        A4C.setTextColor(blk);
        A3B.setTextColor(blk);
        A2A.setTextColor(blk);
        A1B.setTextColor(blk);
        Q1.clearCheck();
        Q2.clearCheck();
        Q3.clearCheck();
        A4A.setChecked(false);
        A4B.setChecked(false);
        A4C.setChecked(false);
        score = 0;
    }
}
