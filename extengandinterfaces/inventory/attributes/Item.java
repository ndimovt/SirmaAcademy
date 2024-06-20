package io.github.ndimovt.extengandinterfaces.inventory.attributes;

public interface Item {
    double calculateValue();
    String getDetails();
    void setDescription(String description);
    String getDescription();
}
