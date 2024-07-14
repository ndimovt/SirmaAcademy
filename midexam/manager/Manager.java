package io.github.ndimovt.midexam.manager;

/**
 * The Manager Interface
 *
 */
public interface Manager {
    /**
     * Updating department
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param department the new parameter
     */
    void updateEmployeeDepartment(int id, String department);

    /**
     * Updating role
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param role the new parameter
     */
    void updateEmployeeRole(int id, String role);

    /**
     * Updating salary
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param salary the new parameter
     */
    void updateEmployeeSalary(int id, double salary);

    /**
     * Updating surname
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @param surname the new parameter
     */
    void updateEmployeeSurname(int id, String surname);

    /**
     * Firing employee
     *
     * @param id the unique identifier of the employee whose data is to be read
     */
    void fireEmployee(int id);
}
