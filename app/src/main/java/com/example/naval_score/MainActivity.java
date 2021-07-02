package com.example.naval_score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    // View variables
    private TextView teamAScore;
    private TextView teamBScore;
    private ToggleButton teamSwitch;
    private RadioButton onePoint;
    private RadioButton twoPoint;
    private RadioButton threePoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // calling the init method to initialize the views
        init();
    }

    private void init() {
        // initialize the views by using findviewbyid
        teamAScore = findViewById(R.id.tv_score_a);
        teamBScore = findViewById(R.id.tv_score_b);
        onePoint = findViewById(R.id.rb_one_point);
        twoPoint = findViewById(R.id.rb_two_point);
        threePoint = findViewById(R.id.rb_three_points);
        teamSwitch = findViewById(R.id.tb_team);

    }

    public void onClickPlus(View view) {
        // select which team textview to use by checking if the toggle button is checked.
        // get the current score from the appropriate text view
        String scoreStr = teamAScore.getText().toString();
        if (teamSwitch.isChecked()) {
            scoreStr = teamBScore.getText().toString();
        }
        if (!TextUtils.isEmpty(scoreStr)) {
            //parse int value of the score.
            int score = Integer.parseInt(scoreStr);
            //change the score values according to the radio button selected.
            if (onePoint.isChecked()) {
                score = score + 1;
            } else if (twoPoint.isChecked()) {
                score = score + 2;
            } else if (threePoint.isChecked()) {
                score = score + 3;
            }
            //set the updated value to the view depending on the toggle button..
            if (teamSwitch.isChecked()) {
                teamBScore.setText(String.format("%s", score));
            } else {
                teamAScore.setText(String.format("%s", score));
            }
        } else {
            //set score as 0 if empty
            if (teamSwitch.isChecked()) {
                teamBScore.setText("0");
            } else {
                teamAScore.setText("0");
            }
        }
    }

    public void onClickMinus(View view) {
        // select which team textview to use by checking if the toggle button is checked.
        // get the current score from the appropriate text view

        String scoreStr = teamAScore.getText().toString();
        if (teamSwitch.isChecked()) {
            scoreStr = teamBScore.getText().toString();
        }
        if (!TextUtils.isEmpty(scoreStr)) {
            //parse int value of the score.
            int score = Integer.parseInt(scoreStr);

            //change the score values according to the radio button selected.
            if (onePoint.isChecked()) {
                score = score - 1;
            } else if (twoPoint.isChecked()) {
                score = score - 2;
            } else if (threePoint.isChecked()) {
                score = score - 3;
            }
            //change th value to 0 if it good below zero to avoid negative score
            if(score <= 0)
                score = 0;

            //set the updated value to the view depending on the toggle button..

            if (teamSwitch.isChecked()) {
                teamBScore.setText(String.format("%s", score));
            } else {
                teamAScore.setText(String.format("%s", score));
            }
        } else {
            //set score as 0 if empty

            if (teamSwitch.isChecked()) {
                teamBScore.setText("0");
            } else {
                teamAScore.setText("0");
            }
        }
    }
}