package com.example.travelhotel.DB;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotels implements Parcelable {

    private int id_hotel;
    private String username_hotel;
    private String password_hotel;
    private String name_hotel;
    private String phone_hotel;
    private String address_hotel;

    public Hotels(int id_hotel, String username_hotel, String password_hotel, String name_hotel, String phone_hotel, String address_hotel) {
        this.id_hotel = id_hotel;
        this.username_hotel = username_hotel;
        this.password_hotel = password_hotel;
        this.name_hotel = name_hotel;
        this.phone_hotel = phone_hotel;
        this.address_hotel = address_hotel;
    }

    protected Hotels(Parcel in) {
        id_hotel = in.readInt();
        username_hotel = in.readString();
        password_hotel = in.readString();
        name_hotel = in.readString();
        phone_hotel = in.readString();
        address_hotel = in.readString();
    }

    public static final Parcelable.Creator<Hotels> CREATOR = new Parcelable.Creator<Hotels>() {
        @Override
        public Hotels createFromParcel(Parcel in) {
            return new Hotels(in);
        }

        @Override
        public Hotels[] newArray(int size) {
            return new Hotels[size];
        }
    };

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }
    public String getUsername_hotel() {
        return username_hotel;
    }

    public void setUsername_hotel(String username_hotel) {
        this.username_hotel = username_hotel;
    }

    public String getPassword_hotel() {
        return password_hotel;
    }

    public void setPassword_hotel(String password_hotel) {
        this.password_hotel = password_hotel;
    }

    public String getName_hotel() {
        return name_hotel;
    }

    public void setName_hotel(String name_hotel) {
        this.name_hotel = name_hotel;
    }

    public String getPhone_hotel() {
        return phone_hotel;
    }

    public void setPhone_hotel(String phone_hotel) {
        this.phone_hotel = phone_hotel;
    }

    public String getAddress_hotel() {
        return address_hotel;
    }

    public void setAddress_hotel(String address_hotel) {
        this.address_hotel = address_hotel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_hotel);
        dest.writeString(username_hotel);
        dest.writeString(password_hotel);
        dest.writeString(name_hotel);
        dest.writeString(phone_hotel);
        dest.writeString(address_hotel);
    }
}
