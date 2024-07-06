package io.github.ndimovt.inventory.datahandling;

import java.util.Map;

public interface Sort {
    //added sorting criterias
    Map<Integer, String> byCategory(Map<Integer, String> map, String category);
    Map<String, String> byName();
    Map<Double, String> byPrice();
}
