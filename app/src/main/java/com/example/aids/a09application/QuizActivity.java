package com.example.aids.a09application;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import static com.example.aids.a09application.R.id.answer1;
import static com.example.aids.a09application.R.id.answer2;
import static com.example.aids.a09application.R.id.answer3;
import static com.example.aids.a09application.R.id.answer4;
import static com.example.aids.a09application.R.id.carImage;

/**
 * Created by Connor on 05/09/2017.
 */

public class QuizActivity extends Activity {
    SQLHelper db = new SQLHelper(this);
    String carName, incorrectCarName1, incorrectCarName2, incorrectCarName3, carImageName;
    Button answer1,answer2,answer3,answer4, next;
    ImageView carImage;
    int wrongAnswers, correctAnswers;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        carImage = (ImageView)findViewById(R.id.carImage);
        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);
        Button next = (Button)findViewById(R.id.nextButtonQuiz);
        List<Car> getAllCars = db.getAllCars();
        Bundle b = getIntent().getExtras();
        int id = b.getInt("QUESTION");
        switch(id){
            case 1:
            question(id);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
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
                    } else if(carID == 2||carID == 5|| carID == 8|| carID == 11 || carID == 14){
                        answer1.setText(incorrectCarName1);
                        answer2.setText(incorrectCarName2);
                        answer3.setText(carName);
                        answer4.setText(incorrectCarName3);
                    } else if (carID == 3|| carID == 6|| carID == 9|| carID == 12){
                        answer1.setText(incorrectCarName3);
                        answer2.setText(carName);
                        answer3.setText(incorrectCarName2);
                        answer4.setText(incorrectCarName1);
                    }
                }
            }}
    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
                }

                public void correctAnswer(){
                    Toast.makeText(this, "Press and hold to call this hotel", Toast.LENGTH_LONG).show();
                }

}
