package com.example.aids.a09application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Connor on 05/09/2017.
 */

public class QuizActivity extends Activity {
    SQLHelper db = new SQLHelper(this);
    String carName, incorrectCarName1, incorrectCarName2, incorrectCarName3, carImageName;
    Button answer1,answer2,answer3,answer4;
    ImageView carImage;
    Bundle b;
    public int correctAnswers,wrongAnswers, id;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        carImage = (ImageView)findViewById(R.id.carImage);
        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);
        TextView currentWrong = (TextView)findViewById(R.id.incorrectAnswers);
        TextView currentScore = (TextView)findViewById(R.id.score);
        b = getIntent().getExtras();
        correctAnswers = b.getInt("SCORE");
        wrongAnswers = b.getInt("WRONG");
        List<Car> getAllCars = db.getAllCars();
        Bundle b = getIntent().getExtras();
        id = b.getInt("QUESTION");
        Log.d("Question id",Integer.toString(id));
        if(id <= 14){
            currentScore.setText("Current score: " + correctAnswers);
            currentWrong.setText("Wrong answers: " + wrongAnswers);
            question(id);

        } else if (id > 14){
            endQuiz();
        }


        }

    public int question(int carID){
        int toReturn;
            List<Car> getAllCars = db.getAllCars();
            for (int i = 0; i < getAllCars.size(); i++) {
                Car car = getAllCars.get(i);
                if (carID == car.getCarID()) {
                    carName = car.getCarName();
                    incorrectCarName1 = car.getIncorrectCarName1();
                    incorrectCarName2 = car.getIncorrectCarName2();
                    incorrectCarName3 = car.getIncorrectCarName3();
                    carImageName = car.getCarImage();
                    carImage.setImageResource(getImageId(this, carImageName));
                }
                    if(carID == 1||carID == 4|| carID == 7 || carID == 10|| carID == 13) {
                        answer1.setText(carName);
                        answer2.setText(incorrectCarName1);
                        answer3.setText(incorrectCarName2);
                        answer4.setText(incorrectCarName3);
                        correctAnswer(answer1);
                        shortClickButton(answer1);
                        shortClickButton(answer2);
                        shortClickButton(answer3);
                        shortClickButton(answer4);
                        incorrectAnswer(answer2);
                        incorrectAnswer(answer3);
                        incorrectAnswer(answer4);
                    } else if(carID == 2||carID == 5|| carID == 8|| carID == 11 || carID == 14){
                        answer1.setText(incorrectCarName1);
                        answer2.setText(incorrectCarName2);
                        answer3.setText(carName);
                        answer4.setText(incorrectCarName3);
                        correctAnswer(answer3);
                        shortClickButton(answer1);
                        shortClickButton(answer2);
                        shortClickButton(answer3);
                        shortClickButton(answer4);
                        incorrectAnswer(answer2);
                        incorrectAnswer(answer1);
                        incorrectAnswer(answer4);
                    } else if (carID == 3|| carID == 6|| carID == 9|| carID == 12){
                        answer1.setText(incorrectCarName3);
                        answer2.setText(carName);
                        answer3.setText(incorrectCarName2);
                        answer4.setText(incorrectCarName1);
                        correctAnswer(answer2);
                        shortClickButton(answer1);
                        shortClickButton(answer2);
                        shortClickButton(answer3);
                        shortClickButton(answer4);
                        incorrectAnswer(answer1);
                        incorrectAnswer(answer3);
                        incorrectAnswer(answer4);
                    }
                }
                return 1;
            }


    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier(imageName, null, context.getPackageName());
                }

                public void correctAnswer(Button button){
                    button.setOnLongClickListener(new View.OnLongClickListener(){
                        @Override
                        public boolean onLongClick(View v) {
                            Intent nextQuestion = new Intent(getApplicationContext(), QuizActivity.class);
                            Bundle extras = new Bundle();

                            correctAnswers++;
                            id++;
                            extras.putInt("SCORE", correctAnswers);
                            extras.putInt("QUESTION", id);
                            extras.putInt("WRONG",wrongAnswers);
                            Log.d("Question id after",Integer.toString(id));
                            nextQuestion.putExtras(extras);
                            startActivity(nextQuestion);
                            finish();
                        return true;
                        }
                    });
                    }

                    public void shortClickButton(Button button){
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Press and hold to select this as your answer", Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    public void incorrectAnswer(Button button){
                        button.setOnLongClickListener(new View.OnLongClickListener(){
                            @Override
                            public boolean onLongClick(View v) {
                                Intent nextQuestion = new Intent(getApplicationContext(), QuizActivity.class);
                                Bundle extras = new Bundle();
                                wrongAnswers++;
                                id++;
                                extras.putInt("SCORE", correctAnswers);
                                extras.putInt("WRONG",wrongAnswers);
                                extras.putInt("QUESTION", id);
                                Log.d("Question id after",Integer.toString(id));
                                nextQuestion.putExtras(extras);
                                startActivity(nextQuestion);
                                finish();
                                return true;
                            }
                        });
                    }



    public void endQuiz(){
        Intent endOfQuiz = new Intent(this, Score.class);
        Bundle extras = new Bundle();
        extras.putInt("SCORE", correctAnswers);
        extras.putInt("WRONG",wrongAnswers);
        endOfQuiz.putExtras(extras);
        startActivity(endOfQuiz);
        finish();
    }



}
