package io.github.ndimovt.room.reservation;

import io.github.ndimovt.room.reservation.dbUtils.DBRead;
import io.github.ndimovt.room.reservation.dbUtils.DBWrite;
import io.github.ndimovt.room.reservation.roomInfo.RoomPrice;

import java.util.Scanner;

public class Menu {
    private static Scanner inn = new Scanner(System.in);
    private static DBWrite dbWrite = new DBWrite();
    private static DBRead dbRead = new DBRead();
    public static void main(String[] args) {
        System.out.println("Welcome to Grand Hotel!");
        System.out.println("Register or log in! 1)Register  2)LogIn");
        int choice = inn.nextInt();
        if(choice == 1){
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
            User user = new User(username, pass, name, surname, deposit);
            dbWrite.createUser(user.getUsername(), user);
        } else if (choice == 2) {
            System.out.println("Enter username: ");
            inn.nextLine();
            String username = inn.nextLine();
            System.out.println("Enter password: ");
            String pass = inn.nextLine();
            User u = dbRead.userAcc(username);
            if(u.getUsername().equals(username) && u.getPassword().equals(pass)){
                System.out.println("Welcome "+ u.getName());
                System.out.println("Select floor: ");
                int floor = inn.nextInt();
                inn.nextLine();
                System.out.println("Select room: ");
                String room = inn.nextLine();
                System.out.println("Enter date you want to check in(day.month.year): ");
                String dateIn = inn.nextLine();
                System.out.println("Enter date you want to check out: ");
                String dateOut = inn.nextLine();
                System.out.println(totalPrice(room, dateIn, dateOut));
                BookingInformation bookInfo = new BookingInformation(u.getUsername(), room, dateIn, dateOut);
                dbWrite.writeClientHistory(u.getUsername(), bookInfo);
            }
        }else{
            System.out.println("Invalid choice!");
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


}
