package com.example.aids.a09application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class Score extends Activity {
    int correctAnswers, wrongAnswers;

    /**
     * displays user score
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Bundle b = getIntent().getExtras();
        //get data from intent
        correctAnswers = b.getInt("SCORE");
        wrongAnswers = b.getInt("WRONG");
        //set textviews to user's score
        TextView wrong = (TextView)findViewById(R.id.numberOfWrong);
        TextView right = (TextView)findViewById(R.id.numberOfRight);
        right.setText("Correct answers: " + correctAnswers);
        wrong.setText("Wrong answers: " + wrongAnswers);


    }
}
