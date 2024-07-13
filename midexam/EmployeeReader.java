package io.github.ndimovt.midexam;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class EmployeeReader implements Readable{
    private final File file = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\midexam\\employees.csv");
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
            fnf.printStackTrace();
        }
        return String.format("Employee with id:%d does not exist or no longer working in the firm!",id);
    }
    public List<Employee> readByName(String name){
        List<Employee> employees = new ArrayList<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] result = line.split(",");
                if(result[1].equals(name) && result[3].equals("null")){
                    employees.add(new Employee(
                            Integer.parseInt(result[0]), result[1], LocalDate.parse(result[2]), (result[3].equals("null")? "null" : result[3]),
                            result[4], result[5], Double.parseDouble(result[6])
                    ));
                }
            }
        }catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        return employees;
    }
    public List<Employee> readByDepartment(String department){
        List<Employee> departments = new ArrayList<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] result = line.split(",");
                if(result[4].equals(department) && result[3].equals("null")){
                    departments.add(new Employee(
                            Integer.parseInt(result[0]), result[1], LocalDate.parse(result[2]),  (result[3].equals("null")? "null" : result[3]),
                            result[4], result[5], Double.parseDouble(result[6])
                    ));
                }
            }
        }catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        return departments;
    }
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
            fnf.printStackTrace();
        }
        return employeesMap;
    }
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
            fnf.printStackTrace();
        }
        return employeesMap;
    }
}
