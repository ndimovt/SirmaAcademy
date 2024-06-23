package io.github.ndimovt.room.reservation.dbUtils;

import io.github.ndimovt.room.reservation.BookingInformation;
import io.github.ndimovt.room.reservation.User;

import java.util.List;

public interface Read {
    User userAcc(String username);
    List<String> history(String dateIn, String dateOut, String userName);
    BookingInformation getInfo(String id, String user);
}
