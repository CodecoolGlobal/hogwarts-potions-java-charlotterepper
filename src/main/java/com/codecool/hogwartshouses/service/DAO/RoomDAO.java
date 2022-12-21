package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;

import java.util.Set;

public interface RoomDAO {
    Set<Room> getAllRooms();
    void addRoom(Room room);
    Room getRoom(int id);
}