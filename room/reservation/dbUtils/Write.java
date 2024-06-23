package io.github.ndimovt.room.reservation.dbUtils;

import io.github.ndimovt.room.reservation.BookingInformation;
import io.github.ndimovt.room.reservation.User;

public interface Write {
    void createUser(String name, User user);
    void writeClientHistory(String name, BookingInformation bi);
}
