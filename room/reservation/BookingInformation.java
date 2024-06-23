package io.github.ndimovt.room.reservation;

import java.io.Serializable;
import java.util.Random;
import java.util.function.Supplier;

public class BookingInformation implements Serializable {
    private int id;
    private String userName;
    private String room;
    private String dateIn;
    private String dateOut;
    private double price;

    public BookingInformation(String userName, String room, String dateIn, String dateOut, double price) {
        Supplier<Integer> ticketCode = () -> new Random().nextInt();
        this.id = idGen(ticketCode);
        this.userName = userName;
        this.room = room;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.price = price;
    }

    public BookingInformation(String room, String dateIn, String dateOut, double price) {
        this.room = room;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.price = price;
    }

    public String getRoom() {
        return room;
    }

    public String getDateIn() {
        return dateIn;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOut() {
        return dateOut;
    }
    private int idGen(Supplier<Integer> number){
        return number.get();
    }
    @Override
    public String toString() {
        return id +" "+ room +" "+ dateIn +" "+ dateOut+ " "+price;
    }

}
