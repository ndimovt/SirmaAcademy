package io.github.ndimovt.inventory.entities;

public class InventoryItem extends AbstractItem {
    private int id;
    private int quantity;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String getDetails() {
        return null;
    }
}
