package io.github.ndimovt.solid.ocp;

public enum DiscountType {
    //you can add as more discount types as you like 
    STUDENT(0.1),
    SENIOR(0.2);
    private final double discount;
    DiscountType(double discount) {
        this.discount = discount;
    }
    public double getDiscount() {
        return discount;
    }
}
