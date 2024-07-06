package io.github.ndimovt.inventory.orderprocessing;

public class OrderItem {
    //separate items from order list
    private int id;
    private int quantity;
    private PaymentMethods paymentMethod;
    private double price;

    public OrderItem(int id, int quantity,PaymentMethods paymentMethod, double price) {
        this.id = id;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "OrderItem{" +
                "id: " + id +
                ", quantity: " + quantity +
                ", paymentMethod: " + paymentMethod +
                ", price: " + price +
                '}';
    }
}
