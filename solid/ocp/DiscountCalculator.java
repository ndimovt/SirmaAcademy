package io.github.ndimovt.solid.ocp;

public class DiscountCalculator {
    /* using DiscountType enum will not break the code,
        allowing new discount types to be added freely
     */
    public double calculateDiscount(String type, double price) {
        if (type.equals(DiscountType.STUDENT)) {
            return price * DiscountType.STUDENT.getDiscount();
        } else if (type.equals(DiscountType.SENIOR)) {
            return price * DiscountType.SENIOR.getDiscount();
        }
        return price;
    }
}
