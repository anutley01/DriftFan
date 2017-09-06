package com.example.aids.a09application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Connor on 05/09/2017.
 */

public class QuizActivity extends Activity {
    SQLHelper db = new SQLHelper(this);
    String carName, incorrectCarName1, incorrectCarName2, incorrectCarName3, carImageName;
    Button answer1,answer2,answer3,answer4, next;
    ImageView carImage;
    Bundle b = getIntent().getExtras();
    public int correctAnswers = b.getInt("SCORE");
    public int wrongAnswers = b.getInt("WRONG");
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        carImage = (ImageView)findViewById(R.id.carImage);
        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);
        TextView currentScore = (TextView)findViewById(R.id.score);
        Button next = (Button)findViewById(R.id.nextButtonQuiz);
        List<Car> getAllCars = db.getAllCars();
        Bundle b = getIntent().getExtras();
        int id = b.getInt("QUESTION");
        if(id <= 14){
        question(id);
            currentScore.setText("Current score: " + correctAnswers);
        } else if (id > 14){
            endQuiz();
        }

        }

    public void question(int carID){
            List<Car> getAllCars = db.getAllCars();
            for (int i = 0; i < getAllCars.size(); i++) {
                Car car = getAllCars.get(i);
                // finds the correct building that was sent through via Intent from previous class
                if (carID == car.getCarID()) {
                    carName = car.getCarName();
                    incorrectCarName1 = car.getIncorrectCarName1();
                    incorrectCarName2 = car.getIncorrectCarName2();
                    incorrectCarName3 = car.getIncorrectCarName3();
                    carImageName = car.getCarImage();
                    carImage.setImageResource(getImageId(this, carImageName));
                    if(carID == 1||carID == 4|| carID == 7 || carID == 10|| carID == 13) {
                        answer1.setText(carName);
                        answer2.setText(incorrectCarName1);
                        answer3.setText(incorrectCarName2);
                        answer4.setText(incorrectCarName3);
                        correctAnswer(answer1);
                    } else if(carID == 2||carID == 5|| carID == 8|| carID == 11 || carID == 14){
                        answer1.setText(incorrectCarName1);
                        answer2.setText(incorrectCarName2);
                        answer3.setText(carName);
                        answer4.setText(incorrectCarName3);
                        correctAnswer(answer3);
                    } else if (carID == 3|| carID == 6|| carID == 9|| carID == 12){
                        answer1.setText(incorrectCarName3);
                        answer2.setText(carName);
                        answer3.setText(incorrectCarName2);
                        answer4.setText(incorrectCarName1);
                        correctAnswer(answer2);
                    }
                }
            }}


    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier(imageName, null, context.getPackageName());
                }

                public void correctAnswer(Button button){
                    button.setOnLongClickListener(new View.OnLongClickListener(){
                        @Override
                        public boolean onLongClick(View v) {
                            Intent nextQuestion = new Intent(getApplicationContext(), QuizActivity.class);
                            Bundle extras = new Bundle();
                            extras.putInt("SCORE", correctAnswers++);
                            nextQuestion.putExtras(extras);
                            startActivity(nextQuestion);
                        return true;
                        }
                    });
                    }
    public void endQuiz(){

    }



}
