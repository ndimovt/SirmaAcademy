package io.github.ndimovt.midexam.io;

import io.github.ndimovt.midexam.employee.Employee;

import java.util.List;
import java.util.Map;

/**
 * Readable interface
 *
 */
public interface Reader {
    /**
     * Reads data associated with employee id
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @return String object
     */
    String readById(int id);

    /**
     * Reads data associated with employee name
     *
     * @param name the unique identifier of the employee whose data is to be read
     * @return String object
     */
    List<Employee> readByName(String name);

    /**
     * Reads data associated with employee department
     *
     * @param department the unique identifier of the employee whose data is to be read
     * @return List with records by a given criteria
     */
    List<Employee> readByDepartment(String department);

    /**
     * Reads data associated with active employees only
     *
     * @return map with records
     */
    Map<Integer, Employee> readActiveEmployees();

    /**
     * Reads data associated with all employees
     *
     * @return map with records
     */
    Map<Integer, Employee> readAllEmployees();
}
