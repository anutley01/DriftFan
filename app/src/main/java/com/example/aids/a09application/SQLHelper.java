package com.example.aids.a09application;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 31/07/2017.
 */

public class SQLHelper extends SQLiteOpenHelper {
    SQLHelper sqlHelper;
    //initialise the table of the database
    public static final String TABLE_HOTEL_MONDELLO = "HotelMondello";
    public static final String TABLE_HOTEL_DUNLAOGHAIRE = "HotelDunLaoghaire";
    public static final String TABLE_HOTEL_WATERGRASSHILL = "HotelWatergrasshill";
    public static final String HOTEL_ID = "hotel_id";
    public static final String HOTEL_NAME = "hotel_name";
    public static final String PHONE = "phone";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String PRICE = "price";
    public static final String NEAR_TO = "NearTo";
    public static final String TABLE_RESTAURANTS = "Restaurants";
    private static final String DATABASE_NAME = "DriftFan";
    private static final int DATABASE_VERSION = 21;


    public static final String CREATE_HOTEL_MONDELLO = "CREATE TABLE IF NOT EXISTS " + TABLE_HOTEL_MONDELLO + "("
            + HOTEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + HOTEL_NAME + " TEXT,"
            + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
            + LONGITUDE + " DOUBLE," + PRICE + " TEXT,"
            + NEAR_TO + " TEXT" + ")";
    public static final String CREATE_HOTEL_DUNLAOGHAIRE = "CREATE TABLE IF NOT EXISTS " + TABLE_HOTEL_DUNLAOGHAIRE + "("
            + HOTEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + HOTEL_NAME + " TEXT,"
            + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
            + LONGITUDE + " DOUBLE," + PRICE + " TEXT,"
            + NEAR_TO + " TEXT" + ")";
    public static final String CREATE_HOTEL_WATERGRASSHILL = "CREATE TABLE IF NOT EXISTS " + TABLE_HOTEL_WATERGRASSHILL + "("
            + HOTEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + HOTEL_NAME + " TEXT,"
            + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
            + LONGITUDE + " DOUBLE," + PRICE + " TEXT,"
            + NEAR_TO + " TEXT" + ")";

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL_MONDELLO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL_DUNLAOGHAIRE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL_WATERGRASSHILL);

        db.execSQL(CREATE_HOTEL_MONDELLO);
        db.execSQL(CREATE_HOTEL_DUNLAOGHAIRE);
        db.execSQL(CREATE_HOTEL_WATERGRASSHILL);

        db.execSQL(insertHotelMondello("Curragh B&B", "+35345456429", 53.124905, -6.789059, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("No. 5 Bed and Breakfast", "+353 1 708 6400", 53.130330, -6.755625, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Maynooth Campus", "+353 85 110 0907", 53.379794, -6.595520, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Tulloch", "+353 45 531 988", 53.171297, -6.973274, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Kilcullen Home Stay", "+353 87 650 7195", 53.127930, -6.746819, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Cherryville House B&B", "+353 45 521 091", 53.155753, -6.963233, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Athgarvan B&B", "+353 45 405 950", 53.153120, -6.779494, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Naas Court Hotel", "+353 45 866 073", 53.216508, -6.664741, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Gardeners Cottage", "+353 86 817 4354", 53.371688, -6.715289, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Bridge B&B", "+353 45 881 891", 53.214835, -6.678269, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Lord Edward Accomodation", "+353 45 522 232", 53.156743, -6.908482, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("The rooms at Bardons", "+353 45 482 286", 53.131437, -6.744358, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Maudlins House Hotel", "+353 45 896 999", 53.231528, -6.640108, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Town House Hotel", "+353 45 879 226", 53.216150, -6.671831, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Celbridge Manor Hotel", "+353 1 601 3700", 53.334804, -6.557413, "A", "Mondello Park"));
        db.execSQL(insertHotelMondello("Tulfarris Hotel and Golf Resort", "+353 45 867 600", 53.125023, -6.559921, "B", "Mondello Park"));
        db.execSQL(insertHotelMondello("Johnstown House Hotel and Spa", "+353 46 954 0000", 53.404895, -6.836575, "B", "Mondello Park"));
        db.execSQL(insertHotelMondello("Kildare House Hotel", "+353 45 520 002", 53.155650, -6.906958, "B", "Mondello Park"));
        db.execSQL(insertHotelMondello("Lawlors Hotel", "+353 45 906 444", 53.219616, -6.660442, "B", "Mondello Park"));
        db.execSQL(insertHotelMondello("The Westgrove Hotel", "+353 45 989 900", 53.289701, -6.681741, "B", "Mondello Park"));
        db.execSQL(insertHotelMondello("Glenroyal Hotel and Leisure Club", "+353 1 629 0909", 53.380031, -6.588563, "B", "Mondello Park"));
        db.execSQL(insertHotelMondello("Osprey Hotel", "+353 45 881 111", 53.213229, -6.670439, "C", "Mondello Park"));
        db.execSQL(insertHotelMondello("Killashee Hotel", "+353 45 879 277", 53.191238, -6.674828, "C", "Mondello Park"));
        db.execSQL(insertHotelMondello("The Keadeen Hotel", "+353 45 431 666", 53.169432, -6.813250, "C", "Mondello Park"));
        db.execSQL(insertHotelMondello("Carton House Hotel", "+353 1 505 2000", 53.378373, -6.554703, "C", "Mondello Park"));
        db.execSQL(insertHotelMondello("Barberstown Castle", "+353 1 628 8157", 53.322679, -6.610127, "C", "Mondello Park"));
        db.execSQL(insertHotelMondello("Carton House Golf Club", "+353 1 505 2000", 53.390088, -6.567708, "C", "Mondello Park"));
        db.execSQL(insertHotelMondello("Cliff at Lyons", "+353 1 630 3500", 53.306441, -6.541697, "C", "Mondello Park"));
        db.execSQL(insertHotelMondello("The K Club", "+353 1 601 7200", 53.306348, -6.625205, "C", "Mondello Park"));
        db.execSQL(insertHotelDunLaoghaire("Claremont House", "+353 1 280 5346", 53.282933, -6.126022, "B", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("Royal Marine Hotel", "+353 1 230 0030", 53.292183, -6.133689, "B", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("Ferry House Hotel", "+353 1 280 8301", 53.288997, -6.130101, "B", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("Mulgrave Lodge", "+353 1 280 1664", 53.289949, -6.137087, "A", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("Tara Hall Accomodation", "+353 1 280 5120", 53.285998, -6.116562, "A", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("Talbot Hotel Stillorgan", "+353 1 200 1800", 53.294985, -6.203020, "B", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("Tara Towers", "+353 1 269 4666", 53.312408, -6.201849, "B", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("Fitzpatrick Castle Hotel", "+353 1 230 5400", 53.269597, -6.113356, "C", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("Radisson Blu Dublin", "+353 1 218 6000", 53.304606, -6.206020, "C", "Dun Laoghaire"));
        db.execSQL(insertHotelDunLaoghaire("The Beacon Hotel", "+353 1 291 5000", 53.276291, -6.220629, "C", "Dun Laoghaire"));
        db.execSQL(insertHotelWatergrasshill("Radisson Blue Cork", "+353 21 429 7000", 51.906362, -8.357155, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("The Grand Hotel", "+353 25 40966", 52.138355, -8.275748, "A", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Fota Island Resort", "+353 21 488 3700", 51.900422, -8.291834, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Fitzgeralds Vienna Woods Hotel and Holiday Homes", "+353 21 455 6800", 51.911762, -8.402957, "A", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Ashley Hotel", "+353 21 450 1518", 51.901778, -8.470564, "A", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Clayton Hotel Silver Springs", "+353 21 450 7533", 51.903993, -8.424103, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("The Montenotte Hotel", "+353 21 453 0050", 51.904667, -8.452009, "C", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Jurys Inn Cork", "+353 21 494 3000", 51.899491, -8.463986, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("The Metropole Hotel", "+353 21 464 3700", 51.901303, -8.467592, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Lancaster Lodge", "+353 21 425 1125", 51.896605, -8.482376, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Clayton Hotel Cork City", "+353 21 422 4900", 51.898567, -8.465002, "C", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Maldron Hotel Cork", "+353 21 452 9200", 51.902586, -8.474603, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Rochestown Park Hotel", "+353 21 489 0800", 51.879415, -8.424724, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Middleton Park Hotel", "+353 21 463 5100", 51.914947, -8.178708, "A", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("The River Lee", "+353 21 425 2700", 51.895918, -8.484813, "C", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("Hotel Isaacs Cork", "+353 21 450 0011", 51.901687, -8.468098, "B", "Watergrasshill"));
        db.execSQL(insertHotelWatergrasshill("GN Commons Inn", "+353 21 421 0300", 51.921757, -8.487141, "A", "Watergrasshill"));
    }

    public String insertHotelMondello(String hotel_name, String phone, double latitude, double longitude, String price, String near_to) {
        String insertBuilding = "INSERT INTO " + TABLE_HOTEL_MONDELLO +
                "(" + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                + ") VALUES ('"
                + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
        return insertBuilding;
    }

    public String insertHotelDunLaoghaire(String hotel_name, String phone, double latitude, double longitude, String price, String near_to) {
        String insertBuilding = "INSERT INTO " + TABLE_HOTEL_DUNLAOGHAIRE +
                "(" + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                + ") VALUES ('"
                + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
        return insertBuilding;
    }

    public String insertHotelWatergrasshill(String hotel_name, String phone, double latitude, double longitude, String price, String near_to) {
        String insertBuilding = "INSERT INTO " + TABLE_HOTEL_WATERGRASSHILL +
                "(" + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                + ") VALUES ('"
                + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
        return insertBuilding;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //send a warn message: tag - source of the log message; msg - message to be logged
        //please try to remove some of the spaces and see the consequence
        Log.w(SQLHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL_MONDELLO);//execute a SQL statement
        onCreate(db);//create a database
    }

    public List<Hotel> getAllHotelsMondello() {
        List<Hotel> hotelsList = new ArrayList<Hotel>();
        // SELECT ALL query
        String selectQuery = "SELECT * FROM " + TABLE_HOTEL_MONDELLO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                Hotel hotel = new Hotel();
                hotel.setId(Integer.parseInt(cursor.getString(0)));
                hotel.setHotelName(cursor.getString(1));
                hotel.setPhone(cursor.getString(2));
                hotel.setLatitude(Double.parseDouble(cursor.getString(3)));
                hotel.setLongitude(Double.parseDouble(cursor.getString(4)));
                hotel.setPrice(cursor.getString(5));
                hotel.setNearTo(cursor.getString(6));
                // Add buildings to list
                hotelsList.add(hotel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // Return a list of buildings
        return hotelsList;
    }


    public List<Hotel> getAllHotelsDunLaoghaire() {
        List<Hotel> hotelsList = new ArrayList<Hotel>();
        // SELECT ALL query
        String selectQuery = "SELECT * FROM " + TABLE_HOTEL_DUNLAOGHAIRE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                Hotel hotel = new Hotel();
                hotel.setId(Integer.parseInt(cursor.getString(0)));
                hotel.setHotelName(cursor.getString(1));
                hotel.setPhone(cursor.getString(2));
                hotel.setLatitude(Double.parseDouble(cursor.getString(3)));
                hotel.setLongitude(Double.parseDouble(cursor.getString(4)));
                hotel.setPrice(cursor.getString(5));
                hotel.setNearTo(cursor.getString(6));
                // Add buildings to list
                hotelsList.add(hotel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // Return a list of buildings
        return hotelsList;
    }


    public List<Hotel> getAllHotelsWatergrasshill() {
        List<Hotel> hotelsList = new ArrayList<Hotel>();
        // SELECT ALL query
        String selectQuery = "SELECT * FROM " + TABLE_HOTEL_WATERGRASSHILL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                Hotel hotel = new Hotel();
                hotel.setId(Integer.parseInt(cursor.getString(0)));
                hotel.setHotelName(cursor.getString(1));
                hotel.setPhone(cursor.getString(2));
                hotel.setLatitude(Double.parseDouble(cursor.getString(3)));
                hotel.setLongitude(Double.parseDouble(cursor.getString(4)));
                hotel.setPrice(cursor.getString(5));
                hotel.setNearTo(cursor.getString(6));
                // Add buildings to list
                hotelsList.add(hotel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // Return a list of buildings
        return hotelsList;
    }


    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_HOTEL_MONDELLO);
        return numRows;
    }

}