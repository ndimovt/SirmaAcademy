package io.github.ndimovt.midexam;

import java.util.List;
import java.util.Map;

public interface Service {
    String searchEmployeeById(int id);
    List<Employee> searchEmployeeName(String name);
    List<Employee> searchEmployeeDepartment(String department);
    Map<Integer, Employee> getAllActiveEmployees();
    Map<Integer, Employee> getAllEmployees();
    void writeEmployee(Map<Integer, Employee> employeeMap);
}
