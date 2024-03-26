package com.example.travelhotel.DB;

public class Customers {
    private String username_customer;
    private String password_customer;
    private String name_customer;
    private String phone_customer;
    private String address_customer;

    public Customers(String username_customer, String password_customer, String name_customer, String phone_customer, String address_customer) {
        this.username_customer = username_customer;
        this.password_customer = password_customer;
        this.name_customer = name_customer;
        this.phone_customer = phone_customer;
        this.address_customer = address_customer;
    }



    public String getUsername_customer() {
        return username_customer;
    }

    public void setUsername_customer(String username_customer) {
        this.username_customer = username_customer;
    }

    public String getPassword_customer() {
        return password_customer;
    }

    public void setPassword_customer(String password_customer) {
        this.password_customer = password_customer;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getPhone_customer() {
        return phone_customer;
    }

    public void setPhone_customer(String phone_customer) {
        this.phone_customer = phone_customer;
    }

    public String getAddress_customer() {
        return address_customer;
    }

    public void setAddress_customer(String address_customer) {
        this.address_customer = address_customer;
    }
}
