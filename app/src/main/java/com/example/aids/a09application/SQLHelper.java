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
    public static final String TABLE_HOTEL = "comments";
    public static final String HOTEL_ID = "hotel_id";
    public static final String HOTEL_NAME = "hotel_name";
    public static final String PHONE = "phone";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String PRICE = "price";
    public static final String NEAR_TO = "NearTo";

    private static final String DATABASE_NAME = "DriftFan";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    //please remove the spaces in the code and see the results
//    private static final String DATABASE_CREATE = "create table "
//            + TABLE_HOTEL + "( " + HOTEL_ID
//            + " integer primary key autoincrement, "
//            + HOTEL_NAME + "text"
//            + PHONE + " text," +
//            LATITUDE + " double,"+
//            LONGITUDE + " double,"+
//            PRICE + " text,"
//            + NEAR_TO + "text" +");";

    public SQLHelper(Context context) {
        //please change 'context' to 'this' and see the result
        super(context, DATABASE_NAME, null, DATABASE_VERSION);//super class of creating database
        SQLiteDatabase db = this.getWritableDatabase();
    }

    /**
     * "A" is low price bracket. "B" is medium. "C" is high. This is used for the collections.sort method for when the list of hotels is being displayed
     *
     * @paramdatabase
     */


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL);


        String CREATE_HOTEL = "CREATE TABLE IF NOT EXISTS " + TABLE_HOTEL + "("
                + HOTEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + HOTEL_NAME + " TEXT,"
                + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
                + LONGITUDE + " DOUBLE," + PRICE + " TEXT,"
                + NEAR_TO + " TEXT" + ")";
        db.execSQL(CREATE_HOTEL);

        db.execSQL(insertBuilding("Curragh B&B", "+35345456429", 53.124905, -6.789059, "A", "Mondello Park"));
        db.execSQL(insertBuilding("No. 5 Bed and Breakfast", "+353 1 708 6400", 53.130330, -6.755625, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Maynooth Campus", "+353 85 110 0907", 53.379794, -6.595520, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Tulloch","+353 45 531 988", 53.171297, -6.973274, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Kilcullen Home Stay","+353 87 650 7195", 53.127930, -6.746819, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Cherryville House B&B","+353 45 521 091", 53.155753,-6.963233, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Athgarvan B&B","+353 45 405 950", 53.153120, -6.779494, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Naas Court Hotel","+353 45 866 073", 53.216508, -6.664741, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Gardeners Cottage","+353 86 817 4354", 53.371688, -6.715289, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Bridge B&B","+353 45 881 891", 53.214835, -6.678269, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Lord Edward Accomodation","+353 45 522 232", 53.156743, -6.908482, "A", "Mondello Park"));
        db.execSQL(insertBuilding("The rooms at Bardons","+353 45 482 286", 53.131437, -6.744358, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Maudlins House Hotel","+353 45 896 999", 53.231528, -6.640108, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Town House Hotel","+353 45 879 226", 53.216150, -6.671831, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Celbridge Manor Hotel","+353 1 601 3700", 53.334804, -6.557413, "A", "Mondello Park"));
        db.execSQL(insertBuilding("Tulfarris Hotel and Golf Resort","+353 45 867 600", 53.125023, -6.559921, "B", "Mondello Park"));
        db.execSQL(insertBuilding("Johnstown House Hotel and Spa","+353 46 954 0000", 53.404895, -6.836575, "B", "Mondello Park"));
        db.execSQL(insertBuilding("Kildare House Hotel","+353 45 520 002", 53.155650, -6.906958, "B", "Mondello Park"));
        db.execSQL(insertBuilding("Lawlors Hotel","+353 45 906 444", 53.219616, -6.660442, "B", "Mondello Park"));
        db.execSQL(insertBuilding("The Westgrove Hotel","+353 45 989 900", 53.289701, -6.681741, "B", "Mondello Park"));
        db.execSQL(insertBuilding("Glenroyal Hotel and Leisure Club","+353 1 629 0909", 53.380031, -6.588563, "B", "Mondello Park"));
        db.execSQL(insertBuilding("Osprey Hotel","+353 45 881 111", 53.213229, -6.670439, "C", "Mondello Park"));
        db.execSQL(insertBuilding("Killashee Hotel","+353 45 879 277", 53.191238, -6.674828, "C", "Mondello Park"));
        db.execSQL(insertBuilding("The Keadeen Hotel","+353 45 431 666", 53.169432, -6.813250, "C", "Mondello Park"));
        db.execSQL(insertBuilding("Carton House Hotel","+353 1 505 2000", 53.378373, -6.554703, "C", "Mondello Park"));
        db.execSQL(insertBuilding("Barberstown Castle","+353 1 628 8157", 53.322679, -6.610127, "C", "Mondello Park"));
        db.execSQL(insertBuilding("Carton House Golf Club","+353 1 505 2000", 53.390088, -6.567708, "C", "Mondello Park"));
        db.execSQL(insertBuilding("Cliff at Lyons","+353 1 630 3500", 53.306441, -6.541697, "C", "Mondello Park"));
        db.execSQL(insertBuilding("The K Club","+353 1 601 7200", 53.306348, -6.625205, "C", "Mondello Park"));
        db.execSQL(insertBuilding("Claremont House", "+353 1 280 5346", 53.282933, -6.126022, "B", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Royal Marine Hotel", "+353 1 230 0030", 53.292183, -6.133689, "B", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Ferry House Hotel", "+353 1 280 8301", 53.288997, -6.130101, "B", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Mulgrave Lodge", "+353 1 280 1664", 53.289949, -6.137087, "A", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Tara Hall Accomodation", "+353 1 280 5120", 53.285998, -6.116562, "A", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Talbot Hotel Stillorgan", "+353 1 200 1800",53.294985, -6.203020, "B", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Tara Towers", "+353 1 269 4666", 53.312408, -6.201849, "B", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Fitzpatrick Castle Hotel", "+353 1 230 5400", 53.269597, -6.113356, "C", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Radisson Blu Dublin", "+353 1 218 6000", 53.304606, -6.206020, "C", "Dun Laoghaire"));
        db.execSQL(insertBuilding("The Beacon Hotel", "+353 1 291 5000", 53.276291, -6.220629, "C", "Dun Laoghaire"));
        db.execSQL(insertBuilding("Radisson Blue Cork", "+353 21 429 7000", 51.906362, -8.357155, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("The Grand Hotel", "+353 25 40966", 52.138355, -8.275748, "A", "Watergrasshill"));
        db.execSQL(insertBuilding("Fota Island Resort", "+353 21 488 3700", 51.900422, -8.291834, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("Fitzgeralds Vienna Woods Hotel and Holiday Homes", "+353 21 455 6800", 51.911762, -8.402957, "A", "Watergrasshill"));
        db.execSQL(insertBuilding("Ashley Hotel", "+353 21 450 1518", 51.901778, -8.470564, "A", "Watergrasshill"));
        db.execSQL(insertBuilding("Clayton Hotel Silver Springs", "+353 21 450 7533", 51.903993, -8.424103, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("The Montenotte Hotel", "+353 21 453 0050", 51.904667, -8.452009, "C", "Watergrasshill"));
        db.execSQL(insertBuilding("Jurys Inn Cork", "+353 21 494 3000", 51.899491, -8.463986, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("The Metropole Hotel", "+353 21 464 3700", 51.901303, -8.467592, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("Lancaster Lodge", "+353 21 425 1125", 51.896605, -8.482376, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("Clayton Hotel Cork City", "+353 21 422 4900", 51.898567, -8.465002, "C", "Watergrasshill"));
        db.execSQL(insertBuilding("Maldron Hotel Cork", "+353 21 452 9200", 51.902586, -8.474603, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("Rochestown Park Hotel", "+353 21 489 0800", 51.879415, -8.424724, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("Middleton Park Hotel", "+353 21 463 5100", 51.914947, -8.178708, "A", "Watergrasshill"));
        db.execSQL(insertBuilding("The River Lee", "+353 21 425 2700", 51.895918, -8.484813, "C", "Watergrasshill"));
        db.execSQL(insertBuilding("Hotel Isaacs Cork", "+353 21 450 0011", 51.901687, -8.468098, "B", "Watergrasshill"));
        db.execSQL(insertBuilding("GN Commons Inn", "+353 21 421 0300", 51.921757, -8.487141, "A", "Watergrasshill"));
    }

    public String insertBuilding(String hotel_name, String phone, double latitude, double longitude, String price, String near_to) {
        String insertBuilding = "INSERT INTO " + TABLE_HOTEL +
                "(" + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                + ") VALUES ('"
                + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
        return insertBuilding;
    }



//    @Override
//    public void onCreate(SQLiteDatabase database) {
//        database.execSQL(DATABASE_CREATE);//execute the table to create statements on the database
//        database.execSQL(insertData("Curragh B&B", "+353 45 456 429", 53.124905, -6.789059, "A", "Mondello Park"));
//        database.execSQL(insertData("No. 5 Bed and Breakfast", "+353 1 708 6400", 53.130330, -6.755625, "A", "Mondello Park"));
//        database.execSQL(insertData("Maynooth Campus", "+353 85 110 0907", 53.379794, -6.595520, "A", "Mondello Park"));
//        database.execSQL(insertData("Tulloch","+353 45 531 988", 53.171297, -6.973274, "A", "Mondello Park"));
//        database.execSQL(insertData("Kilcullen Home Stay","+353 87 650 7195", 53.127930, -6.746819, "A", "Mondello Park"));
//        database.execSQL(insertData("Cherryville House B&B","+353 45 521 091", 53.155753,-6.963233, "A", "Mondello Park"));
//        database.execSQL(insertData("Athgarvan B&B","+353 45 405 950", 53.153120, -6.779494, "A", "Mondello Park"));
//        database.execSQL(insertData("Naas Court Hotel","+353 45 866 073", 53.216508, -6.664741, "A", "Mondello Park"));
//        database.execSQL(insertData("Gardeners Cottage","+353 86 817 4354", 53.371688, -6.715289, "A", "Mondello Park"));
//        database.execSQL(insertData("Bridge B&B","+353 45 881 891", 53.214835, -6.678269, "A", "Mondello Park"));
//        database.execSQL(insertData("Lord Edward Accomodation","+353 45 522 232", 53.156743, -6.908482, "A", "Mondello Park"));
//        database.execSQL(insertData("The rooms at Bardons","+353 45 482 286", 53.131437, -6.744358, "A", "Mondello Park"));
//        database.execSQL(insertData("Maudlins House Hotel","+353 45 896 999", 53.231528, -6.640108, "A", "Mondello Park"));
//        database.execSQL(insertData("Town House Hotel","+353 45 879 226", 53.216150, -6.671831, "A", "Mondello Park"));
//        database.execSQL(insertData("Celbridge Manor Hotel","+353 1 601 3700", 53.334804, -6.557413, "A", "Mondello Park"));
//        database.execSQL(insertData("Tulfarris Hotel and Golf Resort","+353 45 867 600", 53.125023, -6.559921, "B", "Mondello Park"));
//        database.execSQL(insertData("Johnstown House Hotel and Spa","+353 46 954 0000", 53.404895, -6.836575, "B", "Mondello Park"));
//        database.execSQL(insertData("Kildare House Hotel","+353 45 520 002", 53.155650, -6.906958, "B", "Mondello Park"));
//        database.execSQL(insertData("Lawlors Hotel","+353 45 906 444", 53.219616, -6.660442, "B", "Mondello Park"));
//        database.execSQL(insertData("The Westgrove Hotel","+353 45 989 900", 53.289701, -6.681741, "B", "Mondello Park"));
//        database.execSQL(insertData("Glenroyal Hotel and Leisure Club","+353 1 629 0909", 53.380031, -6.588563, "B", "Mondello Park"));
//        database.execSQL(insertData("Osprey Hotel","+353 45 881 111", 53.213229, -6.670439, "C", "Mondello Park"));
//        database.execSQL(insertData("Killashee Hotel","+353 45 879 277", 53.191238, -6.674828, "C", "Mondello Park"));
//        database.execSQL(insertData("The Keadeen Hotel","+353 45 431 666", 53.169432, -6.813250, "C", "Mondello Park"));
//        database.execSQL(insertData("Carton House Hotel","+353 1 505 2000", 53.378373, -6.554703, "C", "Mondello Park"));
//        database.execSQL(insertData("Barberstown Castle","+353 1 628 8157", 53.322679, -6.610127, "C", "Mondello Park"));
//        database.execSQL(insertData("Carton House Golf Club","+353 1 505 2000", 53.390088, -6.567708, "C", "Mondello Park"));
//        database.execSQL(insertData("Cliff at Lyons","+353 1 630 3500", 53.306441, -6.541697, "C", "Mondello Park"));
//        database.execSQL(insertData("The K Club","+353 1 601 7200", 53.306348, -6.625205, "C", "Mondello Park"));
//        database.execSQL(insertData("Claremont House", "+353 1 280 5346", 53.282933, -6.126022, "B", "Dun Laoghaire"));
//        database.execSQL(insertData("Royal Marine Hotel", "+353 1 230 0030", 53.292183, -6.133689, "B", "Dun Laoghaire"));
//        database.execSQL(insertData("Ferry House Hotel", "+353 1 280 8301", 53.288997, -6.130101, "B", "Dun Laoghaire"));
//        database.execSQL(insertData("Mulgrave Lodge", "+353 1 280 1664", 53.289949, -6.137087, "A", "Dun Laoghaire"));
//        database.execSQL(insertData("Tara Hall Accomodation", "+353 1 280 5120", 53.285998, -6.116562, "A", "Dun Laoghaire"));
//        database.execSQL(insertData("Rochestown Lodge", "+353 1 285 3555", 53.269638, -6.141552, "B", "Dun Laoghaire"));
//        database.execSQL(insertData("Talbot Hotel Stillorgan", "+353 1 200 1800",53.294985, -6.203020, "B", "Dun Laoghaire"));
//        database.execSQL(insertData("Tara Towers", "+353 1 269 4666", 53.312408, -6.201849, "B", "Dun Laoghaire"));
//        database.execSQL(insertData("Fitzpatrick Castle Hotel", "+353 1 230 5400", 53.269597, -6.113356, "C", "Dun Laoghaire"));
//        database.execSQL(insertData("Radisson Blu Dublin", "+353 1 218 6000", 53.304606, -6.206020, "C", "Dun Laoghaire"));
//        database.execSQL(insertData("The Beacon Hotel", "+353 1 291 5000", 53.276291, -6.220629, "C", "Dun Laoghaire"));
//        database.execSQL(insertData("Radisson Blue Cork", "+353 21 429 7000", 51.906362, -8.357155, "B", "Watergrasshill"));
//        database.execSQL(insertData("The Grand Hotel", "+353 25 40966", 52.138355, -8.275748, "A", "Watergrasshill"));
//        database.execSQL(insertData("Fota Island Resort", "+353 21 488 3700", 51.900422, -8.291834, "B", "Watergrasshill"));
//        database.execSQL(insertData("Fitzgeralds Vienna Woods Hotel and Holiday Homes", "+353 21 455 6800", 51.911762, -8.402957, "A", "Watergrasshill"));
//        database.execSQL(insertData("Ashley Hotel", "+353 21 450 1518", 51.901778, -8.470564, "A", "Watergrasshill"));
//        database.execSQL(insertData("Clayton Hotel Silver Springs", "+353 21 450 7533", 51.903993, -8.424103, "B", "Watergrasshill"));
//        database.execSQL(insertData("The Montenotte Hotel", "+353 21 453 0050", 51.904667, -8.452009, "C", "Watergrasshill"));
//        database.execSQL(insertData("Jurys Inn Cork", "+353 21 494 3000", 51.899491, -8.463986, "B", "Watergrasshill"));
//        database.execSQL(insertData("The Metropole Hotel", "+353 21 464 3700", 51.901303, -8.467592, "B", "Watergrasshill"));
//        database.execSQL(insertData("Lancaster Lodge", "+353 21 425 1125", 51.896605, -8.482376, "B", "Watergrasshill"));
//        database.execSQL(insertData("Clayton Hotel Cork City", "+353 21 422 4900", 51.898567, -8.465002, "C", "Watergrasshill"));
//        database.execSQL(insertData("Maldron Hotel Cork", "+353 21 452 9200", 51.902586, -8.474603, "B", "Watergrasshill"));
//        database.execSQL(insertData("Rochestown Park Hotel", "+353 21 489 0800", 51.879415, -8.424724, "B", "Watergrasshill"));
//        database.execSQL(insertData("Middleton Park Hotel", "+353 21 463 5100", 51.914947, -8.178708, "A", "Watergrasshill"));
//        database.execSQL(insertData("The River Lee", "+353 21 425 2700", 51.895918, -8.484813, "C", "Watergrasshill"));
//        database.execSQL(insertData("Hotel Isaacs Cork", "+353 21 450 0011", 51.901687, -8.468098, "B", "Watergrasshill"));
//        database.execSQL(insertData("GN Commons Inn", "+353 21 421 0300", 51.921757, -8.487141, "A", "Watergrasshill"));
//    }
   // mydatabase.execSQL("CREATE TABLE IF NOT EXISTS TutorialsPoint(Username VARCHAR,Password VARCHAR);");
    //mydatabase.execSQL("INSERT INTO TutorialsPoint VALUES('admin','admin');");
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //send a warn message: tag - source of the log message; msg - message to be logged
        //please try to remove some of the spaces and see the consequence
        Log.w(SQLHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL);//execute a SQL statement
        onCreate(db);//create a database
    }

    /*public boolean insertData(String hotelName, String hotelPhone, String latitude, String longitude, String price, String near_to){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //2 arguments. First is the column name, second is the content itself
        contentValues.put(HOTEL_NAME, hotelName);
        contentValues.put(PHONE, hotelPhone);
        contentValues.put(LATITUDE, latitude);
        contentValues.put(LONGITUDE, longitude);
        contentValues.put(PRICE,price);
        contentValues.put(NEAR_TO, near_to);
        long result = sqLiteDatabase.insert(TABLE_HOTEL, null, contentValues);
        if (result == -1){
            return false;
        } else{
            return true;
        }

    }*/
    public String insertBulding(String hotelName, String phone, double latitude, double longitude, String price, String nearTo) {
        String insertHotelToDB = "INSERT INTO " + TABLE_HOTEL
                + " (" + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                + ") VALUES ('" + hotelName + "','" + phone + "'," + latitude + "," + longitude + ",'" + price + "','" + nearTo + "')";
        return insertHotelToDB;
    }
    /*public void createHotels(){
        insertData("Curragh B&B","+353 45 456 429", 53.124905,-6.789059, "Low", "Mondello Park");
        insertData("No. 5 Bed and Breakfast", "+353 1 708 6400", 53.130330, -6.755625, "Low", "Mondello Park");
        insertData("Maynooth Campus", "+353 85 110 0907", 53.379794, -6.595520, "Low", "Mondello Park");
        insertData("Tulloch","+353 45 531 988", 53.171297, -6.973274, "Low", "Mondello Park");
        insertData("Kilcullen Home Stay","+353 87 650 7195", 53.127930, -6.746819, "Low", "Mondello Park");
        insertData("Cherryville House B&B","+353 45 521 091", 53.155753,-6.963233, "Low", "Mondello Park");
        insertData("Athgarvan B&B","+353 45 405 950", 53.153120, -6.779494, "Low", "Mondello Park");
        insertData("Naas Court Hotel","+353 45 866 073", 53.216508, -6.664741, "Low", "Mondello Park");
        insertData("Gardeners Cottage","+353 86 817 4354", 53.371688, -6.715289, "Low", "Mondello Park");
        insertData("Bridge B&B","+353 45 881 891", 53.214835, -6.678269, "Low", "Mondello Park");
        insertData("Lord Edward Accomodation","+353 45 522 232", 53.156743, -6.908482, "Low", "Mondello Park");
        insertData("The rooms at Bardons","+353 45 482 286", 53.131437, -6.744358, "Low", "Mondello Park");
        insertData("Maudlins House Hotel","+353 45 896 999", 53.231528, -6.640108, "Low", "Mondello Park");
        insertData("Town House Hotel","+353 45 879 226", 53.216150, -6.671831, "Low", "Mondello Park");
        insertData("Celbridge Manor Hotel","+353 1 601 3700", 53.334804, -6.557413, "Low", "Mondello Park");
        insertData("Tulfarris Hotel and Golf Resort","+353 45 867 600", 53.125023, -6.559921, "Med", "Mondello Park");
        insertData("Johnstown House Hotel and Spa","+353 46 954 0000", 53.404895, -6.836575, "Med", "Mondello Park");
        insertData("Kildare House Hotel","+353 45 520 002", 53.155650, -6.906958, "Med", "Mondello Park");
        insertData("Lawlors Hotel","+353 45 906 444", 53.219616, -6.660442, "Med", "Mondello Park");
        insertData("The Westgrove Hotel","+353 45 989 900", 53.289701, -6.681741, "Med", "Mondello Park");
        insertData("Glenroyal Hotel and Leisure Club","+353 1 629 0909", 53.380031, -6.588563, "Med", "Mondello Park");
        insertData("Osprey Hotel","+353 45 881 111", 53.213229, -6.670439, "High", "Mondello Park");
        insertData("Killashee Hotel","+353 45 879 277", 53.191238, -6.674828, "High", "Mondello Park");
        insertData("The Keadeen Hotel","+353 45 431 666", 53.169432, -6.813250, "High", "Mondello Park");
        insertData("Carton House Hotel","+353 1 505 2000", 53.378373, -6.554703, "High", "Mondello Park");
        insertData("Barberstown Castle","+353 1 628 8157", 53.322679, -6.610127, "High", "Mondello Park");
        insertData("Carton House Golf Club","+353 1 505 2000", 53.390088, -6.567708, "High", "Mondello Park");
        insertData("Cliff at Lyons","+353 1 630 3500", 53.306441, -6.541697, "High", "Mondello Park");
        insertData("The K Club","+353 1 601 7200", 53.306348, -6.625205, "High", "Mondello Park");
        insertData("Claremont House", "+353 1 280 5346", 53.282933, -6.126022, "Med", "Dun Laoghaire");
        insertData("Royal Marine Hotel", "+353 1 230 0030", 53.292183, -6.133689, "Med", "Dun Laoghaire");
        insertData("Ferry House Hotel", "+353 1 280 8301", 53.288997, -6.130101, "Med", "Dun Laoghaire");
        insertData("Mulgrave Lodge", "+353 1 280 1664", 53.289949, -6.137087, "Low", "Dun Laoghaire");
        insertData("Tara Hall Accomodation", "+353 1 280 5120", 53.285998, -6.116562, "Low", "Dun Laoghaire");
        insertData("Rochestown Lodge", "+353 1 285 3555", 53.269638, -6.141552, "Med", "Dun Laoghaire");
        insertData("Talbot Hotel Stillorgan", "+353 1 200 1800",53.294985, -6.203020, "Med", "Dun Laoghaire");
        insertData("Tara Towers", "+353 1 269 4666", 53.312408, -6.201849, "Med", "Dun Laoghaire");
        insertData("Fitzpatrick Castle Hotel", "+353 1 230 5400", 53.269597, -6.113356, "High", "Dun Laoghaire");
        insertData("Radisson Blu Dublin", "+353 1 218 6000", 53.304606, -6.206020, "High", "Dun Laoghaire");
        insertData("The Beacon Hotel", "+353 1 291 5000", 53.276291, -6.220629, "High", "Dun Laoghaire");
        insertData("Radisson Blue Cork", "+353 21 429 7000", 51.906362, -8.357155, "Med", "Watergrasshill");
        insertData("The Grand Hotel", "+353 25 40966", 52.138355, -8.275748, "Low", "Watergrasshill");
        insertData("Fota Island Resort", "+353 21 488 3700", 51.900422, -8.291834, "Med", "Watergrasshill");
        insertData("Fitzgeralds Vienna Woods Hotel and Holiday Homes", "+353 21 455 6800", 51.911762, -8.402957, "Low", "Watergrasshill");
        insertData("Ashley Hotel", "+353 21 450 1518", 51.901778, -8.470564, "Low", "Watergrasshill");
        insertData("Clayton Hotel Silver Springs", "+353 21 450 7533", 51.903993, -8.424103, "Med", "Watergrasshill");
        insertData("The Montenotte Hotel", "+353 21 453 0050", 51.904667, -8.452009, "High", "Watergrasshill");
        insertData("Jurys Inn Cork", "+353 21 494 3000", 51.899491, -8.463986, "Med", "Watergrasshill");
        insertData("The Metropole Hotel", "+353 21 464 3700", 51.901303, -8.467592, "Med", "Watergrasshill");
        insertData("Lancaster Lodge", "+353 21 425 1125", 51.896605, -8.482376, "Med", "Watergrasshill");
        insertData("Clayton Hotel Cork City", "+353 21 422 4900", 51.898567, -8.465002, "High", "Watergrasshill");
        insertData("Maldron Hotel Cork", "+353 21 452 9200", 51.902586, -8.474603, "Med", "Watergrasshill");
        insertData("Rochestown Park Hotel", "+353 21 489 0800", 51.879415, -8.424724, "Med", "Watergrasshill");
        insertData("Middleton Park Hotel", "+353 21 463 5100", 51.914947, -8.178708, "Low", "Watergrasshill");
        insertData("The River Lee", "+353 21 425 2700", 51.895918, -8.484813, "High", "Watergrasshill");
        insertData("Hotel Isaacs Cork", "+353 21 450 0011", 51.901687, -8.468098, "Med", "Watergrasshill");
        insertData("GN Commons Inn", "+353 21 421 0300", 51.921757, -8.487141, "Low", "Watergrasshill");
    }
*/
    public List<Hotel> getAllHotels() {
        List<Hotel> hotelsList = new ArrayList<Hotel>();
        // SELECT ALL query
        String selectQuery = "SELECT * FROM " + TABLE_HOTEL;

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

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_HOTEL);
        return numRows;
    }

}
