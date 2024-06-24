package io.github.ndimovt.room.reservation.dbUtils;

import io.github.ndimovt.room.reservation.BookingInformation;
import io.github.ndimovt.room.reservation.User;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRead implements Read{
    private Set<Integer> unavailableRooms = new TreeSet<>();
    private User user;
    private File dir = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\userAccounts");
    private File floorDir = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\hotelschema");
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
            Files.walkFileTree(dir.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Matcher match = pattern.matcher(file.getFileName().toString());
                    if (match.matches()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(file.toFile()))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                if (!line.contains(" - canceled")) {
                                    String[] parts = line.split("\\s+");
                                    if (parts.length > 1) {
                                        String roomPart = parts[1];
                                        String roomNumberStr = roomPart.replaceAll("[^\\d]", ""); // Remove non-digit characters
                                        if (!roomNumberStr.isEmpty()) {
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
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        return unavailableRooms;
    }
    public static void printFloorSchema(int floor){
        
    }



}
