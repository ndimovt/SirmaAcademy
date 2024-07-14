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
    public void updateEmployeeDepartment(int id, String department){
        Employee employee = allRecords().get(id);
        if(employee != null && allRecords().containsKey(id)){
            employee.setDepartment(department);
            records.put(id, employee);
        }else{
            System.out.printf("Employee with ID:%d not found.\n", id);
        }
    }

    /**
     * Update current role
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param role the new parameter
     */
    public void updateEmployeeRole(int id, String role){
        Employee employee = allRecords().get(id);
        if(employee != null && allRecords().containsKey(id)){
            employee.setRole(role);
            records.put(id, employee);
        }else{
            System.out.printf("Employee with ID:%d not found.\n", id);
        }
    }

    /**
     * Update current salary
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param salary the new parameter
     */
    public void updateEmployeeSalary(int id, double salary){
        Employee employee = allRecords().get(id);
        if(employee != null && allRecords().containsKey(id)){
            employee.setSalary(salary);
            records.put(id, employee);
        }else{
            System.out.printf("Employee with ID:%d not found.\n", id);
        }
    }

    /**
     * Updates employee surname
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param surname the new parameter
     */
    public void updateEmployeeSurname(int id, String surname){
        Employee employee = allRecords().get(id);
        if(employee != null && allRecords().containsKey(id)){
            String[] currentSurname = employee.getName().split(" ");
            currentSurname[1] = surname;
            employee.setName(currentSurname[0] + " "+currentSurname[1]);
            records.put(id, employee);
        }else{
            System.out.printf("Employee with ID:%d not found.\n", id);
        }
    }

    /**
     * Firing employee automatically gets current date
     *
     * @param id the unique identifier of the employee whose data is to be read
     */
    public void fireEmployee(int id){
        Employee employee = allRecords().get(id);
        if (employee != null && allRecords().containsKey(id)) {
            employee.setEndDate(getDate().toString());
            records.put(employee.getId(), employee);
        }else{
            System.out.printf("Employee with ID:%d not found.\n", id);
        }
    }

    /**
     * Returns current date
     *
     * @return LocalDate instance
     */
    private static LocalDate getDate(){
        return LocalDate.now();
    }

    /**
     * Returns map with all employee records
     *
     * @return map with records
     */
    private Map<Integer, Employee> allRecords(){
        return service.getAllEmployees();
    }
}
