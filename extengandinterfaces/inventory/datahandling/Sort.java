package io.github.ndimovt.extengandinterfaces.inventory.datahandling;

import java.util.Map;

public interface Sort {
    Map<Integer, String> byCategory(Map<Integer, String> map, String category);
    Map<String, String> byName();
    Map<Double, String> byPrice();
}
