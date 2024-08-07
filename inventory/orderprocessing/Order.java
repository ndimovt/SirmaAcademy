package io.github.ndimovt.inventory.orderprocessing;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //saving order information in orders list, and calculating total price
    private List<OrderItem> orders = new ArrayList<>();
    public void insertOrder(OrderItem item){
        orders.add(item);
    }
    public void print(){
        orders.forEach(System.out::println);
    }
    public double totalCost(){
        double cost = 0.0;
        for(OrderItem order : orders){
            cost += order.getPrice();
        }
        return cost;
    }

}
