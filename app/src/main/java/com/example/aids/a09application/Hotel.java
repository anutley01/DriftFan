package com.example.aids.a09application;

/**
 * Created by Connor on 22/08/2017.
 */

public class Hotel {
    private int id;
    private String hotelName;
    private String phone;
    private double latitude;
    private double longitude;
    private String price;
    private String nearTo;

    public Hotel(){

    }

    public Hotel(int id, String hotelName, String phone, double latitude, double longitude, String price, String nearTo){
        this.id = id;
        this.hotelName = hotelName;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.nearTo = nearTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNearTo() {
        return nearTo;
    }

    public void setNearTo(String nearTo) {
        this.nearTo = nearTo;
    }
}
