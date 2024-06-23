package io.github.ndimovt.room.reservation;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String name;
    private String surname;
    private double deposit;

    public User(String username, String password, String name, String surname, double deposit) {
        if(username != null) {
            this.username = username;
        }
        if(password != null && (password.length() > 5)) {
            this.password = password;
        }
        this.name = name;
        this.surname = surname;
        this.deposit = deposit;
    }
    public String getUsername() {
        return username;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
