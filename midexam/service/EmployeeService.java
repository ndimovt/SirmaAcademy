package io.github.ndimovt.midexam.service;

import io.github.ndimovt.midexam.io.Readable;
import io.github.ndimovt.midexam.io.Writeable;
import io.github.ndimovt.midexam.employee.Employee;

import java.util.List;
import java.util.Map;

/**
 * Processing incoming search requests
 *
 */
public class EmployeeService implements Service {
    private final Readable readable;
    private final Writeable writeable;

    /**
     * Instantiates new Employee Service
     *
     * @param readable can work with everything implementing Readable
     * @param writeable can work with everything implementing Writable
     */
    public EmployeeService(Readable readable, Writeable writeable) {
        this.readable = readable;
        this.writeable = writeable;
    }

    /**
     * Searching by id
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @return String object
     */
    public String searchEmployeeById(int id){
        return readable.readById(id);
    }

    /**
     * Searching by name
     *
     * @param name the unique identifier of the employee whose data is to be read
     * @return List with records
     */
    public List<Employee> searchEmployeeName(String name){
        return readable.readByName(name);
    }

    /**
     * Searching by department
     *
     * @param department the unique identifier of the employee whose data is to be read
     * @return List with records
     */
    public List<Employee> searchEmployeeDepartment(String department){
        return readable.readByDepartment(department);
    }

    /**
     * Searching all active employees
     *
     * @return Map with records
     */
    public Map<Integer, Employee> getAllActiveEmployees(){
        return readable.readActiveEmployees();
    }

    /**
     * Returns all employees in file
     *
     * @return Map with records
     */
    public Map<Integer, Employee> getAllEmployees(){
        return readable.readAllEmployees();
    }

    /**
     * Inserting new employee record
     *
     * @param employeeMap Map with records
     */
    public void writeEmployee(Map<Integer, Employee> employeeMap) {
        writeable.write(employeeMap);
    }
}
