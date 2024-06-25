package io.github.ndimovt.room.reservation.dbUtils;

import io.github.ndimovt.room.reservation.BookingInformation;
import io.github.ndimovt.room.reservation.User;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRead implements Read{
    private Set<Integer> unavailableRooms = new TreeSet<>();
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
    public Set<Integer> reservedRooms() {
        Set<Integer> unavailableRooms = new TreeSet<>();
        Pattern pattern = Pattern.compile(".*History\\.txt");

        try {
            File[] clientHistory = files(dir);
            for(File file : clientHistory){
                Matcher match = pattern.matcher(file.getName());
                if (match.matches()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (!line.contains(" - canceled")) {
                                String[] parts = line.split("\\s+");
                                if (parts.length > 1) {
                                    String roomPart = parts[1];
                                    String[] date = parts[3].split("\\.");
                                    String roomNumberStr = roomPart.replaceAll("[^\\d]", "");
                                    int endDate = Integer.parseInt(date[0]) + Integer.parseInt(date[1]) + Integer.parseInt(date[2]);
                                    if (!roomNumberStr.isEmpty() && (endDate - getCurrentDate() > 0)) {
                                        try {
                                            int roomNumber = Integer.parseInt(roomNumberStr);
                                            unavailableRooms.add(roomNumber);
                                        } catch (NumberFormatException e) {
                                            System.err.println("Invalid room number format in line: " + line);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        } catch (NullPointerException npe) {
            System.out.println("No history records for this user!");
        }
        return unavailableRooms;
    }
    private int getCurrentDate(){
        Date d = new Date();
        return d.getDay() + d.getMonth() + d.getYear();
    }
    private File[] files(File fileDir){
        if(fileDir.isDirectory()){
            return fileDir.listFiles();
        }
        return null;
    }
}
