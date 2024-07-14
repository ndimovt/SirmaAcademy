package io.github.ndimovt.midexam.employee;

import java.time.LocalDate;

/**
 * The Employee class
 *
 */
public class Employee {
    private int id;
    private String name;
    private LocalDate startDate;
    private String endDate;
    private String department;
    private String role;
    private double salary;

    /**
     * Instantiating Employee
     *
     * @param id Integer value
     * @param name String object
     * @param startDate LocalDate instance
     * @param endDate String object
     * @param department String object
     * @param role String object
     * @param salary Double value
     */
    public Employee(int id, String name, LocalDate startDate, String endDate, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    /**
     * return id
     *
     * @return Integer value
     */
    public int getId() {
        return id;
    }

    /**
     * return name
     *
     * @return String object
     */
    public String getName() {
        return name;
    }

    /**
     * update name
     *
     * @param name String object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * update role
     *
     * @param role String object
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * update salary
     *
     * @param salary Double value
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * update firing date
     *
     * @param endDate updates EndDate param
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * update department
     *
     * @param department the unique identifier of the employee whose data is to be read
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * return Employee as String
     *
     * @return String object
     */
    @Override
    public String toString() {
        return id+","+name+","+ startDate +","+ endDate +","+ department +","+role +","+ salary;
    }
}
