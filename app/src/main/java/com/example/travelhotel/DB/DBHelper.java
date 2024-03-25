package com.example.travelhotel.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Hotels.db";

    public DBHelper(Context context){
        super(context, DBNAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // customers
        String createCustomersTable = "create Table customers(id_customer integer primary key autoincrement," +
                "username_customer text," +
                "password_custommer text," +
                "name_customer text," +
                "phone_customer text," +
                "address_customer text)";
        db.execSQL(createCustomersTable);

        // hotels
        String createHotelsTable = "create table hotels(id_hotel integer primary key autoincrement," +
                "username_hotel text," +
                "password_hotel text," +
                "name_hotel" +
                "phone_hotel text," +
                "address_hotel text)";
        db.execSQL(createHotelsTable);

        //bookings
        String creatBookingsTable = "create table bookings(id_booking integer primary key autoincrement," +
                "id_customer integer," +
                "id_hotel integer," +
                "booking_date text," +
                "checkin_date text," +
                "room_count text," +
                "note text," +
                "foreign key (id_customer) references customer (id_customer)," +
                "foreign key (id_hotel) references hotel (id_hotel))";
        db.execSQL(creatBookingsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists customers");
        db.execSQL("drop table if exists hotels");
        db.execSQL("drop table if exists bookings");

        onCreate(db);
    }

    public boolean checkInserCustomer(String username, String password, String name, String phone, String address){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_customer", username);
        contentValues.put("password_customer", password);
        contentValues.put("name_customer", name);
        contentValues.put("phone_customer", phone);
        contentValues.put("address_customer", address);
        long result = db.insert("customers", null, contentValues);

        return result != -1;

    }

    public boolean checkInserHotel(String username, String password, String name, String phone, String address){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_hotel", username);
        contentValues.put("password_hotel", password);
        contentValues.put("name_hotel", name);
        contentValues.put("phone_hotel", phone);
        contentValues.put("address_hotel", address);
        long result = db.insert("hotels", null, contentValues);

        return  result != -1;

    }


    // check insert
    public boolean checkInsertBooking(int customerId, int hotelId, String bookingDate, String checkinDate, String roomCount, String note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id_customer", customerId);
        contentValues.put("id_hotel", hotelId);
        contentValues.put("booking_date", bookingDate);
        contentValues.put("checkin_date", checkinDate);
        contentValues.put("room_count", roomCount);
        contentValues.put("note", note);

        long result = db.insert("bookings", null, contentValues);

        return result != -1;
    }

    // check usrename
    public boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCustomer = db.rawQuery("select * from customers where username_customer = ?", new String[]{username});
        Cursor cursorHotel = db.rawQuery("select * from hotels where username_hotel = ?", new String[]{username});
        if(cursorCustomer.getCount() > 0 || cursorHotel.getCount() > 0)
            return true;
        else
            return false;

    }


    // checklogin
    public boolean checkLogin (String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCustomer = db.rawQuery("select * from customers where username_customer = ? and password_customer = ?", new String[]{username, password});
        Cursor cursorHotel = db.rawQuery("select * from hotels where username_hotel = ? and password_hotel = ?", new String[]{username, password});
        if(cursorCustomer.getCount() > 0 || cursorHotel.getCount() > 0) return true;
        else return false;
    }

}
