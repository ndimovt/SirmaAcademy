package io.github.ndimovt.midexam.io;

import io.github.ndimovt.midexam.employee.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Processing the Readable incoming requests
 *
 */
public class EmployeeReader implements Readable {
    private final File file = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\midexam\\employees.csv");

    /**
     * Returns String representation of object found by id
     *
     * @param id the unique identifier of the employee whose data is to be read
     * @return String or else alert message
     */
    public String readById(int id){
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] result = line.split(",");
                if(Integer.parseInt(result[0]) == id && result[3].equals("null")){
                    return line;
                }
            }
        }catch (FileNotFoundException fnf){
            System.out.println("File no present! Please contact your IT support!");
            fnf.printStackTrace();
            System.exit(0);
        }
        return String.format("Employee with id:%d does not exist or no longer working in the firm!",id);
    }

    /**
     * Returns List of Employees with a given name
     *
     * @param name the unique identifier of the employee whose data is to be read
     * @return List with records
     */
    public List<Employee> readByName(String name){
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader bfr = new BufferedReader(new FileReader(file))){
            String line = null;
            while((line = bfr.readLine()) != null){
                String[] result = line.split(",");
                if(result[1].equalsIgnoreCase(name) && result[3].equals("null")){
                    employees.add(new Employee(
                            Integer.parseInt(result[0]), result[1], LocalDate.parse(result[2]), (result[3].equals("null")? "null" : result[3]),
                            result[4], result[5], Double.parseDouble(result[6])
                    ));
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
        return employees;
    }

    /**
     * Returns List of Employees with a given name
     *
     * @param department the unique identifier of the employee whose data is to be read
     * @return List with records
     */
    public List<Employee> readByDepartment(String department){
        List<Employee> departments = new ArrayList<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] result = line.split(",");
                if(result[4].equalsIgnoreCase(department) && result[3].equals("null")){
                    departments.add(new Employee(
                            Integer.parseInt(result[0]), result[1], LocalDate.parse(result[2]),  (result[3].equals("null")? "null" : result[3]),
                            result[4], result[5], Double.parseDouble(result[6])
                    ));
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
