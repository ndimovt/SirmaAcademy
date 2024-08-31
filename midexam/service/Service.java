package io.github.ndimovt.midexam.service;

import io.github.ndimovt.midexam.employee.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Service interface
 *
 */
public interface Service {
    /**
     * Returns String object by a given id
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @return String object by a given criteria
     */
    String searchEmployeeById(int id);

    /**
     * Returns List with Employees by a given name
     *
     * @param name the unique identifier of the employee whose data is to be read
     * @return List with records by a given criteria
     */
    List<Employee> searchEmployeeName(String name);

    /**
     * Returns List with Employees by a given department
     *
     * @param department the unique identifier of the employee whose data is to be read
     * @return List with records by a given criteria
     */
    List<Employee> searchEmployeeDepartment(String department);

    /**
     * Returns Map with Employees currently working
     *
     * @return Map with specific records
     */
    Map<Integer, Employee> getAllActiveEmployees();

    /**
     * Returns Map with all employees
     *
     * @return Map with all records
     */
    Map<Integer, Employee> getAllEmployees();

    /**
     * Writes Map contents
     *
     * @param employeeMap Map with records
     */
    void writeEmployee(Map<Integer, Employee> employeeMap) throws IOException;
}
