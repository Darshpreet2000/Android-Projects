package com.example.courtcounters;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA=0,scoreB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Plus2A(View view){
        scoreA+=2;
        displayForTeamA(scoreA);
    }
    public void FreeA(View view){
        scoreA+=1;
        displayForTeamA(scoreA);
    }
    public void Plus3A(View view){
        scoreA+=3;
        displayForTeamA(scoreA);
    }
    public void Zero(View view){
        scoreA=0;
        scoreB=0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
    public void Plus2B(View view){
        scoreB+=2;
        displayForTeamB(scoreB);
    }
    public void FreeB(View view){
        scoreB+=1;
        displayForTeamB(scoreB);
    }
    public void Plus3B(View view){
        scoreB+=3;
        displayForTeamB(scoreB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
