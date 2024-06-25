package io.github.ndimovt.room.reservation.roomInfo;

public enum RoomPrice {
    //this enum holds room types and prices
    SINGLE(50.0), DOUBLE(100.0), TRIPLE(150.0), FOUR(200.0), VIP(300.0);
    private final double price;

    RoomPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


}
