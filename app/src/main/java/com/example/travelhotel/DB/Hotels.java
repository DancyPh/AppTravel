package com.example.travelhotel.DB;

public class Hotels {


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
}
