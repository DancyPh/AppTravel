package com.example.travelhotel.DB;

public class Bookings {
    private int idBooking;
    private int idCustomer;
    private int idHotel;
    private String bookingDate;
    private String checkinDate;
    private String roomCount;
    private String note;

    public Bookings(int idBooking, int idCustomer, int idHotel, String bookingDate, String checkinDate, String roomCount, String note) {
        this.idBooking = idBooking;
        this.idCustomer = idCustomer;
        this.idHotel = idHotel;
        this.bookingDate = bookingDate;
        this.checkinDate = checkinDate;
        this.roomCount = roomCount;
        this.note = note;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(String roomCount) {
        this.roomCount = roomCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
