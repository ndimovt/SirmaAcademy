package io.github.ndimovt.extengandinterfaces.inventory.entities;

import io.github.ndimovt.extengandinterfaces.inventory.attributes.*;

import java.util.Date;

public abstract class AbstractItem implements Breakable, Categorizable, Item, Perishable, Sellable {
    private String name;
    private String category;
    private boolean breakable;
    private boolean perishable;
    private double price;
    private String description;
    private Date expiration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String getCategory(){
        return category;
    }
    @Override
    public boolean isBreakable(){
        return breakable;
    }
    public void setBreakable(boolean breakable){
        this.breakable = breakable;
    }
    @Override
    public void broke(){
        if(breakable){
            System.out.println("Item broken!");
        }
    }
    @Override
    public boolean isPerishable(){
        return perishable;
    }
    public void setPerishable(boolean perishable){
        this.perishable = perishable;
    }
    @Override
    public void expiration(){
        if(perishable){
            System.out.println("Item expired!");
        }
    }
    @Override
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public double calculateValue(){
        return 0.00;
    }
    @Override
    public String getDescription(){
        return description;
    }

}
