package io.github.ndimovt.streams;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SerDeserMap {
    public static void main(String[] args) {
        SerDeserMap sdm = new SerDeserMap();
        Map<String, Integer> humans = new HashMap<>();
        sdm.populateMap(humans);
        sdm.serialize(humans);
        Map<String, Integer> result = sdm.deserialize();
        result.forEach((k,v) -> System.out.println(k+" : "+v));

    }

    private void populateMap(Map<String, Integer> myMap) {
        myMap.put("Ivan", 10);
        myMap.put("Nikolay", 20);
        myMap.put("Petar", 30);
        myMap.put("Georgi", 40);
        myMap.put("Ivo", 50);
    }

    private void serialize(Map<String, Integer> map) {
        String path = "C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams";
        File file = new File(path, "map.ser");
        if (!file.exists()) {
            try {
                file.createNewFile();
                ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
                ous.writeObject(map);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }

    private Map<String, Integer> deserialize() {
        String path = "C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\map.ser";
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            return (Map<String, Integer>) ois.readObject();
        } catch (IOException ie) {
            ie.printStackTrace();
        }catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
        return null;
    }
}
