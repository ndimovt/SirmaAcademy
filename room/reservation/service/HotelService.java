package io.github.ndimovt.room.reservation.service;

import io.github.ndimovt.room.reservation.BookingInformation;
import io.github.ndimovt.room.reservation.User;
import io.github.ndimovt.room.reservation.dbUtils.FileRead;
import io.github.ndimovt.room.reservation.dbUtils.FileWrite;

import java.util.List;
import java.util.Set;

public class HotelService implements Service{
    private FileRead reader;
    private FileWrite writer;

    public HotelService(FileRead reader, FileWrite writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public User userAccCheck(String username){
        return reader.userAcc(username);
    }
    public List<String> reservationHistory(String dateIn, String dateOut, String userName){
        return reader.history(dateIn, dateOut, userName);
    }
    public BookingInformation getActiveReservation(String id, String user){
        return reader.getInfo(id, user);
    }
    public Set<Integer> reservedRooms(){
        return reader.reservedRooms();
    }
    public void createUser(String name, User user){
        writer.createUser(name, user);
    }
    public void saveClientHistory(String name, BookingInformation bi){
        writer.writeClientHistory(name, bi);
    }
    public void updateBalance(String userName, double newBalance){
        writer.updateMoneyBalance(userName, newBalance);
    }
    public String canceledReservation(String name, String list){
        return writer.canceled(name, list);
    }
}
