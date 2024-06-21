package io.github.ndimovt.extengandinterfaces.inventory.entities;

public class FragileItem extends InventoryItem {
    private double weight;
    private boolean isBroken;
    public FragileItem(int itemId, int quantity, String name, String description, double weight, double price, boolean isBroken) {
        setId(itemId);
        setQuantity(quantity);
        setPrice(price);
        setName(name);
        setDescription(description);
        this.weight = weight;
        setCategory("Fragile");
        setBreakable(true);
        this.isBroken = isBroken;
    }
    public boolean isBroken() {
        return isBroken;
    }
    public void setBroken(boolean broken) {
        isBroken = broken;
    }
    @Override
    public double calculateValue(){
        return getPrice() * getQuantity() * weight * 1.2;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getDetails() {
        return getQuantity() +" "+ getName() +" "+ getDescription() +" "+ getCategory() +" "+ getPrice() +" "+ weight;
    }
}
