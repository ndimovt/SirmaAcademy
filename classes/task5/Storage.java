package io.github.ndimovt.classes.task5;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Product> storage = new ArrayList<>();
    private int capacity;

    public Storage(int capacity) {
        this.capacity = capacity;
    }
    public double totalCost(){
        double total = 0.0;
        for(Product product : storage){
            total += product.getQuantity() * product.getPrice();
        }
        return total;
    }
    public void addProduct(Product product){
        if(this.capacity >= product.getQuantity()){
            this.capacity -= product.getQuantity();
            storage.add(product);
        }else{
            System.out.println("No available storage");
        }
    }
    public void getProducts(){
        for(Product product : storage){
            System.out.println(product);
        }
    }
}
