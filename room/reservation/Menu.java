package io.github.ndimovt.room.reservation;

import io.github.ndimovt.room.reservation.dbUtils.FileRead;
import io.github.ndimovt.room.reservation.dbUtils.FileWrite;
import io.github.ndimovt.room.reservation.hotelschema.PrintRoomSchema;
import io.github.ndimovt.room.reservation.roomInfo.RoomPrice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private static final double COMPENSATION = 0.5;
    private static Scanner inn = new Scanner(System.in);
    private static FileWrite fileWrite = new FileWrite();
    private static FileRead fileRead = new FileRead();
    private static Set<Integer> available = new TreeSet<>();
    private static Set<Integer> unavailable;
    public static void main(String[] args) {
        boolean isWorking = true;
        System.out.println("Welcome to Grand Hotel!");
        while(isWorking){
            populateSet();
            unavailable  = fileRead.reservedRooms();
            System.out.println("Choose option - 1)Register  2)LogIn 3)Check room prices 4) Exit");
            int choice = inn.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter username: ");
                    inn.nextLine();
                    String username = inn.nextLine();
                    System.out.println("Enter password (Must be longer than 5 symbols): ");
                    String pass = inn.nextLine();
                    System.out.println("Enter name: ");
                    String name = inn.nextLine();
                    System.out.println("Enter surname: ");
                    String surname = inn.nextLine();
                    System.out.println("Enter deposit: ");
                    double deposit = inn.nextDouble();
                    if(deposit >= 0){
                        User user = new User(username, pass, name, surname, deposit);
                        fileWrite.createUser(user.getUsername(), user);
                    }else{
                        System.out.println("Enter sum bigger or equal to 0.0lv!");
                    }

                    break;
                case 2:
                    System.out.println("Enter username: ");
                    inn.nextLine();
                    String userName = inn.nextLine();
                    System.out.println("Enter password: ");
                    String password = inn.nextLine();
                    User u = fileRead.userAcc(userName);
                    if(u.getUsername().equals(userName) && u.getPassword().equals(password)){
                        System.out.println("Welcome "+ u.getName());
                        System.out.println("1)Check available rooms 2)Make reservation 3)Check money balance 4)Add money 5)Cancel reservation 6)Return to main menu");
                        boolean isChosen = true;
                        while (isChosen){
                            int userChoice = inn.nextInt();
                            switch (userChoice) {
                                case 1:
                                    removeDuplicates(available, unavailable);
                                    printRooms(available);
                                    break;
                                case 2:
                                    System.out.println("Select floor: ");
                                    int floor = inn.nextInt();
                                    inn.nextLine();
                                    if(floor >= 1 && floor < 6){
                                        PrintRoomSchema roomSchema = new PrintRoomSchema();
                                        roomSchema.printFloor(floor);
                                    }
                                    System.out.println("Select room: ");
                                    String room = inn.nextLine();
                                    int takenRoom = 0;
                                    try {
                                        takenRoom = Integer.parseInt(room.substring(0, room.length() - 1));
                                    }catch (NumberFormatException nfe){
                                        System.out.println("Enter valid room!");
                                    }
                                    if (!unavailable.contains(takenRoom)) {
                                        System.out.println("Enter date you want to check in(day.month.year): ");
                                        String dateIn = inn.nextLine();
                                        System.out.println("Enter date you want to check out(day.month.year): ");
                                        String dateOut = inn.nextLine();
                                        if(checkDate(dateIn) && checkDate(dateOut)){
                                            double toPay = totalPrice(room, dateIn, dateOut);
                                            BookingInformation bookInfo = new BookingInformation(u.getUsername(), room, dateIn, dateOut, toPay);
                                            fileWrite.writeClientHistory(u.getUsername(), bookInfo);
                                            System.out.println("Total cost will be: " + toPay);
                                            double result = u.getDeposit() - toPay;
                                            if (result >= 0) {
                                                System.out.println("Room successfully booked");
                                                fileWrite.updateMoneyBalance(u.getUsername(), result);
                                                available.remove(takenRoom);
                                                unavailable.add(takenRoom);
                                            } else {
                                                System.out.println("Don't have enough money for this transaction!");
                                            }
                                        } else{
                                            System.out.println("Invalid date format!");
                                        }
                                    }else {
                                        System.out.println("Room " + takenRoom + " already reserved!");
                                    }
                                    break;
                                case 3:
                                    System.out.println("You have " + u.getDeposit() + "lv.");
                                    break;
                                case 4:
                                    System.out.println("Enter money amount you want to insert");
                                    double amount = inn.nextDouble();
                                    if(amount > 0){
                                        fileWrite.updateMoneyBalance(u.getUsername(), amount + u.getDeposit());
                                        System.out.println("Operation successful!");
                                    }else{
                                        System.out.println("Enter valid sum bigger than 0.0lv !");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Select room: ");
                                    inn.nextLine();
                                    String cancel = inn.nextLine();
                                    int removeRoom = 0;
                                    try {
                                        removeRoom = Integer.parseInt(cancel.substring(0, cancel.length() - 1));
                                    }catch (NumberFormatException nfe){
                                        System.out.println("Enter valid room!");
                                    }
                                    if(unavailable.contains(removeRoom)){
                                        System.out.println("Enter starting date (day.month.year): ");
                                        String dateIn = inn.nextLine();
                                        System.out.println("Enter ending date (day.month.year): ");
                                        String dateOut = inn.nextLine();
                                        if (checkDate(dateIn) && checkDate(dateOut)) {
                                            List<String> list = fileRead.history(dateIn, dateOut, u.getUsername());
                                            list.forEach(System.out::println);
                                            System.out.println("Enter reservation id: ");
                                            String id = inn.nextLine();
                                            BookingInformation bookInfo = fileRead.getInfo(id, u.getUsername());
                                            System.out.println(fileWrite.canceled(u.getUsername(), bookInfo.toString()));
                                            double returnMoney = (bookInfo.getPrice() * COMPENSATION) + u.getDeposit();
                                            fileWrite.updateMoneyBalance(u.getUsername(), returnMoney);
                                            unavailable.remove(removeRoom);
                                            available.add(removeRoom);
                                        }else{
                                            System.out.println("Date format not valid!");
                                        }
                                    }else{
                                        System.out.println("No such room in database!");
                                    }

                                    break;
                                case 6:
                                    isChosen = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                                    break;
                            }
                        }
                    }else{
                        System.out.println("Account with this username does not exists!");
                    }
                    break;
                case 3:
                    System.out.println("S - Room with one bed - 50.00lv per night!");
                    System.out.println("D - Room with two bed - 100.00lv per night!");
                    System.out.println("T - Room with three bed - 150.00lv per night!");
                    System.out.println("F - Room with four bed - 200.00lv per night!");
                    System.out.println("V - VIP room with 2/3 beds - 300.00lv per night!");
                    break;
                case 4:
                    isWorking = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
    private static double totalPrice(String room, String dateIn, String dateOut){
        String[] in = dateIn.split("\\.");
        String[] out = dateOut.split("\\.");
        String roomType = room.substring(room.length()-1);
        int begin = Integer.parseInt(in[0]) + Integer.parseInt(in[1]) + Integer.parseInt(in[2]);
        int end = Integer.parseInt(out[0]) + Integer.parseInt(out[1]) + Integer.parseInt(out[2]);
        int period = end - begin;
        switch (roomType){
            case "S":
                return period * RoomPrice.SINGLE.getPrice();
            case "D":
                return period * RoomPrice.DOUBLE.getPrice();
            case "T":
                return period * RoomPrice.TRIPLE.getPrice();
            case "F":
                return period * RoomPrice.FOUR.getPrice();
            case "V":
                return period * RoomPrice.VIP.getPrice();
            default:
                break;
        }
        return 0.0;
    }
    private static void populateSet(){
        for (int i = 101; i < 124 ; i++) {
            available.add(i);
        }
        for (int i = 201; i < 224 ; i++) {
            available.add(i);
        }
        for (int i = 301; i < 324; i++) {
            available.add(i);
        }
        for (int i = 401; i < 424; i++) {
            available.add(i);
        }
        for (int i = 501; i < 524; i++) {
            available.add(i);
        }
    }
    private static void printRooms(Set<Integer> set){
        for(int i : set){
            System.out.print(i +" ");
        }
        System.out.println();
    }
    private static boolean checkDate(String dateToCheck){
        String regex = "\\b(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(dateToCheck);
        if(match.matches()){
            return true;
        }
        return false;
    }
    private static void removeDuplicates(Set<Integer> first, Set<Integer> second){
        first.removeAll(second);
    }

}
