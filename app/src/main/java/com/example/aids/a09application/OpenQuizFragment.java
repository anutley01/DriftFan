package com.example.aids.a09application;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Connor on 05/09/2017.
 */

public class OpenQuizFragment extends android.support.v4.app.Fragment {
    /**
     * allows the user to start a quiz
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_quiz, container, false);
        Button quizButton = (Button)view.findViewById(R.id.quizButton);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openQuiz = new Intent(getActivity(), QuizActivity.class);
                Bundle extras = new Bundle();
                //variables to be used in next activity
                extras.putInt("QUESTION", 1);
                extras.putInt("SCORE", 0);
                extras.putInt("WRONG", 0);
                openQuiz.putExtras(extras);
                startActivity(openQuiz);
            }
        });
        return view;
    }
}
