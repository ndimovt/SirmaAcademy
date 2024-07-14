package io.github.ndimovt.midexam.io;

import io.github.ndimovt.midexam.employee.Employee;

import java.io.*;
import java.util.Map;

/**
 * Process writing of a map to a file
 *
 */
public class EmployeeWriter implements Writeable {
    /**
     * Writes map content to .csv file
     *
     * @param map with records to be written
     */
    public void write(Map<Integer, Employee> map){
        File file = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\midexam\\employees.csv");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            map.forEach((k,v) -> {
                try{
                writer.write(v.toString());
                writer.newLine();
            }catch (IOException ie){
                    ie.printStackTrace();
                }});
        }catch (FileNotFoundException fnf){
            System.out.println("File no present! Please contact your IT support!");
            fnf.printStackTrace();
            System.exit(0);
        }catch (IOException ie){
            System.out.println("Error 404!");
            ie.printStackTrace();
            System.exit(0);
        }
    }
}
