package io.github.ndimovt.room.reservation.service;

import io.github.ndimovt.room.reservation.BookingInformation;
import io.github.ndimovt.room.reservation.User;

import java.util.List;
import java.util.Set;

public interface Service {
    User userAccCheck(String username);
    List<String> reservationHistory(String dateIn, String dateOut, String userName);
    BookingInformation getActiveReservation(String id, String user);
    Set<Integer> reservedRooms();
    void createUser(String name, User user);
    void saveClientHistory(String name, BookingInformation bi);
    void updateBalance(String userName, double newBalance);
    String canceledReservation(String name, String list);
}
