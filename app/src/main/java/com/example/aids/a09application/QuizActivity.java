package com.example.aids.a09application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Connor on 05/09/2017.
 */

public class QuizActivity extends Activity{
    SQLHelper db = new SQLHelper(this);
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        ImageView carImage = (ImageView)findViewById(R.id.carImage);
        Button answer1 = (Button)findViewById(R.id.answer1);
        Button answer2 = (Button)findViewById(R.id.answer2);
        Button answer3 = (Button)findViewById(R.id.answer3);
        Button answer4 = (Button)findViewById(R.id.answer4);
        Button next = (Button)findViewById(R.id.nextButtonQuiz);
    }

}
