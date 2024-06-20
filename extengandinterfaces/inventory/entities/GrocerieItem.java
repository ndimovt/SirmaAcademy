package io.github.ndimovt.extengandinterfaces.inventory.entities;

import java.util.Date;

public class GrocerieItem extends InventoryItem {
    private double weight;
    private boolean perished;
    public GrocerieItem(int id, int quantity, String name, String description, double weight, double price, boolean perished, Date expiration) {
        setId(id);
        setQuantity(quantity);
        setPrice(price);
        setName(name);
        setDescription(description);
        setExpiration(expiration);
        this.weight = weight;
        this.perished = perished;
        setCategory("Groceries");
        setPerishable(true);
    }
    @Override
    public double calculateValue(){
        return getPrice() * weight * getQuantity();
    }

    public boolean isPerished() {
        return perished;
    }

    public void setPerished(boolean perished) {
        this.perished = perished;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getDetails() {
        return  getId() +" "+ getQuantity() +" "+ getName() +" "+ getDescription() +" "+ getCategory() +" "+ getPrice() +" "+ weight;
    }

}
