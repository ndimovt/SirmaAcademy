package io.github.ndimovt.exc5.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BankTest {
    private static Scanner inn = new Scanner(System.in);
    private static HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private static ArrayList<String> actionsArchive = new ArrayList<>();

    public static void main(String[] args) {
        BankTest bt = new BankTest();
        boolean isTrue  = true;
        while (isTrue){
            String[] account = inn.nextLine().split(" ");
            switch (account[0]){
                case "Create":
                    bt.createAccount();
                    break;
                case "Deposit":
                    int accKey = Integer.parseInt(account[1]);
                    double amount = Double.parseDouble(account[2]);
                    bt.deposit(accKey, amount);
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(account[1]);
                    bt.setNewInterestRate(newInterest);
                    break;
                case "GetInterest":
                    int accId = Integer.parseInt(account[1]);
                    int year = Integer.parseInt(account[2]);
                    bt.getInterest(accId, year);
                    break;
                case "End":
                    isTrue = false;
                    printActions();
                default:
                    break;
            }
        }
    }
    public void createAccount(){
        BankAccount ba = new BankAccount();
        accounts.put(ba.getId(), ba);
        actionsArchive.add(String.format("Account ID%d created",  ba.getId()));
    }
    public void deposit(int id, double amount){
        BankAccount bb = accounts.get(id);
        if(bb != null){
            bb.deposit(amount);
            actionsArchive.add(String.format("Deposited %.2f to ID%d",amount, id));
        }else{
            actionsArchive.add(String.format("Account wit ID%d does not exist",id));
        }
    }
    public void setNewInterestRate(double rate){
        BankAccount.setInterestRate(rate);
    }
    public void getInterest(int id, int years){
        BankAccount ba = accounts.get(id);
        double rate = ba.getInterestRate(years);
        actionsArchive.add(String.valueOf(rate));
    }
    private static void printActions(){
        for(String action : actionsArchive){
            System.out.println(action);
        }
    }
}
