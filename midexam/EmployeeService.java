package io.github.ndimovt.midexam;

import java.util.List;
import java.util.Map;

public class EmployeeService implements Service{
    private final Readable readable;
    private final Writeable writeable;

    public EmployeeService(Readable readable, Writeable writeable) {
        this.readable = readable;
        this.writeable = writeable;
    }
    public String searchEmployeeById(int id){
        return readable.readById(id);
    }
    public List<Employee> searchEmployeeName(String name){
        return readable.readByName(name);
    }
    public List<Employee> searchEmployeeDepartment(String department){
        return readable.readByDepartment(department);
    }
    public Map<Integer, Employee> getAllActiveEmployees(){
        return readable.readActiveEmployees();
    }
    public void writeEmployee(Map<Integer, Employee> employeeMap) {
        writeable.write(employeeMap);
    }
}
