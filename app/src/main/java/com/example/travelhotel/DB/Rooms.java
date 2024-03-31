package com.example.travelhotel.DB;

public class Rooms {
    private int idRoom;
    private String roomName;
    private double roomPrice;
    private int roomNumber;
    private boolean roomStatus;
    private int idHotel;

    public Rooms(int idRoom, String roomName, double roomPrice, int roomNumber, boolean roomStatus, int idHotel) {
        this.idRoom = idRoom;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.roomNumber = roomNumber;
        this.roomStatus = roomStatus;
        this.idHotel = idHotel;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
}
