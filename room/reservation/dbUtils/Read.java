package io.github.ndimovt.room.reservation.dbUtils;

import io.github.ndimovt.room.reservation.User;

public interface Read {
    User userAcc(String username);
}
