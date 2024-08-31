package io.github.ndimovt.midexam.manager;

import io.github.ndimovt.midexam.service.Service;
import io.github.ndimovt.midexam.employee.Employee;

import java.time.LocalDate;
import java.util.Map;

/**
 * Processing all updating requests
 *
 */
public class EmployeeManager implements Manager {
    private Service service;
    private Map<Integer, Employee> records;

    /**
     * Instantiating EmployeeManager
     * @param service everything implementing Service
     * @param records Map
     */
    public EmployeeManager(Service service, Map<Integer, Employee> records) {
        this.service = service;
        this.records = records;
    }

    /**
     * Update current department
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param department the new parameter
     */
    public void updateEmployeeDepartment(int id, String department) throws IllegalArgumentException{
        Employee employee = service.getAllEmployees().get(id);
        if(employee != null){
            employee.setDepartment(department);
            records.put(id, employee);
        }else{
            throw new IllegalArgumentException("Employee with ID: "+id+" not found!");
        }
    }

    /**
     * Update current role
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param role the new parameter
     */
    public void updateEmployeeRole(int id, String role) throws IllegalArgumentException{
        Employee employee = service.getAllEmployees().get(id);
        if(employee != null){
            employee.setRole(role);
            records.put(id, employee);
        }else{
            throw new IllegalArgumentException("Employee with ID: "+id+" not found!");
        }
    }

    /**
     * Update current salary
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param salary the new parameter
     */
    public void updateEmployeeSalary(int id, double salary) throws IllegalArgumentException{
        Employee employee = service.getAllEmployees().get(id);
        if(employee != null){
            employee.setSalary(salary);
            records.put(id, employee);
        }else{
            throw new IllegalArgumentException("Employee with ID: "+id+" not found!");
        }
    }

    /**
     * Updates employee surname
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param surname the new parameter
     */
    public void updateEmployeeSurname(int id, String surname) throws IllegalArgumentException{
        Employee employee = service.getAllEmployees().get(id);
        if(employee != null){
            String[] currentSurname = employee.getName().split(" ");
            currentSurname[1] = surname;
            employee.setName(currentSurname[0] + " "+currentSurname[1]);
            records.put(id, employee);
        }else{
            throw new IllegalArgumentException("Employee with ID: "+id+" not found!");
        }
    }

    /**
     * Firing employee automatically gets current date
     *
     * @param id the unique identifier of the employee whose data is to be read
     */
    public void fireEmployee(int id) throws IllegalArgumentException{
        Employee employee = service.getAllEmployees().get(id);
        if (employee != null) {
            employee.setEndDate(LocalDate.now().toString());
            records.put(employee.getId(), employee);
        }else{
            throw new IllegalArgumentException("Employee with ID: "+id+" not found!");
        }
    }
}
