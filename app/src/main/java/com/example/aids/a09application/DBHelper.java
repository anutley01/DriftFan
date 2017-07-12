package com.example.aids.a09application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Connor on 10/07/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DRIFTFAN";
    private static final int DATABASE_VERSION = 1;
    public static final String EVENT_TABLE = "EVENT";
    public static final String EVENT_ID = "event_id";
    public static final String VENUE_ID = "venue_id";
    public static final String DATE = "date";
    public static final String EVENT_NAME = "event_name";

    public static final String VENUE_TABLE = "VENUE";
    public static final String VENUE_NAME = "venue_name";
    public static final String POSTCODE = "postcode";
    public static final String CITY = "city";

    public static final String DRIVER_TABLE = "DRIVER";
    public static final String DRIVER_ID = "driver_id";
    public static final String TEAM_ID = "team_id";
    public static final String DRIVER_NAME = "driver_name";
    public static final String POSITION = "driver_position";
    public static final String POINTS = "driver_points";

    public static final String TEAM_TABLE = "TEAM";
    //public static final String TEAM_ID = "team_id";
    public static final String TEAM_NAME = "team_name";
    public static final String TEAM_POSITION = "team_position";
    public static final String TEAM_POINTS = "team_points";

    public static final String RESULT_TABLE = "RESULT";
   // public static final String EVENT_ID = "event_id";
    //public static final String DRIVER_ID = "driver_id";
    //public static final String TEAM_ID = "team_id";
    public static final String DRIVER_POSITION = "driver_position";
    public static final String DRIVER_POINTS = "driver_points";
    //public static final String TEAM_POSITION = "team_position";
    //public static final String TEAM_POINTS = "team_points";

    public static final String USER_TABLE = "USER";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "username";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public static final String CAR_TABLE = "CAR";
    //public static final String DRIVER_ID = "driver_id";
    public static final String CAR_MAKE = "make";
    public static final String MODEL = "model";
    public static final String ENGINE = "engine";
    public static final String HORSEPOWER = "horsepower";

    private static final String DATABASE_CREATE = "create table " + EVENT_TABLE +
            "(" + EVENT_ID + "integer primary key autoincrement,"+
            VENUE_ID + "integer primary key autoincrement, "
            + DATE + "text, " + EVENT_NAME + "text,"
            +  "FOREIGN KEY (" + VENUE_ID + ") REFERENCES " + VENUE_TABLE + "(" + VENUE_ID + "));"
            + "create table " + VENUE_TABLE +
            "(" + VENUE_ID + "integer primary key autoincrement, "
            + VENUE_NAME + "text, "
            + POSTCODE + "text, "
            + CITY + "text);"
            + "create table " + DRIVER_TABLE
            + "( " + DRIVER_ID + "integer primary key autoincrement"
            + TEAM_ID + "integer primary key autoincrement, "
            + DRIVER_NAME + "text, "
            + POSITION + "integer, "
            + POINTS + "integer); "
            + "create table " + TEAM_TABLE
            + "(" + TEAM_ID + "integer primary key autoincrement, "
            + TEAM_NAME + "text, "
            + TEAM_POSITION + "integer, "
            + TEAM_POINTS + "integer, "
            + "FOREIGN KEY (" + TEAM_ID + ") REFERENCES " + DRIVER_TABLE + "(" + TEAM_ID + "));"
            + "create table " + RESULT_TABLE + "( "
            + EVENT_ID + "integer primary key autoincrement, "
            + DRIVER_ID + "integer primary key autoincrement, "
            + TEAM_ID + "integer primary key autoincrement, "
            + DRIVER_POSITION + "integer, "
            + DRIVER_POINTS + "integer not null, " + TEAM_POSITION + "integer, "
            + TEAM_POINTS + "integer not null, "
            + "FOREIGN KEY (" + EVENT_ID + ") REFERENCES " + EVENT_TABLE + "(" + EVENT_ID + ")," //**************
            + "FOREIGN KEY (" + DRIVER_ID + ") REFERENCES " + DRIVER_TABLE + "(" + DRIVER_ID + ")"
            + "FOREIGN KEY (" + TEAM_ID + ") REFERENCES " + TEAM_TABLE + "(" + TEAM_ID + ")"
            + "FOREIGN KEY (" + DRIVER_ID + ") REFERENCES " + DRIVER_TABLE + "(" + DRIVER_ID + "));"
            + "create table " + CAR_TABLE + "( "
            + DRIVER_ID + "integer primary key autoincrement, "
            + CAR_MAKE + "text, "
            + MODEL + "text, "
            + ENGINE + "text, "
            + HORSEPOWER + "text, "
            + "FOREIGN KEY (" + DRIVER_ID + ") REFERENCES " + DRIVER_TABLE + "(" + DRIVER_ID + "));"
            + "create table " + USER_TABLE + "("
            + USER_ID + "integer primary key autoincrement, "
            + USER_NAME + "text, "
            + EMAIL + "text, "
            + PASSWORD + "text);";



    public DBHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(DATABASE_CREATE);
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
