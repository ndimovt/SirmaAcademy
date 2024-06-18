package io.github.ndimovt.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerCustomObj {
    public static void main(String[] args) {
        SerCustomObj sco = new SerCustomObj();
        List<Person> list = new ArrayList<>();
        sco.populateList(list);
        sco.serialize(list);
        List<Person> result = sco.deserialize();
        result.forEach(System.out::println);
    }
    private void populateList(List<Person> list) {
        list.add(new Person("Ivan", 10));
        list.add(new Person("Nikolay", 20));
        list.add(new Person("Petar", 30));
        list.add(new Person("Georgi", 40));
        list.add(new Person("Ivo", 50));
    }
    private void serialize(List<Person> myList) {
        String path = "C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams";
        File file = new File(path, "persons.ser");
        if (!file.exists()) {
            try {
                file.createNewFile();
                ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
                ous.writeObject(myList);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }
    private List<Person> deserialize() {
        String path = "C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\persons.ser";
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            return (List<Person>) ois.readObject();
        } catch (IOException ie) {
            ie.printStackTrace();
        }catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
        return null;
    }
}
