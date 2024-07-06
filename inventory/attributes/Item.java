package io.github.ndimovt.inventory.attributes;

public interface Item {
    double calculateValue();
    String getDetails();
    void setDescription(String description);
    String getDescription();
}
