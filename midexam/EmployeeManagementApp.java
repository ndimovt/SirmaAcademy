package io.github.ndimovt.midexam;

import io.github.ndimovt.midexam.employee.Employee;
import io.github.ndimovt.midexam.io.EmployeeReader;
import io.github.ndimovt.midexam.io.EmployeeWriter;
import io.github.ndimovt.midexam.manager.EmployeeManager;
import io.github.ndimovt.midexam.manager.Manager;
import io.github.ndimovt.midexam.service.EmployeeService;
import io.github.ndimovt.midexam.service.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static io.github.ndimovt.midexam.util.InputValidator.*;

/**
 * App management class
 *
 */
public class EmployeeManagementApp {
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService(new EmployeeReader(), new EmployeeWriter());
        Map<Integer, Employee> records = service.getAllEmployees();
        Manager manager = new EmployeeManager(service, records);
        System.out.println();
        printOptions();
        boolean isWorking = true;
        while (isWorking) {
            System.out.println();
            System.out.print("Awaiting your choice:");
            int option = inn.nextInt();
            switch (option) {
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

    /**
     * Showing possible options
     *
     */
    private static void printOptions() {
        System.out.println("1)Add employee  2)Search Employee by id " +
                "3)Search Employee by name  4)Search Employee by department " +
                "5)Update employee department  6)Update employee salary " +
                "7)Update employee role  8)Fire employee " +
                "9)Change surname(only for women after marriage/divorce)  10)Check all active employees " +
                "11)Exit");
    }

    /**
     * Adding new record in map
     *
     * @param newEmployee Map for records to be stored
     */
    private static void addNewEmployee(Map<Integer, Employee> newEmployee) {
        int id = getValidId();
        if (!newEmployee.containsKey(id)) {
            inn.nextLine();
            String name = getValidName();
            String department = getValidDepartment();
            String role = getValidRole();
            double salary = getValidSalary();
            Employee employee = new Employee(id, name, LocalDate.now(), null, department, role, salary);
            newEmployee.put(employee.getId(), employee);
        } else {
            System.out.printf("Id:%d already exists!\n",id);
        }
    }

    /**
     * Searching by id
     *
     * @param service can take everything implementing Service
     */
    private static void searchEmployeeById(Service service) {
        int id = getValidId();
        System.out.println(service.searchEmployeeById(id));
    }

    /**
     * Searching by employee name
     *
     * @param service can take everything implementing Service
     */
    private static void searchEmployeeByName(Service service) {
        String name = getValidName();
        List<Employee> list = service.searchEmployeeName(name);
        list.forEach(System.out::println);
    }

    /**
     * Searching by department name and prints results
     *
     * @param service can take everything implementing Service
     */
    private static void searchByDepartment(Service service) {
        inn.nextLine();
        String department = getValidDepartment();
        List<Employee> departmentList = service.searchEmployeeDepartment(department);
        departmentList.forEach(System.out::println);
    }

    /**
     * Update department in which employee works, using employee id
     *
     * @param manager can take everything implementing Manager
     */
    private static void updateDepartment(Manager manager) {
        int id = getValidId();
        inn.nextLine();
        String empDepartment = getValidDepartment();
        manager.updateEmployeeDepartment(id, empDepartment);
    }

    /**
     * Updated employee salary by id
     *
     * @param manager can take everything implementing Manager
     * @param service can take everything implementing Service
     * @param updatedInfo Map for records to be stored
     */
    private static void updateEmployeeSalary(Manager manager, Service service, Map<Integer, Employee> updatedInfo) {
        int id = getValidId();
        double newSalary = getValidSalary();
        manager.updateEmployeeSalary(id, newSalary);
        service.writeEmployee(updatedInfo);
    }

    /**
     * Updating employee role by id
     *
     * @param manager can take everything implementing Manager
     * @param service can take everything implementing Service
     * @param updatedInfo Map for records to be stored
     */
    private static void updateEmployeeRole(Manager manager, Service service, Map<Integer, Employee> updatedInfo) {
        int id = getValidId();
        inn.nextLine();
        String newRole = getValidRole();
        manager.updateEmployeeRole(id, newRole);
        service.writeEmployee(updatedInfo);
    }

    /**
     * Firing employee by id
     *
     * @param manager can take everything implementing Manager
     */
    private static void fireEmployee(Manager manager) {
        int id = getValidId();
        manager.fireEmployee(id);
    }

    /**
     * Updating employee surname, recommended for women after marriage/divorce
     *
     * @param manager can take everything implementing Manager
     * @param service can take everything implementing Service
     * @param updatedInfo Map for records to be stored
     */
    private static void updateSurname(Manager manager, Service service, Map<Integer, Employee> updatedInfo) {
        int id = getValidId();
        inn.nextLine();
        String newSurname = getValidSurname();
        manager.updateEmployeeSurname(id, newSurname);
        service.writeEmployee(updatedInfo);
    }

    /**
     * Returns map with all employees currently working
     *
     * @param service can take everything implementing Service
     */
    private static void getActiveEmployees(Service service) {
        Map<Integer, Employee> active = service.getAllActiveEmployees();
        active.forEach((k, v) -> System.out.println(v));
    }

}
