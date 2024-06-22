package io.github.ndimovt.extengandinterfaces.inventory.orderprocessing;

public class OrderItem {
    private int id;
    private int quantity;
    private String name;
    private double price;

    public OrderItem(int id, int quantity, String name, double price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
