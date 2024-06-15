package io.github.ndimovt.classes.task3;

public class BankAccount {
    private static int nextId = 1;
    private int id;
    private static double interestRate = 0.02;
    private double balance;

    public BankAccount() {
        this.id = nextId++;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public double getInterestRate(int years) {
        return this.balance * years * interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public int getId() {
        return this.id;
    }
}
