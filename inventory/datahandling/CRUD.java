package io.github.ndimovt.inventory.datahandling;

import io.github.ndimovt.inventory.entities.InventoryItem;

import java.util.Map;

public interface CRUD {
    //basic crud operations for working with database, in this case storage.txt
    void create(Map<Integer, InventoryItem> map);
    void itemUnfitForSale(Map<Integer, InventoryItem> map);
    Map<Integer, String> read();
    void delete(int id);
    void updateQuantity(int id, int quantity, Map<Integer, String> map);
    void removeItem(Map<Integer, String> map, int id);
}
