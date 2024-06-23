package io.github.ndimovt.room.reservation;

public class BookingInformation {
    private String userName;
    private String room;
    private String dateIn;
    private String dateOut;

    public BookingInformation(String userName, String room, String dateIn, String dateOut) {
        this.userName = userName;
        this.room = room;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public String getRoom() {
        return room;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    @Override
    public String toString() {
        return room +" "+ dateIn +" "+ dateOut;
    }
}
