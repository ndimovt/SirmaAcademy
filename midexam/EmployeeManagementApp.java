package io.github.ndimovt.midexam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagementApp {
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService(new EmployeeReader(), new EmployeeWriter());
        Map<Integer, Employee> records = service.getAllEmployees();
        Manager manager = new EmployeeManager(service, records);
        System.out.println();
        printOptions();
        boolean isWorking = true;
        while (isWorking){
            System.out.println();
            System.out.print("Awaiting your choice:");
            int option = inn.nextInt();
            switch (option){
                case 1:
                    addNewEmployee(records);
                    break;
                case 2:
                    searchEmployeeById(service);
                    break;
                case 3:
                    searchEmployeeByName(service);
                    break;
                case 4:
                    searchByDepartment(service);
                    break;
                case 5:
                    updateDepartment(manager);
                    break;
                case 6:
                    updateEmployeeSalary(manager, service, records);
                    break;
                case 7:
                    updateEmployeeRole(manager, service, records);
                    break;
                case 8:
                    fireEmployee(manager);
                    break;
                case 9:
                    updateSurname(manager, service, records);
                    break;
                case 10:
                    getActiveEmployees(service);
                    break;
                case 11:
                    service.writeEmployee(records);
                    isWorking = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    private static void printOptions(){

        System.out.println("1)Add employee  2)Search Employee by id " +
                "3)Search Employee by name  4)Search Employee by department " +
                "5)Update employee department  6)Update employee salary" +
                "7)Update employee role  8)Fire employee " +
                "9)Change surname(only for women after marriage/divorce)  10)Check all active employees " +
                "11)Exit");
    }
    private static void addNewEmployee(Map<Integer, Employee> newEmployee){
        System.out.println("Enter id");
        int id = inn.nextInt();
        if(!newEmployee.containsKey(id)) {
            inn.nextLine();
            System.out.println("Enter name");
            String name = inn.nextLine();
            System.out.println("Enter department");
            String department = inn.nextLine();
            System.out.println("Enter role");
            String role = inn.nextLine();
            System.out.println("Enter salary");
            double salary = inn.nextDouble();
            if(salary > 0.00) {
                Employee employee = new Employee(id, name, LocalDate.now(), null, department, role, salary);
                newEmployee.put(employee.getId(), employee);
            }else {
                System.out.println("Salary can't be less than 0.00!");
            }
        }else{
            System.out.println("Id:"+id+" already exists!");
        }
    }
    private static void searchEmployeeById(Service service){
        System.out.println("Enter id:");
        int id = inn.nextInt();
        System.out.println(service.searchEmployeeById(id));
    }
    private static void searchEmployeeByName(Service service){
        System.out.println("Enter employee name:");
        inn.nextLine();
        String name = inn.nextLine();
        List<Employee> list = service.searchEmployeeName(name);
        list.forEach(System.out::println);
    }
    private static void searchByDepartment(Service service){
        System.out.println("Enter department:");
        inn.nextLine();
        String department = inn.nextLine();
        List<Employee> departmentList = service.searchEmployeeDepartment(department);
        departmentList.forEach(System.out::println);
    }
    private static void updateDepartment(Manager manager){
        System.out.println("Enter employee id:");
        int empId = inn.nextInt();
        System.out.println("Enter new department:");
        inn.nextLine();
        String empDepartment = inn.nextLine();
        manager.updateEmployeeDepartment(empId, empDepartment);
    }
    private static void updateEmployeeSalary(Manager manager, Service service, Map<Integer, Employee> updatedInfo){
        System.out.println("Enter employee id:");
        int id = inn.nextInt();
        System.out.println("Enter new salary:");
        double newSalary = inn.nextDouble();
        if(newSalary > 0.00) {
            manager.updateEmployeeSalary(id, newSalary);
            service.writeEmployee(updatedInfo);
        }else {
            System.out.println("Salary can't be less than 0.00!");
        }
    }
    private static void updateEmployeeRole(Manager manager, Service service, Map<Integer, Employee> updatedInfo){
        System.out.println("Enter employee id:");
        int id = inn.nextInt();
        System.out.println("Enter new role:");
        inn.nextLine();
        String newRole = inn.nextLine();
        manager.updateEmployeeRole(id, newRole);
        service.writeEmployee(updatedInfo);
    }
    private static void fireEmployee(Manager manager){
        System.out.println("Enter employee id:");
        int id = inn.nextInt();
        manager.fireEmployee(id);
    }
    private static void updateSurname(Manager manager, Service service, Map<Integer, Employee> updatedInfo){
        System.out.println("Enter employee id:");
        int id = inn.nextInt();
        System.out.println("Enter new surname:");
        inn.nextLine();
        String newSurname = inn.nextLine();
        manager.updateEmployeeSurname(id, newSurname);
        service.writeEmployee(updatedInfo);
    }
    private static void getActiveEmployees(Service service){
        Map<Integer, Employee> active = service.getAllActiveEmployees();
        active.forEach((k,v) -> System.out.println(v));
    }
}
