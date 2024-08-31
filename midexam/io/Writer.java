package io.github.ndimovt.midexam.io;

import io.github.ndimovt.midexam.employee.Employee;

import java.io.IOException;
import java.util.Map;

/**
 * Writeable interface
 *
 */
public interface Writer {
    /**
     * Write contents of a Map
     *
     * @param employeeMap Map with records to be written on a file
     */
    void write(Map<Integer, Employee> employeeMap) throws IOException;
}
