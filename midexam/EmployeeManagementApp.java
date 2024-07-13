package io.github.ndimovt.midexam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagementApp {
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService(new EmployeeReader(), new EmployeeWriter());
        Map<Integer, Employee> records = service.getAllActiveEmployees();
        Manager manager = new EmployeeManager(service, records);

        System.out.println();
        System.out.println("1)Add employee  2)Search Employee by id " +
                "3)Search Employee by name  4)Search Employee by department " +
                "5)Update employee department  6)Update employee salary" +
                "7)Update employee role  8)Fire employee " +
                "9)Change surname(only for women after marriage/divorce)  10)Check all active employees " +
                "11)Exit");
        boolean isWorking = true;
        while (isWorking){
            int option = inn.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter id");
                    int id = inn.nextInt();
                    if(!records.containsKey(id)) {
                        inn.nextLine();
                        System.out.println("Enter name");
                        String name = inn.nextLine();
                        System.out.println("Enter department");
                        String department = inn.nextLine();
                        System.out.println("Enter role");
                        String role = inn.nextLine();
                        System.out.println("Enter salary");
                        double salary = inn.nextDouble();
                        Employee employee = new Employee(id, name, getDate(), null, department, role, salary);
                        records.put(employee.getId(), employee);
                    }else{
                        System.out.println("Id:"+id+" already exists!");
                    }
                    break;
                case 2:
                    System.out.println("Enter id:");
                    int searchId = inn.nextInt();
                    System.out.println(service.searchEmployeeById(searchId));
                    break;
                case 3:
                    System.out.println("Enter employee name:");
                    inn.nextLine();
                    String employeeName = inn.nextLine();
                    List<Employee> list = service.searchEmployeeName(employeeName);
                    list.forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter department:");
                    inn.nextLine();
                    String byDepartment = inn.nextLine();
                    List<Employee> departmentList = service.searchEmployeeDepartment(byDepartment);
                    departmentList.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter employee id:");
                    int empId = inn.nextInt();
                    System.out.println("Enter new department:");
                    inn.nextLine();
                    String empDepartment = inn.nextLine();
                    manager.updateEmployeeDepartment(empId, empDepartment);
                    break;
                case 6:
                    System.out.println("Enter employee id:");
                    int salaryId = inn.nextInt();
                    System.out.println("Enter new salary:");
                    double newSalary = inn.nextDouble();
                    manager.updateEmployeeSalary(salaryId, newSalary);
                    service.writeEmployee(records);
                    break;
                case 7:
                    System.out.println("Enter employee id:");
                    int roleId = inn.nextInt();
                    System.out.println("Enter new role:");
                    inn.nextLine();
                    String newRole = inn.nextLine();
                    manager.updateEmployeeRole(roleId, newRole);
                    service.writeEmployee(records);
                    break;
                case 8:
                    System.out.println("Enter employee id:");
                    int firedId = inn.nextInt();
                    if(records.containsKey(firedId)){
                        Employee toBeFired = records.get(firedId);
                        toBeFired.setEndDate(getDate().toString());
                        records.put(firedId, toBeFired);
                    }else{
                        System.out.println("Employee with id:"+firedId+"does not exists!");
                    }
                    break;
                case 9:
                    System.out.println("Enter employee id:");
                    int newId = inn.nextInt();
                    System.out.println("Enter new surname:");
                    inn.nextLine();
                    String newSurname = inn.nextLine();
                    if(records.containsKey(newId)){
                        Employee changeName = records.get(newId);
                        String[] currentSurname = changeName.getName().split(" ");
                        currentSurname[1] = newSurname;
                        changeName.setName(currentSurname[0] + " "+currentSurname[1]);
                        records.put(newId, changeName);
                    }else{
                        System.out.println("Employee with id:"+newId+"does not exists!");
                    }
                    break;
                case 10:
                    records.forEach((k,v) -> System.out.println(v));
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
    private static LocalDate getDate(){
        return LocalDate.now();
    }
}
