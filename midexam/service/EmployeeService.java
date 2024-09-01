package io.github.ndimovt.midexam.service;

import io.github.ndimovt.midexam.io.Reader;
import io.github.ndimovt.midexam.io.Writer;
import io.github.ndimovt.midexam.employee.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Processing incoming search requests
 *
 */
public class EmployeeService implements Service {
    private final Reader reader;
    private final Writer writer;

    /**
     * Instantiates new Employee Service
     *
     * @param reader can work with everything implementing Readable
     * @param writer can work with everything implementing Writable
     */
    public EmployeeService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Searching by id
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @return String object
     */
    public String searchEmployeeById(int id){
        return reader.readById(id);
    }

    /**
     * Searching by name
     *
     * @param name the unique identifier of the employee whose data is to be read
     * @return List with records
     */
    public Employee searchEmployeeName(String name){
        return reader.readByName(name);
    }

    /**
     * Searching by department
     *
     * @param department the unique identifier of the employee whose data is to be read
     * @return List with records
     */
    public List<Employee> searchEmployeeDepartment(String department){
        return reader.readByDepartment(department);
    }

    /**
     * Searching all active employees
     *
     * @return Map with records
     */
    public Map<Integer, Employee> getAllActiveEmployees(){
        return reader.readActiveEmployees();
    }

    /**
     * Returns all employees in file
     *
     * @return Map with records
     */
    public Map<Integer, Employee> getAllEmployees(){
        return reader.readAllEmployees();
    }

    /**
     * Inserting new employee record
     *
     * @param employeeMap Map with records
     */
    public void writeEmployee(Map<Integer, Employee> employeeMap) throws IOException {
        writer.write(employeeMap);
    }
}
