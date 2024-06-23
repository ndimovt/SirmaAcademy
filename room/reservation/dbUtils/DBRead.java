package io.github.ndimovt.room.reservation.dbUtils;

import io.github.ndimovt.room.reservation.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
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


}
