package io.github.ndimovt.extengandinterfaces.inventory.datahandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SortOrder {
    private static final File DATABASE = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\extengandinterfaces\\inventory\\storage\\storage.txt");

    public Map<Integer, String> byCategory(Map<Integer, String> map, String category){
        map = new TreeMap<>();
        try{
            List<String> list =  Files.readAllLines(Paths.get(DATABASE.toString()));
            for(String s : list){
                String[] arr = s.split("/");
                if(arr[4].equalsIgnoreCase(category)){
                    map.put(Integer.parseInt(arr[0]), s);
                }
            }
            return map;
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return null;
    }
    public Map<String, String> byName(){
        Map<String, String> map = new TreeMap<>();
        try{
            List<String> list =  Files.readAllLines(Paths.get(DATABASE.toString()));
            for(String s : list){
                String[] arr = s.split("/");
                map.put(arr[2], s);
            }
            return map;
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return null;
    }

    public Map<Double, String> byPrice(){
        Map<Double, String> map = new TreeMap<>();
        try{
            List<String> list =  Files.readAllLines(Paths.get(DATABASE.toString()));
            for(String s : list){
                String[] arr = s.split("/");
                map.put(Double.parseDouble(arr[5]), s);
            }
            return map;
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return null;
    }
}
