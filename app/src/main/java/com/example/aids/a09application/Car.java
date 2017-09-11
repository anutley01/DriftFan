package com.example.aids.a09application;

/**
 * Author: Connor
 * Class contains getters and setters for the "car" in the quiz activity
 */

public class Car {
    private int carID;
    private String carName;
    private String incorrectCarName1;
    private String incorrectCarName2;
    private String incorrectCarName3;
    private String carImage;
    public Car(){
        //default constructor
    }

    public Car(int carID, String carName, String incorrectCarName1, String incorrectCarName2, String incorrectCarName3, String carImage){
        this.carID = carID;
        this.carName = carName;
        this.incorrectCarName1 = incorrectCarName1;
        this.incorrectCarName2 = incorrectCarName2;
        this.incorrectCarName3 = incorrectCarName3;
        this.carImage = carImage;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getIncorrectCarName1() {
        return incorrectCarName1;
    }

    public void setIncorrectCarName1(String incorrectCarName1) {
        this.incorrectCarName1 = incorrectCarName1;
    }

    public String getIncorrectCarName2() {
        return incorrectCarName2;
    }

    public void setIncorrectCarName2(String incorrectCarName2) {
        this.incorrectCarName2 = incorrectCarName2;
    }

    public String getIncorrectCarName3() {
        return incorrectCarName3;
    }

    public void setIncorrectCarName3(String incorrectCarName3) {
        this.incorrectCarName3 = incorrectCarName3;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
