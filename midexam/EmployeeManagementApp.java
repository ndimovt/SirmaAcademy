package io.github.ndimovt.midexam;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private static void printOptions() {
        System.out.println("1)Add employee  2)Search Employee by id " +
                "3)Search Employee by name  4)Search Employee by department " +
                "5)Update employee department  6)Update employee salary " +
                "7)Update employee role  8)Fire employee " +
                "9)Change surname(only for women after marriage/divorce)  10)Check all active employees " +
                "11)Exit");
    }

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
            System.out.println("Id:" + id + " already exists!");
        }
    }

    private static void searchEmployeeById(Service service) {
        int id = getValidId();
        System.out.println(service.searchEmployeeById(id));
    }

    private static void searchEmployeeByName(Service service) {
        String name = getValidName();
        List<Employee> list = service.searchEmployeeName(name);
        list.forEach(System.out::println);
    }

    private static void searchByDepartment(Service service) {
        inn.nextLine();
        String department = getValidDepartment();
        List<Employee> departmentList = service.searchEmployeeDepartment(department);
        departmentList.forEach(System.out::println);
    }

    private static void updateDepartment(Manager manager) {
        int id = getValidId();
        inn.nextLine();
        String empDepartment = getValidDepartment();
        manager.updateEmployeeDepartment(id, empDepartment);
    }

    private static void updateEmployeeSalary(Manager manager, Service service, Map<Integer, Employee> updatedInfo) {
        int id = getValidId();
        double newSalary = getValidSalary();
        manager.updateEmployeeSalary(id, newSalary);
        service.writeEmployee(updatedInfo);
    }

    private static void updateEmployeeRole(Manager manager, Service service, Map<Integer, Employee> updatedInfo) {
        int id = getValidId();
        inn.nextLine();
        String newRole = getValidRole();
        manager.updateEmployeeRole(id, newRole);
        service.writeEmployee(updatedInfo);
    }

    private static void fireEmployee(Manager manager) {
        int id = getValidId();
        manager.fireEmployee(id);
    }

    private static void updateSurname(Manager manager, Service service, Map<Integer, Employee> updatedInfo) {
        int id = getValidId();
        inn.nextLine();
        String newSurname = getValidSurname();
        manager.updateEmployeeSurname(id, newSurname);
        service.writeEmployee(updatedInfo);
    }

    private static void getActiveEmployees(Service service) {
        Map<Integer, Employee> active = service.getAllActiveEmployees();
        active.forEach((k, v) -> System.out.println(v));
    }
    private static String getValidRole(){
        String role = null;
        boolean isValid = false;
        Pattern p = Pattern.compile("[\\d\\!\\@\\$\\%\\^\\,\\&\\*\\(\\)\\[\\]\\{\\}\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:]+|\\s{3,}");
        while (!isValid) {
            System.out.println("Enter role:");
            role = inn.nextLine();
            Matcher match = p.matcher(role);
            if (match.find()) {
                System.out.println("Role must not contain only digits or only special symbols and can't be empty space!");
            } else {
                isValid = true;
            }
        }
        return role;
    }

    private static int getValidId() {
        int id = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter id");
            try {
                id = inn.nextInt();
                valid = true;
            } catch (InputMismatchException ime) {
                System.out.println("Id must contain only numbers!");
                inn.nextLine();
            }
        }
        return id;
    }
    private static String getValidDepartment(){
        String department = null;
        boolean isValid = false;
        Pattern p = Pattern.compile("[\\d\\!\\@\\$\\%\\^\\.\\#\\,\\&\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:]+|\\s{3,}");
        while (!isValid) {
            System.out.println("Enter department:");
            department = inn.nextLine();
            Matcher match = p.matcher(department);
            if (match.find()) {
                System.out.println("Name must not contain digits or special symbols and can't be empty space!");
            } else {
                isValid = true;
            }
        }
        return department;
    }

    private static String getValidName() {
        String name = null;
        boolean isValid = false;
        Pattern p = Pattern.compile("[\\d\\!\\@\\.\\$\\%\\^\\#\\&\\,\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:]+|\\s{2,}");
        while (!isValid) {
            System.out.println("Enter name:");
            name = inn.nextLine();
            Matcher match = p.matcher(name);
            if (match.find()) {
                System.out.println("Name must not contain digits or special symbols and can't be empty space!");
            } else {
                isValid = true;
            }
        }
        return name;
    }
    private static String getValidSurname(){
        String surname = null;
        boolean isValid = false;
        Pattern p = Pattern.compile("[\\d\\!\\@\\$\\%\\#\\^\\&\\.\\,\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:\\s]+");
        while (!isValid) {
            System.out.println("Enter new surname:");
            surname = inn.nextLine();
            Matcher match = p.matcher(surname);
            if (match.find()) {
                System.out.println("Surname must not contain digits, special symbols or empty spaces!");
            } else {
                isValid = true;
            }
        }
        return surname;
    }
    private static double getValidSalary(){
        double salary = 0.00;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter salary:");
            salary = inn.nextDouble();
            if(salary > 0.00) {
                isValid = true;
            }else {
                System.out.println("Salary can't be less than 0.00!");
                inn.nextLine();
            }
        }
        return salary;
    }
}
