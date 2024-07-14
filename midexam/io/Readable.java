package io.github.ndimovt.midexam.io;

import io.github.ndimovt.midexam.employee.Employee;

import java.util.List;
import java.util.Map;

public interface Readable {
    String readById(int id);
    List<Employee> readByName(String name);
    List<Employee> readByDepartment(String department);
    Map<Integer, Employee> readActiveEmployees();
    Map<Integer, Employee> readAllEmployees();
}
