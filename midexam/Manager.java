package io.github.ndimovt.midexam;

public interface Manager {
    void updateEmployeeDepartment(int id, String department);
    void updateEmployeeRole(int id, String role);
    void updateEmployeeSalary(int id, double salary);
    void updateEmployeeSurname(int id, String surname);
    void fireEmployee(int id);
}
