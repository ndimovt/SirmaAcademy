package io.github.ndimovt.midexam.io;

import io.github.ndimovt.midexam.employee.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Processing the Readable incoming requests
 *
 */
public class EmployeeReader implements Reader {
    private final File file = new File("employee.csv");

    /**
     * Returns String representation of object found by id
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @return String or else alert message
     */
    public String readById(int id) throws NumberFormatException {
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] result = line.split(",");
                try {
                    int validatedId = Integer.parseInt(result[0]);
                    if (validatedId == id && result[3].equals("null")) {
                        return line;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid data format in line: " + line);
                }
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File not present! Please contact your IT support!");
            fnf.printStackTrace();
            System.exit(0);
        }
        return String.format("Employee with id:%d does not exist or is no longer working in the firm!", id);
    }

    /**
     * Returns List of Employees with a given name
     *
     * @param name the unique identifier of the employee whose data is to be read
     * @return List with records
     */
    public Employee readByName(String name) throws IllegalArgumentException{
        try(BufferedReader bfr = new BufferedReader(new FileReader(file))){
            String line = null;
            while((line = bfr.readLine()) != null){
                String[] result = line.split(",");
                try {
                    if (result[1].equalsIgnoreCase(name) && result[3].equals("null")) {
                        return new Employee(
                                Integer.parseInt(result[0]), result[1], LocalDate.parse(result[2]), "currently employed",
                                result[4], result[5], Double.parseDouble(result[6])
                        );
                    }
                }catch (IllegalArgumentException ie){
                    throw new IllegalArgumentException(name + " does not exist in database!");
                }
            }
        }catch (FileNotFoundException fnf){
            System.out.println("File no present! Please contact your IT support!");
            fnf.printStackTrace();
            System.exit(0);
        }catch (IOException ie){
            System.out.println("File no present! Please contact your IT support!");
            ie.printStackTrace();
        }
        return null;
    }

    /**
     * Returns List of Employees with a given name
     *
     * @param department the unique identifier of the employee whose data is to be read
     * @return List with records
     */
    public List<Employee> readByDepartment(String department) throws IllegalFormatWidthException{
        List<Employee> departments = new ArrayList<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] result = line.split(",");
                try {
                    if (result[4].equalsIgnoreCase(department) && result[3].equals("null")) {
                        departments.add(new Employee(
                                Integer.parseInt(result[0]), result[1], LocalDate.parse(result[2]), "currently employed",
                                result[4], result[5], Double.parseDouble(result[6])
                        ));
                    }
                }catch (IllegalArgumentException ie){
                    throw new IllegalArgumentException("Invalid department data!");
                }
            }
        }catch (FileNotFoundException fnf){
            System.out.println("File no present! Please contact your IT support!");
            fnf.printStackTrace();
            System.exit(0);
        }
        return departments;
    }

    /**
     * Returns Map of active Employees
     *
     * @return map with records
     */
    public Map<Integer, Employee> readActiveEmployees(){
        Map<Integer, Employee> employeesMap = new HashMap<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] result = line.split(",");
                if (result[3].equals("null")) {
                    Employee employee = new Employee(
                            Integer.parseInt(result[0]), result[1], LocalDate.parse(result[2]), result[3],
                            result[4], result[5], Double.parseDouble(result[6]));

                    employeesMap.put(employee.getId(), employee);
                }
            }
        }catch (FileNotFoundException fnf){
            System.out.println("File no present! Please contact your IT support!");
            fnf.printStackTrace();
            System.exit(0);
        }
        return employeesMap;
    }

    /**
     * Returns Map of all Employees
     *
     * @return map with records
     */
    public Map<Integer, Employee> readAllEmployees(){
        Map<Integer, Employee> employeesMap = new HashMap<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] result = line.split(",");
                Employee employee = new Employee(
                        Integer.parseInt(result[0]), result[1], LocalDate.parse(result[2]), (result[3].equals("null") ? "null" : result[3]),
                        result[4], result[5], Double.parseDouble(result[6]));
                employeesMap.put(employee.getId(), employee);
            }
        }catch (FileNotFoundException fnf){
            System.out.println("File no present! Please contact your IT support!");
            fnf.printStackTrace();
            System.exit(0);
        }
        return employeesMap;
    }
}
