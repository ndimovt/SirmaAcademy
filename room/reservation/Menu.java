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
        boolean isWorking = true;
        System.out.println("Welcome to Grand Hotel!");
        while(isWorking){
            System.out.println("Choose option - 1)Register  2)LogIn 3)Check Available rooms 4) Exit");
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
                    User user = new User(username, pass, name, surname, deposit);
                    dbWrite.createUser(user.getUsername(), user);
                    break;
                case 2:
                    System.out.println("Enter username: ");
                    inn.nextLine();
                    String userName = inn.nextLine();
                    System.out.println("Enter password: ");
                    String password = inn.nextLine();
                    User u = dbRead.userAcc(userName);
                    if(u.getUsername().equals(userName) && u.getPassword().equals(password)){
                        System.out.println("Welcome "+ u.getName());
                        System.out.println("1)Check available rooms 2)Make reservation 3)Check money balance 4)Add money 5)Cancel reservation");
                        boolean isChosen = true;
                        while (isChosen){
                            int userChoice = inn.nextInt();
                            switch (userChoice){
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("Select floor: ");
                                    int floor = inn.nextInt();
                                    inn.nextLine();
                                    System.out.println("Select room: ");
                                    String room = inn.nextLine();
                                    System.out.println("Enter date you want to check in(day.month.year): ");
                                    String dateIn = inn.nextLine();
                                    System.out.println("Enter date you want to check out: ");
                                    String dateOut = inn.nextLine();
                                    BookingInformation bookInfo = new BookingInformation(u.getUsername(), room, dateIn, dateOut);
                                    dbWrite.writeClientHistory(u.getUsername(), bookInfo);
                                    double toPay = totalPrice(room, dateIn, dateOut);
                                    System.out.println("Total cost will be: "+toPay);
                                    double result = u.getDeposit() - toPay;
                                    if(result >= 0){
                                        System.out.println("Room successfully booked");
                                        dbWrite.updateMoneyBalance(u.getUsername(), result);
                                    }else{
                                        System.out.println("Don't have enough money for this transaction!");
                                    }
                                    break;
                                case 3:
                                    System.out.println("You have "+u.getDeposit()+"lv.");
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    isChosen = false;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }else{
                        System.out.println("Account with this username does not exists!");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    isWorking = false;
                    break;
                default:
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


}
