package io.github.ndimovt.midexam.io;

import io.github.ndimovt.midexam.employee.Employee;

import java.util.Map;

public interface Writeable {
    void write(Map<Integer, Employee> employeeMap);
}
