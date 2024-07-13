package io.github.ndimovt.midexam;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
    private int id;
    private String name;
    private LocalDate startDate;
    private String endDate;
    private String department;
    private String role;
    private double salary;

    public Employee(int id, String name, LocalDate startDate, String endDate, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    @Override
    public String toString() {
        //String endDate = (this.endDate == null)? "null" : String.format("%d-%d-%d",this.startDate.getYear(), this.startDate.getMonthValue(), this.startDate.getDayOfMonth());
        return id+","+name+","+ startDate +","+ endDate +","+ department +","+role +","+ salary;
    }
}
