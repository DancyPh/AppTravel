package com.example.travelhotel.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Bookings.db";

    public DBHelper(Context context){
        super(context, DBNAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // customers
        String createCustomersTable = "create Table customers(id_customer integer primary key autoincrement," +
                "username_customer text," +
                "password_customer text," +
                "name_customer text," +
                "phone_customer text," +
                "address_customer text)";
        db.execSQL(createCustomersTable);

        // hotels
        String createHotelsTable = "create table hotels(id_hotel integer primary key autoincrement," +
                "username_hotel text," +
                "password_hotel text," +
                "name_hotel," +
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
        // Xóa bảng cũ nếu tồn tại
        db.execSQL("DROP TABLE IF EXISTS customers");
        db.execSQL("DROP TABLE IF EXISTS hotels");
        db.execSQL("DROP TABLE IF EXISTS bookings");

        // Tạo lại các bảng với cấu trúc mới
        onCreate(db);
    }


    public boolean checkInserCustomer(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("username_customer", username);
            contentValues.put("password_customer", password);

            long result = db.insert("customers", null, contentValues);
            return (result != -1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }
    }


    public boolean checkInserHotel(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username_hotel", username);
        contentValues.put("password_hotel", password);
        long result = db.insert("hotels", null, contentValues);
        if (result == -1){
            return false;
        }
        return true;

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

        if (result == -1){
            return false;
        }
        return true;
    }

    // check usrename
    public boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCustomer = db.rawQuery("select * from customers where username_customer = ?", new String[]{username});
        Cursor cursorHotel = db.rawQuery("select * from hotels where username_hotel = ?", new String[]{username});
        if(cursorCustomer.getCount() > 0 || cursorHotel.getCount() > 0)
            return false;
        else
            return true;

    }


    // checklogin
    public boolean checkLogin (String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCustomer = db.rawQuery("select * from customers where username_customer = ? and password_customer = ?", new String[]{username, password});
        Cursor cursorHotel = db.rawQuery("select * from hotels where username_hotel = ? and password_hotel = ?", new String[]{username, password});
        if(cursorCustomer.getCount() > 0 || cursorHotel.getCount() > 0) return true;
        else return false;
    }

    // get customer
    public Customers getCustomer(String user, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        Customers customer = null;
        Cursor cursor = db.query("customers", new String[]{"username_customer", "password_customer", "name_customer", "phone_customer", "address_customer"},
                "username_customer = ? and password_customer = ?",new String[]{user, pass}, null, null, null);
        if (cursor != null && cursor.moveToFirst()){
            int nameIndex = cursor.getColumnIndex("name_customer");
            int phoneIndex = cursor.getColumnIndex("phone_customer");
            int addressIndex = cursor.getColumnIndex("address_customer");

            if (nameIndex != -1 && phoneIndex != -1 && addressIndex != -1) {
                String name = cursor.getString(nameIndex);
                String phone = cursor.getString(phoneIndex);
                String address = cursor.getString(addressIndex);

                customer = new Customers(user, pass, name, phone, address);
            }

            cursor.close();
        }
        return customer;
    }


    // get hotel
    public Hotels getHotel(String user, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        Hotels hotel = null;
        Cursor cursor = db.query("hotels", new String[]{"username_hotel", "password_hotel", "name_hotel", "phone_hotel", "address_hotel"},
                "username_hotel = ? and password_hotel = ?", new String[]{user, pass}, null, null, null);
        if (cursor != null & cursor.moveToFirst()){
            int nameIndex = cursor.getColumnIndex("name_hotel");
            int phoneIndex = cursor.getColumnIndex("phone_hotel");
            int addressIndex = cursor.getColumnIndex("address_hotel");

            if (nameIndex != -1 && phoneIndex != -1 && addressIndex != -1){
                String name = cursor.getString(nameIndex);
                String phone = cursor.getString(phoneIndex);
                String address = cursor.getString(addressIndex);

                hotel = new Hotels(user, pass, name, phone, address);
            }
            cursor.close();
        }
        return hotel;
    }
}
