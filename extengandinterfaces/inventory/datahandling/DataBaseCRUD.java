package io.github.ndimovt.extengandinterfaces.inventory.datahandling;

import io.github.ndimovt.extengandinterfaces.inventory.entities.InventoryItem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataBaseCRUD implements CRUD{
    private static final File DATABASE = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\extengandinterfaces\\inventory\\storage\\storage.txt");
    private static final File UNFIT = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\extengandinterfaces\\inventory\\storage\\unfitForSale.txt");

    public void create(Map<Integer, InventoryItem> map){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE, true))){
            map.forEach((k,v) -> {
                try {
                    writer.write(v.getDetails());
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
    public void itemUnfitForSale(Map<Integer, InventoryItem> map){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(UNFIT))){
            map.forEach((k,v) -> {
                try {
                    writer.write(v.getDetails());
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
    public Map<Integer, String> read(){
        Map<Integer, String> items = new HashMap<>();
        try{
            List<String> list =  Files.readAllLines(Paths.get(DATABASE.toString()));
            for(String s : list){
                String[] arr = s.split("/");
                items.put(Integer.parseInt(arr[0]), s);
            }
            return items;
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return null;
    }
    public void delete(int id) {
        try {
            List<String> content = Files.readAllLines(Paths.get(DATABASE.toString()));
            List<String> updated = content.stream().filter(line -> !line.startsWith(String.valueOf(id))).collect(Collectors.toList());
            Files.write(DATABASE.toPath(), updated);
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
    public void updateQuantity(int id, int quantity, Map<Integer, String> map){
        if(map.containsKey(id)){
            StringBuilder sb = new StringBuilder();
            String[] value = map.get(id).split("/");
            int oldQuantity = Integer.parseInt(value[1]);
            if(oldQuantity - quantity >= 0) {
                value[1] = String.valueOf(oldQuantity - quantity);
                for (String s : value) {
                    sb.append(s).append("/");
                }
                map.put(id, sb.toString());
            }else{
                System.out.println("Shop does not have enough quantity. Please check catalogue or enter less quantity!");
            }
        }
    }
    public void removeItem(Map<Integer, String> map, int id){
        if(map.containsKey(id)){
            map.remove(id);
        }else{
            System.out.println("Item with id: "+id+" is not existing!");
        }
    }

}
