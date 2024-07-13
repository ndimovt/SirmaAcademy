package io.github.ndimovt.midexam;

import java.io.*;
import java.util.Map;

public class EmployeeWriter implements Writeable{

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
            fnf.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
}