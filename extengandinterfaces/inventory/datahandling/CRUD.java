package io.github.ndimovt.extengandinterfaces.inventory.datahandling;

import io.github.ndimovt.extengandinterfaces.inventory.entities.InventoryItem;

import java.util.Map;

public interface CRUD {
    void create(Map<Integer, InventoryItem> map);
    void itemUnfitForSale(Map<Integer, InventoryItem> map);
    Map<Integer, String> read();
    void delete(int id);
    void updateQuantity(int id, int quantity, Map<Integer, String> map);
    void removeItem(Map<Integer, String> map, int id);
}
