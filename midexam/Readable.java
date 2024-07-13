package io.github.ndimovt.midexam;

import java.util.List;
import java.util.Map;

public interface Readable {
    String readById(int id);
    List<Employee> readByName(String name);
    List<Employee> readByDepartment(String department);
    Map<Integer, Employee> readActiveEmployees();
}
