package io.github.ndimovt.extengandinterfaces.inventory.entities;

public class ElectronicsItem extends InventoryItem {
    private double warrantyPeriod;

    public ElectronicsItem(int itemId, int quantity, String name, String description, double price, double warrantyPeriod) {
        setId(itemId);
        setQuantity(quantity);
        setName(name);
        setPrice(price);
        this.warrantyPeriod = warrantyPeriod;
        setCategory("Electronics");
        setDescription(description);
    }
    @Override
    public double calculateValue(){
        return getPrice() * getQuantity() * (1 + warrantyPeriod / 12);
    }
    public double getWarrantyPeriod() {
        return warrantyPeriod;
    }
    public void setWarrantyPeriod(double warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String getDetails() {
        return getQuantity() +" "+ getName() +" "+ getDescription() +" "+ getCategory() +" "+ getPrice() +" "+ warrantyPeriod;
    }
}
