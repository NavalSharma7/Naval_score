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
        init();
    }

    private void init() {
        teamAScore = findViewById(R.id.tv_score_a);
        teamBScore = findViewById(R.id.tv_score_b);
        onePoint = findViewById(R.id.rb_one_point);
        twoPoint = findViewById(R.id.rb_two_point);
        threePoint = findViewById(R.id.rb_three_points);
        teamSwitch = findViewById(R.id.tb_team);

    }

    public void onClickPlus(View view) {

        String scoreStr = teamAScore.getText().toString();
        if(teamSwitch.isChecked()){
             scoreStr = teamBScore.getText().toString();
        }
        if (!TextUtils.isEmpty(scoreStr)) {
            int score = Integer.parseInt(scoreStr);
            if (onePoint.isChecked()) {
                score = score + 1;
            } else if (twoPoint.isChecked()) {
                score = score + 2;
            } else if (threePoint.isChecked()) {
                score = score + 3;
            }
            if(teamSwitch.isChecked()){
                teamBScore.setText(String.format("%s", score));
            }else{
            teamAScore.setText(String.format("%s", score));}
        } else {
            if(teamSwitch.isChecked()){
                teamBScore.setText("1");
            }else{
            teamAScore.setText("1");
    }}
    }

    public void onClickMinus(View view) {
        String scoreStr = teamAScore.getText().toString();
        if(teamSwitch.isChecked()){
            scoreStr = teamBScore.getText().toString();
        }
        if (!TextUtils.isEmpty(scoreStr)) {
            int score = Integer.parseInt(scoreStr);
            if (onePoint.isChecked()) {
                score = score - 1;
            } else if (twoPoint.isChecked()) {
                score = score - 2;
            } else if (threePoint.isChecked()) {
                score = score - 3;
            }
            if(teamSwitch.isChecked()){
                teamBScore.setText(String.format("%s", score));
            }else{
            teamAScore.setText(String.format("%s", score));
        }} else {
            if(teamSwitch.isChecked()){
                teamBScore.setText("1");
            }else{
            teamAScore.setText("1");
        }
        }
    }
}