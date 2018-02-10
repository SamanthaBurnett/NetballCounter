package com.example.android.netballscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int homeScore = 0;
    int visitorScore = 0;

    TextView home;
    TextView visitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = (TextView) findViewById(R.id.home_score);
        visitor = (TextView) findViewById(R.id.visitor_score);
    }

    //Saves views before they are destroyed
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String stateSaveHome = home.getText().toString();
        outState.putString("save_state_home", stateSaveHome);

        String stateSaveVisitor = visitor.getText().toString();
        outState.putString("save_state_visitor", stateSaveVisitor);
    }

    //Restores what the onSaveInstanceState saved
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String stateSavedHome = savedInstanceState.getString("save_state_home");
        //Resotres homeScore
        homeScore = Integer.parseInt(stateSavedHome);
        String stateSavedVisitor = savedInstanceState.getString("save_state_visitor");
        //Restores visitorScore
        visitorScore = Integer.parseInt(stateSavedVisitor);

        home.setText(stateSavedHome);
        visitor.setText(stateSavedVisitor);
    }

    /**
     * Updates and displays score of home team after shot is made outside of the "D".
     */
    public void twoPointsHome(View view) {
        homeScore += 2;
        displayHomeScore(homeScore);
    }

    /**
     * Updates and displays score of home team after shot is made within the "D".
     */
    public void onePointHome(View view) {
        homeScore += 1;
        displayHomeScore(homeScore);
    }

    /**
     * Updates and displays score of visiting team after shot is made outside of the "D".
     */
    public void twoPointsVisitor(View view) {
        visitorScore += 2;
        displayVisitorScore(visitorScore);
    }

    /**
     * Updates and displays score of visiting team after shot is made within the "D".
     */
    public void onePointVisitor(View view) {
        visitorScore += 1;
        displayVisitorScore(visitorScore);
    }

    /**
     * Displays the given score for home team.
     */
    public void displayHomeScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for visiting.
     */
    public void displayVisitorScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.visitor_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Resets scores of teams to 0.
     */
    public void reset(View view) {
        homeScore = 0;
        visitorScore = 0;
        displayHomeScore(homeScore);
        displayVisitorScore(visitorScore);
    }
}
