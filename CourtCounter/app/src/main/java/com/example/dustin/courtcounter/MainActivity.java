package com.example.dustin.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int scoreA = 0, scoreB = 0;

    public void plusOneA(View v) {
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    public void plusTwoA(View v) {
        scoreA += 2;
        displayForTeamA(scoreA);
    }

    public void plusThreeA(View v) {
        scoreA += 3;
        displayForTeamA(scoreA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void plusOneB(View v) {
        scoreB += 1;
        displayForTeamB(scoreB);
    }

    public void plusTwoB(View v) {
        scoreB += 2;
        displayForTeamB(scoreB);
    }

    public void plusThreeB(View v) {
        scoreB += 3;
        displayForTeamB(scoreB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset(View v) {
        scoreB = 0;
        scoreA = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}
