package io.github.ndimovt.room.reservation.dbUtils;

import io.github.ndimovt.room.reservation.BookingInformation;
import io.github.ndimovt.room.reservation.User;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DBRead implements Read{
    private User user;
    private File dir = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\userAccounts");
    public User userAcc(String username){
        File file = null;
        if(!dir.getName().equals(username)) {
            file = new File(dir, username + ".txt");
        }else{
            System.out.println("Username "+username+" already exists!");
        }
        try(FileInputStream fis = new FileInputStream((file));
            ObjectInputStream ois = new ObjectInputStream(fis)){
            user = (User) ois.readObject();

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return user;
    }
    public List<String> history(String dateIn, String dateOut, String userName){
        File file = new File(dir, userName + "History.txt");;
        List<String> roomHistory = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = null;
            while((line = br.readLine()) != null){
                if(line.contains(dateIn) && line.contains(dateOut) && !line.contains(" - canceled")) {
                    roomHistory.add(line);
                }
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return roomHistory;
    }
    public BookingInformation getInfo(String id, String user){
        File file = new File(dir, user + "History.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = null;
            while((line = br.readLine()) != null){
                if(line.contains(id) && !line.contains(" - canceled")) {
                    String[] object = line.split(" ");
                    return new BookingInformation(object[1], object[2], object[3], Double.parseDouble(object[4]));
                }
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return null;
    }


}
