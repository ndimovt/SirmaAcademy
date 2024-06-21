package io.github.ndimovt.extengandinterfaces.inventory.entities;

public class GrocerieItem extends InventoryItem {
    private double weight;
    private boolean perished;
    public GrocerieItem(int id, int quantity, String name, String description, double weight, double price, boolean perished) {
        setId(id);
        setQuantity(quantity);
        setPrice(price);
        setName(name);
        setDescription(description);
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
        return  getQuantity() +" "+ getName() +" "+ getDescription() +" "+ getCategory() +" "+ getPrice() +" "+ weight;
    }

}
