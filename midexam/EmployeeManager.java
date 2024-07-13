package io.github.ndimovt.midexam;

import java.util.Map;

public class EmployeeManager implements Manager{
    private Service service;
    private Map<Integer, Employee> records;
    public EmployeeManager(Service service, Map<Integer, Employee> records) {
        this.service = service;
        this.records = records;
    }
    public void updateEmployeeDepartment(int id, String department){
        Employee employee = allRecords().get(id);
        if(employee != null && allRecords().containsKey(id)){
            employee.setDepartment(department);
            records.put(id, employee);
        }else{
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
    public void updateEmployeeRole(int id, String role){
        Employee employee = allRecords().get(id);
        if(employee != null && allRecords().containsKey(id)){
            employee.setRole(role);
            records.put(id, employee);
        }else{
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
    public void updateEmployeeSalary(int id, double salary){
        Employee employee = allRecords().get(id);
        if(employee != null && allRecords().containsKey(id)){
            employee.setSalary(salary);
            records.put(id, employee);
        }else{
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
    public void updateEmployeeSurname(int id, String surname){
        Employee employee = allRecords().get(id);
        if(employee != null && allRecords().containsKey(id)){
            String[] currentSurname = employee.getName().split(" ");
            currentSurname[1] = surname;
            employee.setName(currentSurname[0] + " "+currentSurname[1]);
            records.put(id, employee);
        }else{
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
    private Map<Integer, Employee> allRecords(){
        return service.getAllActiveEmployees();
    }
}
