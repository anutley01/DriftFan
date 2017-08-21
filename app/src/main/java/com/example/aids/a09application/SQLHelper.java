package com.example.aids.a09application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
    public static final String NEAR_TO = "near to";
    public static final String COLUMN_COMMENT = "comment";

    private static final String DATABASE_NAME = "commments.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    //please remove the spaces in the code and see the results
    private static final String DATABASE_CREATE = "create table "
            + TABLE_HOTEL + "( " + HOTEL_ID
            + " integer primary key autoincrement, "
            + HOTEL_NAME + "text"
            + PHONE + " text," +
            LATITUDE + " text,"+
            LONGITUDE + " text,"+
            PRICE + " text,"
            + NEAR_TO + "text"
            + COLUMN_COMMENT
            + " text not null);";

    public SQLHelper(Context context) {
        //please change 'context' to 'this' and see the result
        super(context, DATABASE_NAME, null, DATABASE_VERSION);//super class of creating database
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);//execute the table to create statements on the database
    }

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

    public boolean addData(String hotelName, String hotelPhone, String latitude, String longitude, String price, String near_to){
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

    }

    public void createHotels(){
        addData("Curragh B&B","+353 45 456 429", "53.124905","-6.789059", "Low", "Mondello Park");
        addData("No. 5 Bed and Breakfast", "+353 1 708 6400", "53.130330", "-6.755625", "Low", "Mondello Park");
        addData("Maynooth Campus", "+353 85 110 0907", "53.379794", "-6.595520", "Low", "Mondello Park");
        addData("Tulloch","+353 45 531 988", "53.171297", "-6.973274", "Low", "Mondello Park");
        addData("Kilcullen Home Stay","+353 87 650 7195", "53.127930", "-6.746819", "Low", "Mondello Park");
        addData("Cherryville House B&B","+353 45 521 091", "53.155753","-6.963233", "Low", "Mondello Park");
        addData("Athgarvan B&B","+353 45 405 950", "53.153120", "-6.779494", "Low", "Mondello Park");
        addData("Naas Court Hotel","+353 45 866 073", "53.216508", "-6.664741", "Low", "Mondello Park");
        addData("Gardeners Cottage","+353 86 817 4354", "53.371688", "-6.715289", "Low", "Mondello Park");
        addData("Bridge B&B","+353 45 881 891", "53.214835", "-6.678269", "Low", "Mondello Park");
        addData("Lord Edward Accomodation","+353 45 522 232", "53.156743", "-6.908482", "Low", "Mondello Park");
        addData("The rooms at Bardons","+353 45 482 286", "53.131437", "-6.744358", "Low", "Mondello Park");
        addData("Maudlins House Hotel","+353 45 896 999", "53.231528", "-6.640108", "Low", "Mondello Park");
        addData("Town House Hotel","+353 45 879 226", "53.216150", "-6.671831", "Low", "Mondello Park");
        addData("Celbridge Manor Hotel","+353 1 601 3700", "53.334804", "-6.557413", "Low", "Mondello Park");
        addData("Tulfarris Hotel and Golf Resort","+353 45 867 600", "53.125023", "-6.559921", "Med", "Mondello Park");
        addData("Johnstown House Hotel and Spa","+353 46 954 0000", "53.404895", "-6.836575", "Med", "Mondello Park");
        addData("Kildare House Hotel","+353 45 520 002", "53.155650", "-6.906958", "Med", "Mondello Park");
        addData("Lawlors Hotel","+353 45 906 444", "53.219616", "-6.660442", "Med", "Mondello Park");
        addData("The Westgrove Hotel","+353 45 989 900", "53.289701", "-6.681741", "Med", "Mondello Park");
        addData("Glenroyal Hotel and Leisure Club","+353 1 629 0909", "53.380031", "-6.588563", "Med", "Mondello Park");
        addData("Osprey Hotel","+353 45 881 111", "53.213229", "-6.670439", "High", "Mondello Park");
        addData("Killashee Hotel","+353 45 879 277", "53.191238", "-6.674828", "High", "Mondello Park");
        addData("The Keadeen Hotel","+353 45 431 666", "53.169432", "-6.813250", "High", "Mondello Park");
        addData("Carton House Hotel","+353 1 505 2000", "53.378373", "-6.554703", "High", "Mondello Park");
        addData("Barberstown Castle","+353 1 628 8157", "53.322679", "-6.610127", "High", "Mondello Park");
        addData("Carton House Golf Club","+353 1 505 2000", "53.390088", "-6.567708", "High", "Mondello Park");
        addData("Cliff at Lyons","+353 1 630 3500", "53.306441", "-6.541697", "High", "Mondello Park");
        addData("The K Club","+353 1 601 7200", "53.306348", "-6.625205", "High", "Mondello Park");
        addData("Claremont House", "+353 1 280 5346", "53.282933", "-6.126022", "Med", "Dun Laoghaire");
        addData("Royal Marine Hotel", "+353 1 230 0030", "53.292183", "-6.133689", "Med", "Dun Laoghaire");
        addData("Ferry House Hotel", "+353 1 280 8301", "53.288997", "-6.130101", "Med", "Dun Laoghaire");
        addData("Mulgrave Lodge", "+353 1 280 1664", "53.289949", "-6.137087", "Low", "Dun Laoghaire");
        addData("Tara Hall Accomodation", "+353 1 280 5120", "53.285998", "-6.116562", "Low", "Dun Laoghaire");
        addData("Rochestown Lodge", "+353 1 285 3555", "53.269638", "-6.141552", "Med", "Dun Laoghaire");
        addData("Talbot Hotel Stillorgan", "+353 1 200 1800","53.294985", "-6.203020", "Med", "Dun Laoghaire");
        addData("Tara Towers", "+353 1 269 4666", "53.312408", "-6.201849", "Med", "Dun Laoghaire");
        addData("Fitzpatrick Castle Hotel", "+353 1 230 5400", "53.269597", "-6.113356", "High", "Dun Laoghaire");
        addData("Radisson Blu Dublin", "+353 1 218 6000", "53.304606", "-6.206020", "High", "Dun Laoghaire");
        addData("The Beacon Hotel", "+353 1 291 5000", "53.276291", "-6.220629", "High", "Dun Laoghaire");
        addData("Radisson Blue Cork", "+353 21 429 7000", "51.906362", "-8.357155", "Med", "Watergrasshill");
        addData("The Grand Hotel", "+353 25 40966", "52.138355", "-8.275748", "Low", "Watergrasshill");
        addData("Fota Island Resort", "+353 21 488 3700", "51.900422", "-8.291834", "Med", "Watergrasshill");
        addData("Fitzgeralds Vienna Woods Hotel and Holiday Homes", "+353 21 455 6800", "51.911762", "-8.402957", "Low", "Watergrasshill");
        addData("Ashley Hotel", "+353 21 450 1518", "51.901778", "-8.470564", "Low", "Watergrasshill");
        addData("Clayton Hotel Silver Springs", "+353 21 450 7533", "51.903993", "-8.424103", "Med", "Watergrasshill");
        addData("The Montenotte Hotel", "+353 21 453 0050", "51.904667", "-8.452009", "High", "Watergrasshill");
        addData("Jurys Inn Cork", "+353 21 494 3000", "51.899491", "-8.463986", "Med", "Watergrasshill");
        addData("The Metropole Hotel", "+353 21 464 3700", "51.901303", "-8.467592", "Med", "Watergrasshill");
        addData("Lancaster Lodge", "+353 21 425 1125", "51.896605", "-8.482376", "Med", "Watergrasshill");
        addData("Clayton Hotel Cork City", "+353 21 422 4900", "51.898567", "-8.465002", "High", "Watergrasshill");
        addData("Maldron Hotel Cork", "+353 21 452 9200", "51.902586", "-8.474603", "Med", "Watergrasshill");
        addData("Rochestown Park Hotel", "+353 21 489 0800", "51.879415", "-8.424724", "Med", "Watergrasshill");
        addData("Middleton Park Hotel", "+353 21 463 5100", "51.914947", "-8.178708", "Low", "Watergrasshill");
        addData("The River Lee", "+353 21 425 2700", "51.895918", "-8.484813", "High", "Watergrasshill");
        addData("Hotel Isaacs Cork", "+353 21 450 0011", "51.901687", "-8.468098", "Med", "Watergrasshill");
        addData("GN Commons Inn", "+353 21 421 0300", "51.921757", "-8.487141", "Low", "Watergrasshill");
    }

    public Cursor getAllData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_HOTEL, null);
        return res;
    }

}
