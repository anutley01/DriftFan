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
    //initialise the tables of the database
    public static final String TABLE_HOTEL_MONDELLO = "HotelMondello";
    public static final String TABLE_HOTEL_DUNLAOGHAIRE = "HotelDunLaoghaire";
    public static final String TABLE_HOTEL_WATERGRASSHILL = "HotelWatergrasshill";
    //create columns
    public static final String HOTEL_ID = "hotel_id";
    public static final String HOTEL_NAME = "hotel_name";
    public static final String PHONE = "phone";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String PRICE = "price";
    public static final String NEAR_TO = "NearTo";
    public static final String TABLE_RESTAURANTS_MONDELLO = "MondelloRestaurants";
    public static final String TABLE_RESTAURANTS_DUNLAOGHAIRE = "DunLaoghaireRestaurants";
    public static final String TABLE_RESTAURANTS_WATERGRASSHILL = "WatergrasshillRestaurants";
    public static final String RESTAURANT_ID = "restaurant_id";
    public static final String RESTAURANT_NAME = "restaurant_name";
    public static final String TABLE_CAR_QUIZ = "Cars";
    public static final String CAR_ID = "car_id";
    public static final String CAR_NAME = "car_name";
    public static final String INC_CAR_NAME_1 = "incorrect_car_name_one";
    public static final String INC_CAR_NAME_2 = "incorrect_car_name_two";
    public static final String INC_CAR_NAME_3 = "incorrect_car_name_three";
    public static final String CAR_IMAGE = "car_image";
    //define database version
    private static final String DATABASE_NAME = "DriftFan";
    private static final int DATABASE_VERSION = 38;

    public static final String CREATE_CAR_QUIZ = "CREATE TABLE IF NOT EXISTS " + TABLE_CAR_QUIZ + "("
            + CAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + CAR_NAME + " TEXT," +
            INC_CAR_NAME_1 + " TEXT," +
            INC_CAR_NAME_2 + " TEXT," +
            INC_CAR_NAME_3 + " TEXT," +
            CAR_IMAGE + " TEXT"+ ")";

        public static final String CREATE_RESTAURANT_MONDELLO = "CREATE TABLE IF NOT EXISTS " + TABLE_RESTAURANTS_MONDELLO + "("
                + RESTAURANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + RESTAURANT_NAME + " TEXT,"
                + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
                + LONGITUDE + " DOUBLE," +
                NEAR_TO + " TEXT " + ")";

    public static final String CREATE_RESTAURANT_DUNLAOGHAIRE = "CREATE TABLE IF NOT EXISTS " + TABLE_RESTAURANTS_DUNLAOGHAIRE + "("
            + RESTAURANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + RESTAURANT_NAME + " TEXT,"
            + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
            + LONGITUDE + " DOUBLE,"
            + NEAR_TO + " TEXT" + ")";

    public static final String CREATE_RESTAURANT_WATERGRASSHILL = "CREATE TABLE IF NOT EXISTS " + TABLE_RESTAURANTS_WATERGRASSHILL + "("
            + RESTAURANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + RESTAURANT_NAME + " TEXT,"
            + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
            + LONGITUDE + " DOUBLE,"
            + NEAR_TO + " TEXT" + ")";

    public static final String CREATE_HOTEL_MONDELLO = "CREATE TABLE IF NOT EXISTS " + TABLE_HOTEL_MONDELLO + "("
            + HOTEL_ID + " INTEGER PRIMARY KEY,"
            + HOTEL_NAME + " TEXT,"
            + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
            + LONGITUDE + " DOUBLE," + PRICE + " TEXT,"
            + NEAR_TO + " TEXT" + ")";
    public static final String CREATE_HOTEL_DUNLAOGHAIRE = "CREATE TABLE IF NOT EXISTS " + TABLE_HOTEL_DUNLAOGHAIRE + "("
            + HOTEL_ID + " INTEGER PRIMARY KEY,"
            + HOTEL_NAME + " TEXT,"
            + PHONE + " TEXT," + LATITUDE + " DOUBLE,"
            + LONGITUDE + " DOUBLE," + PRICE + " TEXT,"
            + NEAR_TO + " TEXT" + ")";
    public static final String CREATE_HOTEL_WATERGRASSHILL = "CREATE TABLE IF NOT EXISTS " + TABLE_HOTEL_WATERGRASSHILL + "("
            + HOTEL_ID + " INTEGER PRIMARY KEY,"
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANTS_MONDELLO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANTS_DUNLAOGHAIRE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANTS_WATERGRASSHILL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAR_QUIZ);
        db.execSQL(CREATE_HOTEL_MONDELLO);
        db.execSQL(CREATE_HOTEL_DUNLAOGHAIRE);
        db.execSQL(CREATE_HOTEL_WATERGRASSHILL);
        db.execSQL(CREATE_RESTAURANT_MONDELLO);
        db.execSQL(CREATE_RESTAURANT_DUNLAOGHAIRE);
        db.execSQL(CREATE_RESTAURANT_WATERGRASSHILL);
        db.execSQL(CREATE_CAR_QUIZ);
        db.execSQL(insertHotel(1,"Curragh BandB", "+35345456429", 53.124905, -6.789059, "A", "Mondello Park"));
        db.execSQL(insertHotel(2,"No. 5 Bed and Breakfast", "+353 85 110 0907", 53.130330, -6.755625, "A", "Mondello Park"));
        db.execSQL(insertHotel(3,"Maynooth Campus", "+353 1 708 6400", 53.379794, -6.595520, "A", "Mondello Park"));
        db.execSQL(insertHotel(4,"Tulloch", "+353 45 531 988", 53.171297, -6.973274, "A", "Mondello Park"));
        db.execSQL(insertHotel(5,"Kilcullen Home Stay", "+353 87 650 7195", 53.127930, -6.746819, "A", "Mondello Park"));
        db.execSQL(insertHotel(6,"Cherryville House B&B", "+353 45 521 091", 53.155753, -6.963233, "A", "Mondello Park"));
        db.execSQL(insertHotel(7,"Athgarvan B&B", "+353 45 405 950", 53.153120, -6.779494, "A", "Mondello Park"));
        db.execSQL(insertHotel(8,"Naas Court Hotel", "+353 45 866 073", 53.216508, -6.664741, "A", "Mondello Park"));
        db.execSQL(insertHotel(9,"Gardeners Cottage", "+353 86 817 4354", 53.371688, -6.715289, "A", "Mondello Park"));
        db.execSQL(insertHotel(10,"Bridge B&B", "+353 45 881 891", 53.214835, -6.678269, "A", "Mondello Park"));
        db.execSQL(insertHotel(11,"Lord Edward Accomodation", "+353 45 522 232", 53.156743, -6.908482, "A", "Mondello Park"));
        db.execSQL(insertHotel(12,"The rooms at Bardons", "+353 45 482 286", 53.131437, -6.744358, "A", "Mondello Park"));
        db.execSQL(insertHotel(13,"Maudlins House Hotel", "+353 45 896 999", 53.231528, -6.640108, "A", "Mondello Park"));
        db.execSQL(insertHotel(14,"Town House Hotel", "+353 45 879 226", 53.216150, -6.671831, "A", "Mondello Park"));
        db.execSQL(insertHotel(15,"Celbridge Manor Hotel", "+353 1 601 3700", 53.334804, -6.557413, "A", "Mondello Park"));
        db.execSQL(insertHotel(16,"Tulfarris Hotel and Golf Resort", "+353 45 867 600", 53.125023, -6.559921, "B", "Mondello Park"));
        db.execSQL(insertHotel(17,"Johnstown House Hotel and Spa", "+353 46 954 0000", 53.404895, -6.836575, "B", "Mondello Park"));
        db.execSQL(insertHotel(18,"Kildare House Hotel", "+353 45 520 002", 53.155650, -6.906958, "B", "Mondello Park"));
        db.execSQL(insertHotel(19,"Lawlors Hotel", "+353 45 906 444", 53.219616, -6.660442, "B", "Mondello Park"));
        db.execSQL(insertHotel(20,"The Westgrove Hotel", "+353 45 989 900", 53.289701, -6.681741, "B", "Mondello Park"));
        db.execSQL(insertHotel(21,"Glenroyal Hotel and Leisure Club", "+353 1 629 0909", 53.380031, -6.588563, "B", "Mondello Park"));
        db.execSQL(insertHotel(22,"Osprey Hotel", "+353 45 881 111", 53.213229, -6.670439, "C", "Mondello Park"));
        db.execSQL(insertHotel(23,"Killashee Hotel", "+353 45 879 277", 53.191238, -6.674828, "C", "Mondello Park"));
        db.execSQL(insertHotel(24,"The Keadeen Hotel", "+353 45 431 666", 53.169432, -6.813250, "C", "Mondello Park"));
        db.execSQL(insertHotel(25,"Carton House Hotel", "+353 1 505 2000", 53.378373, -6.554703, "C", "Mondello Park"));
        db.execSQL(insertHotel(26,"Barberstown Castle", "+353 1 628 8157", 53.322679, -6.610127, "C", "Mondello Park"));
        db.execSQL(insertHotel(27,"Carton House Golf Club", "+353 1 505 2000", 53.390088, -6.567708, "C", "Mondello Park"));
        db.execSQL(insertHotel(28,"Cliff at Lyons", "+353 1 630 3500", 53.306441, -6.541697, "C", "Mondello Park"));
        db.execSQL(insertHotel(29,"The K Club", "+353 1 601 7200", 53.306348, -6.625205, "C", "Mondello Park"));
        db.execSQL(insertHotel(30,"Claremont House", "+353 1 280 5346", 53.282933, -6.126022, "B", "Dun Laoghaire"));
        db.execSQL(insertHotel(31,"Royal Marine Hotel", "+353 1 230 0030", 53.292183, -6.133689, "B", "Dun Laoghaire"));
        db.execSQL(insertHotel(32,"Ferry House Hotel", "+353 1 280 8301", 53.288997, -6.130101, "B", "Dun Laoghaire"));
        db.execSQL(insertHotel(33,"Mulgrave Lodge", "+353 1 280 1664", 53.289949, -6.137087, "A", "Dun Laoghaire"));
        db.execSQL(insertHotel(34,"Tara Hall Accomodation", "+353 1 280 5120", 53.285998, -6.116562, "A", "Dun Laoghaire"));
        db.execSQL(insertHotel(35,"Talbot Hotel Stillorgan", "+353 1 200 1800", 53.294985, -6.203020, "B", "Dun Laoghaire"));
        db.execSQL(insertHotel(36,"Tara Towers", "+353 1 269 4666", 53.312408, -6.201849, "B", "Dun Laoghaire"));
        db.execSQL(insertHotel(37,"Fitzpatrick Castle Hotel", "+353 1 230 5400", 53.269597, -6.113356, "C", "Dun Laoghaire"));
        db.execSQL(insertHotel(38,"Radisson Blu Dublin", "+353 1 218 6000", 53.304606, -6.206020, "C", "Dun Laoghaire"));
        db.execSQL(insertHotel(39,"The Beacon Hotel", "+353 1 291 5000", 53.276291, -6.220629, "C", "Dun Laoghaire"));
        db.execSQL(insertHotel(40,"Radisson Blue Cork", "+353 21 429 7000", 51.906362, -8.357155, "B", "Watergrasshill"));
        db.execSQL(insertHotel(41,"The Grand Hotel", "+353 25 40966", 52.138355, -8.275748, "A", "Watergrasshill"));
        db.execSQL(insertHotel(42,"Fota Island Resort", "+353 21 488 3700", 51.900422, -8.291834, "B", "Watergrasshill"));
        db.execSQL(insertHotel(43,"Fitzgeralds Vienna Woods Hotel and Holiday Homes", "+353 21 455 6800", 51.911762, -8.402957, "A", "Watergrasshill"));
        db.execSQL(insertHotel(44,"Ashley Hotel", "+353 21 450 1518", 51.901778, -8.470564, "A", "Watergrasshill"));
        db.execSQL(insertHotel(45,"Clayton Hotel Silver Springs", "+353 21 450 7533", 51.903993, -8.424103, "B", "Watergrasshill"));
        db.execSQL(insertHotel(46,"The Montenotte Hotel", "+353 21 453 0050", 51.904667, -8.452009, "C", "Watergrasshill"));
        db.execSQL(insertHotel(47,"Jurys Inn Cork", "+353 21 494 3000", 51.899491, -8.463986, "B", "Watergrasshill"));
        db.execSQL(insertHotel(48,"The Metropole Hotel", "+353 21 464 3700", 51.901303, -8.467592, "B", "Watergrasshill"));
        db.execSQL(insertHotel(49,"Lancaster Lodge", "+353 21 425 1125", 51.896605, -8.482376, "B", "Watergrasshill"));
        db.execSQL(insertHotel(50,"Clayton Hotel Cork City", "+353 21 422 4900", 51.898567, -8.465002, "C", "Watergrasshill"));
        db.execSQL(insertHotel(51,"Maldron Hotel Cork", "+353 21 452 9200", 51.902586, -8.474603, "B", "Watergrasshill"));
        db.execSQL(insertHotel(52,"Rochestown Park Hotel", "+353 21 489 0800", 51.879415, -8.424724, "B", "Watergrasshill"));
        db.execSQL(insertHotel(53,"Middleton Park Hotel", "+353 21 463 5100", 51.914947, -8.178708, "A", "Watergrasshill"));
        db.execSQL(insertHotel(54,"The River Lee", "+353 21 425 2700", 51.895918, -8.484813, "C", "Watergrasshill"));
        db.execSQL(insertHotel(55,"Hotel Isaacs Cork", "+353 21 450 0011", 51.901687, -8.468098, "B", "Watergrasshill"));
        db.execSQL(insertHotel(56,"GN Commons Inn", "+353 21 421 0300", 51.921757, -8.487141, "A", "Watergrasshill"));
        db.execSQL(insertRestaurant(1,"Chapter 16", "+353 45 522 232", 53.156602, -6.908979, "Mondello Park"));
        db.execSQL(insertRestaurant(2,"Hartes Bar & Grill Kildare Town", "+353 45 533 557", 53.157268, -6.911119, "Mondello Park"));
        db.execSQL(insertRestaurant(3,"Silken Thomas", "+353 45 522 232", 53.156864, -6.909572, "Mondello Park"));
        db.execSQL(insertRestaurant(4,"Apache Pizza Kildare", "+353 45 535 220", 53.156527, -6.909817, "Mondello Park"));
        db.execSQL(insertRestaurant(5,"Agapé Gourmet Sandwich Bar", "+353 45 533 711", 53.157617, -6.909968, "Mondello Park"));
        db.execSQL(insertRestaurant(6,"Victoria House Asian Cuisine", "+353 45 533 119", 53.157491, -6.910092, "Mondello Park"));
        db.execSQL(insertRestaurant(7,"Macaris king chicken", "+353 45 520 340", 53.157128, -6.911644, "Mondello Park"));
        db.execSQL(insertRestaurant(8,"Sitaaray Indian Restaurant", "+353 45 530 768", 53.157486, -6.910618, "Mondello Park"));
        db.execSQL(insertRestaurant(9,"Macaris Cafe, The Square", "+353 45 520 034", 53.157146, -6.910288, "Mondello Park"));
        db.execSQL(insertRestaurant(10,"Bistro Le Monde", "+353 1 551 2656", 53.294927, -6.135456, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(11,"Gourmet Food Parlour Dun Laoghaire", "+353 1 280 5670", 53.294969, -6.135754, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(12,"Shakira Indian Cuisine", "+353 1 280 0923", 53.293137, -6.138341, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(13,"Delhi Rasoi Indian Restaurant", "+353 1 908 1531", 53.294983, -6.143356, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(14,"Bits & Pizzas Restaurant", "+353 1 284 2411", 53.291614, -6.137271, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(15,"Miami Cafe", "+353 1 280 6067", 53.292909, -6.137802, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(16,"Hartleys", "+353 1 280 6767", 53.294723, -6.133885, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(17,"Harrys Cafe Bar", "+353 1 280 8337", 53.291675, -6.134749, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(18,"Mao Dun Laoghaire", "+353 1 214 8090", 53.293977, -6.133056, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(19,"Oliveto at the Haddington Hotel", "+353 1 280 0011", 53.292071, -6.130565, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(20,"Toscana Restaurant", "+353 1 230 0890", 53.290244, -6.127183, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(21,"Rasam Restaurant", "+353 1 230 0600", 53.286920, -6.123195, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(22,"Yungs Restaurant", " +353 1 284 2156", 53.289538, -6.129684, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(23,"Michie Sushi", "+353 1 538 9990", 53.289733, -6.129763, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(24,"Bistro 73", "+353 1 284 4573", 53.290051, -6.130662, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(25,"The Forty Foot", "+353 1 231 1926", 53.293901, -6.133607, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(26,"Kyoto Asian Street Food", "+353 1 537 7718", 53.291805, -6.137069, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(27,"8a Brasserie", "+353 1 284 3309", 53.294051, -6.152708, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(28,"Fallon & Byrne", "+353 1 230 3300", 53.289390, -6.129052, "Dun Laoghaire"));
        db.execSQL(insertRestaurant(29,"The Fir Tree Bar", "+353 21 451 3090", 52.011631, -8.343767, "Watergrasshill"));
        db.execSQL(insertRestaurant(30,"Johnnys Restaurant and Takeaway", "+353 21 488 9222", 52.011320, -8.344408, "Watergrasshill"));
        db.execSQL(insertRestaurant(31,"Tir Na Si", "+353 21 488 9431", 52.029127, -8.347472, "Watergrasshill"));
        db.execSQL(insertRestaurant(32,"The Brook Inn", "+353 21 482 1498", 51.938394, -8.398894, "Watergrasshill"));
        db.execSQL(insertRestaurant(33,"Cafe Beva", "+353 21 485 8002", 51.930322, -8.396789, "Watergrasshill"));
        db.execSQL(insertRestaurant(34,"The Elm Tree Glounthaune", "+353 21 435 1024", 51.911975, -8.304396, "Watergrasshill"));
        db.execSQL(insertRestaurant(35,"The Barn Restaurant", "+353 21 486 6211", 51.918991, -8.417639, "Watergrasshill"));
        db.execSQL(insertRestaurant(36,"The Castle Cafe", "+353 21 435 7911", 51.899850, -8.402570, "Watergrasshill"));
        db.execSQL(insertRestaurant(37,"Greenes Restaurant", "+353 21 455 2279", 51.901675, -8.468035, "Watergrasshill"));
        db.execSQL(insertRestaurant(38,"Pier Head Chinese Restaurant", "+353 21 461 4040", 51.897375, -8.412572, "Watergrasshill"));
        db.execSQL(insertRestaurant(39,"The Watermarq Restaurant", "+353 21 450 7533", 51.904049, -8.423467, "Watergrasshill"));
        db.execSQL(insertRestaurant(40,"Mr. Dee Chinese Restaurant", "+353 21 482 3280", 51.928771, -8.388779, "Watergrasshill"));
        db.execSQL(insertRestaurant(41,"Island Gate Restaurant and Bar", "+353 21 435 3951", 51.907600, -8.364202, "Watergrasshill"));
        db.execSQL(insertRestaurant(42,"Soba Asian Street Food, Glanmire", "+353 21 482 2737", 51.930674, -8.397485, "Watergrasshill"));
        db.execSQL(insertRestaurant(43,"Village Inn", "+353 21 451 8238", 51.914080, -8.428717, "Watergrasshill"));
        db.execSQL(insertCar(1, "Nissan 180sx", "Nissan Silvia s15", "Nissan 350z", "Toyota G86", "@drawable/nissan_180sx"));
        db.execSQL(insertCar(2, "Nissan Silvia s14", "Nissan Silvia S15", "Toyota Soarer", "Honda Civic", "@drawable/nissan_silvia_s14"));
        db.execSQL(insertCar(3, "Nissan Silvia s15", "BMW M3", "Mazda RX-7", "Toyota G86", "@drawable/nissan_silvia_s15"));
        db.execSQL(insertCar(4, "Nissan 350Z", "Nissan Skyline R33", "Mercedes C63 AMG", "Chevy Lumina", "@drawable/nissan_350z"));
        db.execSQL(insertCar(5,"Nissan Skyline R33", "Mercedes C63 AMG", "Nissan 350z", "Toyota Supra", "@drawable/nissan_skyline_r33"));
        db.execSQL(insertCar(6, "Toyota GT86", "Toyota Supra", "Toyota AE86", "BMW M3", "@drawable/toyota_gt86"));
        db.execSQL(insertCar(7, "Toyota Supra", "Mazda MX-5", "Mazda RX-7", "Toyota Chaser", "@drawable/toyota_supra"));
        db.execSQL(insertCar(8, "Toyota Ae86", "BMW M3", "Nissan 180sx", "Nissan Silvia s14", "@drawable/toyota_ae86"));
        db.execSQL(insertCar(9, "Toyota CHASER", "Toyota Altezza", "Nissan 350z", "Nissan Skyline R33", "@drawable/toyota_chaser"));
        db.execSQL(insertCar(10, "Toyota Soarer", "BMW X5", "Mazda MX-5", "Toyota Supra", "@drawable/toyota_soarer"));
        db.execSQL(insertCar(11, "BMW m3", "Mazda MX-5", "Nissan Skyline R33", "Nissan 180sx", "@drawable/bmw_m3"));
        db.execSQL(insertCar(12, "Mazda MX-5", "Mazda RX-7", "Toyota G86", "Toyota Altezza/Lexus IS200", "@drawable/mazda_mx5"));
        db.execSQL(insertCar(13, "Mazda RX-7", "Toyota Supra", "Toyota AE86", "Honda Civic", "@drawable/mazda_rx7"));
        db.execSQL(insertCar(14, "Toyota Altezza/Lexus IS200", "Toyota Supra", "Nissan Silvia s15", "Nissan Silvia s14", "@drawable/toyota_altezza"));
    }
    public String insertHotel(int hotelId, String hotel_name, String phone, double latitude, double longitude, String price, String near_to) {
        if (near_to.equals("Mondello Park")){
            String insertBuilding = "INSERT INTO " + TABLE_HOTEL_MONDELLO +
                    "(" + HOTEL_ID  + ","+ HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                    + ") VALUES (" + hotelId + ",'"
                    + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
            return insertBuilding;
        } else if (near_to.equals("Dun Laoghaire")) {
            String insertBuilding = "INSERT INTO " + TABLE_HOTEL_DUNLAOGHAIRE +
                    "(" + HOTEL_ID + "," + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                    + ") VALUES (" + hotelId + ",'"
                    + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
            return insertBuilding;
        } else if (near_to.equals("Watergrasshill")){
            String insertBuilding = "INSERT INTO " + TABLE_HOTEL_WATERGRASSHILL +
                    "(" + HOTEL_ID + "," + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                    + ") VALUES (" + hotelId + ",'"
                    + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
            return insertBuilding;

        } else {
            return null;
        }
    }

    public String insertCar(int id, String car_name, String inc_carname1, String inc_carname2, String inc_carname3, String car_image){
        String insertCar = "INSERT INTO " + TABLE_CAR_QUIZ +
                "(" + CAR_ID + "," + CAR_NAME + "," + INC_CAR_NAME_1 + "," + INC_CAR_NAME_2 + "," + INC_CAR_NAME_3 + "," + CAR_IMAGE +
        ") VALUES (" + id + ",'"
                + car_name + "','" + inc_carname1 + "', '" + inc_carname2 + "','" + inc_carname3 + "','" + car_image + "')";
        return insertCar;
    }
   /* public String insertHotelDunLaoghaire(int hotelId,String hotel_name, String phone, double latitude, double longitude, String price, String near_to) {
        String insertBuilding = "INSERT INTO " + TABLE_HOTEL_DUNLAOGHAIRE +
                "(" + HOTEL_ID + "," + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                + ") VALUES (" + hotelId + ",'"
                + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
        return insertBuilding;
    }

    public String insertHotelWatergrasshill(int hotelId, String hotel_name, String phone, double latitude, double longitude, String price, String near_to) {
        String insertBuilding = "INSERT INTO " + TABLE_HOTEL_WATERGRASSHILL +
                "(" + HOTEL_ID + "," + HOTEL_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + PRICE + "," + NEAR_TO
                + ") VALUES (" + hotelId + ",'"
                + hotel_name + "','" + phone + "', '" + latitude + "','" + longitude + "','" + price + "','" + near_to + "')";
        return insertBuilding;
    }*/

    public String insertRestaurant(int restaurant_id, String restaurant_name, String phone, double latitude, double longitude, String near_to) {
        if(near_to.equals("Mondello Park")) {
            String insertBuilding = "INSERT INTO " + TABLE_RESTAURANTS_MONDELLO +
                    "(" + RESTAURANT_ID + "," + RESTAURANT_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + NEAR_TO + ") VALUES (" + restaurant_id + ",'"
                    + restaurant_name + "','" + phone + "', " + latitude + "," + longitude + ",'" + near_to + "')";
            return insertBuilding;
        } else if (near_to.equals("Dun Laoghaire")){
            String insertBuilding = "INSERT INTO " + TABLE_RESTAURANTS_DUNLAOGHAIRE +
                    "(" + RESTAURANT_ID + "," + RESTAURANT_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + NEAR_TO + ") VALUES (" + restaurant_id + ",'"
                    + restaurant_name + "','" + phone + "', " + latitude + "," + longitude + ", '" + near_to + "'" + ")";
            return insertBuilding;
        } else if (near_to.equals("Watergrasshill")){
            String insertBuilding = "INSERT INTO " + TABLE_RESTAURANTS_WATERGRASSHILL +
                    "(" + RESTAURANT_ID + "," + RESTAURANT_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + NEAR_TO + ") VALUES (" + restaurant_id + ",'"
                    + restaurant_name + "','" + phone + "', " + latitude + "," + longitude + ", '" + near_to + "')";
            return insertBuilding;
        } else {
            return null;
        }
    }

   /* public String insertRestaurantDunLaoghaire(int restaurant_id, String restaurant_name, String phone, double latitude, double longitude, String near_to) {
        String insertBuilding = "INSERT INTO " + TABLE_RESTAURANTS_DUNLAOGHAIRE +
                "(" + RESTAURANT_ID + "," + RESTAURANT_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + NEAR_TO + ") VALUES (" + restaurant_id + ",'"
                + restaurant_name + "','" + phone + "', " + latitude + "," + longitude + ", '" + near_to + "'" + ")";
        return insertBuilding;
    }


    public String insertRestaurantWatergrasshill(int restaurant_id, String restaurant_name, String phone, double latitude, double longitude, String near_to) {
        String insertBuilding = "INSERT INTO " + TABLE_RESTAURANTS_WATERGRASSHILL +
                "(" + RESTAURANT_ID + "," + RESTAURANT_NAME + "," + PHONE + "," + LATITUDE + "," + LONGITUDE + "," + NEAR_TO + ") VALUES (" + restaurant_id + ",'"
                + restaurant_name + "','" + phone + "', " + latitude + "," + longitude + ", '" + near_to + "')";
        return insertBuilding;
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //adds the statement to log
        Log.w(SQLHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL_MONDELLO);
        onCreate(db);//create a database
    }
    //returns list of hotels based upon parameter argument
    public List<Hotel> getAllHotels(String hotelsToPull) {
        String selectQuery;
        if (hotelsToPull.equals("Mondello Park")){
          selectQuery = "SELECT * FROM " + TABLE_HOTEL_MONDELLO + " ORDER BY " + PRICE;
        } else if (hotelsToPull.equals("Dun Laoghaire")){
            selectQuery = "SELECT * FROM " + TABLE_HOTEL_DUNLAOGHAIRE + " ORDER BY " + PRICE;
        } else if (hotelsToPull.equals("Watergrasshill")){
            selectQuery = "SELECT * FROM " + TABLE_HOTEL_WATERGRASSHILL + " ORDER BY " + PRICE;
        } else {
            selectQuery = "none";
        }
        List<Hotel> hotelsList = new ArrayList<Hotel>();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                Hotel hotel = new Hotel();
                hotel.setId(Integer.parseInt(cursor.getString(0)));
                hotel.setName(cursor.getString(1));
                hotel.setPhone(cursor.getString(2));
                hotel.setLatitude(Double.parseDouble(cursor.getString(3)));
                hotel.setLongitude(Double.parseDouble(cursor.getString(4)));
                hotel.setPrice(cursor.getString(5));
                hotel.setNearTo(cursor.getString(6));
                // add hotel to list
                hotelsList.add(hotel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // Return hotel list
        return hotelsList;
    }


    public List<Car> getAllCars() {
        List<Car> CarList = new ArrayList<Car>();
        // SELECT ALL query
        String selectQuery = "SELECT * FROM " + TABLE_CAR_QUIZ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                Car car = new Car();
                car.setCarID(Integer.parseInt(cursor.getString(0)));
                car.setCarName(cursor.getString(1));
                car.setIncorrectCarName1(cursor.getString(2));
                car.setIncorrectCarName2(cursor.getString(3));
                car.setIncorrectCarName3(cursor.getString(4));
                car.setCarImage(cursor.getString(5));
                // Add car to list
                CarList.add(car);
            } while (cursor.moveToNext());
        }
        cursor.close();
        //return car list
        return CarList;
    }

    public List<Hotel> getAllRestaurants(String restaurantsToPull) {
        String selectQuery;
        List<Hotel> hotelsList = new ArrayList<Hotel>();
        //decide which statement to execute based upon parameter args
        if(restaurantsToPull.equals("Mondello Park")) {
            selectQuery = "SELECT * FROM " + TABLE_RESTAURANTS_MONDELLO;
        } else if (restaurantsToPull.equals("Dun Laoghaire")) {
            selectQuery = "SELECT * FROM " + TABLE_RESTAURANTS_DUNLAOGHAIRE;
        }else if (restaurantsToPull.equals("Watergrasshill")){
            selectQuery = "SELECT * FROM "+ TABLE_RESTAURANTS_WATERGRASSHILL;
        } else {
            selectQuery = "none";
        }
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add them to the list
        if (cursor.moveToFirst()) {
            do {
                Hotel restaurant = new Hotel();
                restaurant.setId(Integer.parseInt(cursor.getString(0)));
                restaurant.setName(cursor.getString(1));
                restaurant.setPhone(cursor.getString(2));
                restaurant.setLatitude(Double.parseDouble(cursor.getString(3)));
                restaurant.setLongitude(Double.parseDouble(cursor.getString(4)));
                restaurant.setNearTo(cursor.getString(5));
                // Add restaurants to list
                hotelsList.add(restaurant);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // Return a list restaurants
        return hotelsList;
    }

}