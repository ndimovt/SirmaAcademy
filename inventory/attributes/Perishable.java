package io.github.ndimovt.inventory.attributes;

public interface Perishable {
    boolean isPerishable();
    void expiration();
}
