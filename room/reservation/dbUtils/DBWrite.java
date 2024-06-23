package io.github.ndimovt.room.reservation.dbUtils;

import io.github.ndimovt.room.reservation.BookingInformation;
import io.github.ndimovt.room.reservation.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class DBWrite implements Write{
    private DBRead dbr = new DBRead();
    private File dir = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\userAccounts");
    public void createUser(String name, User user){
        File file = null;
        if(!dir.getName().equals(name)) {
            file = new File(dir, name + ".txt");
        }else{
            System.out.println("Username "+name+" already exists!");
        }
        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream ous = new ObjectOutputStream(fos)){
            ous.writeObject(user);
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
    public void writeClientHistory(String name, BookingInformation bi, String status){
        File file = null;
        if(!dir.getName().equals(name)) {
            file = new File(dir, name + "History.txt");
        }else{
            System.out.println("Username "+name+" already exists!");
        }
        try(BufferedWriter bwr = new BufferedWriter(new FileWriter(file, true))){
            bwr.newLine();
            bwr.write(bi.toString());
            bwr.write(status);
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
    public void updateMoneyBalance(String userName, double newBalance){
        User user = dbr.userAcc(userName);
        user.setDeposit(newBalance);
        File file = null;
        if(!dir.getName().equals(userName)) {
            file = new File(dir, userName + ".txt");
        }else{
            System.out.println("Username "+userName+" already exists!");
        }
        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream ous = new ObjectOutputStream(fos)){
            ous.writeObject(user);
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }

}
