package com.example.aids.a09application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Connor on 06/09/2017.
 */

public class Score extends Activity {
    int correctAnswers, wrongAnswers;
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
