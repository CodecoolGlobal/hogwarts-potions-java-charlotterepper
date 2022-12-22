package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoomMemory implements RoomDAO {
    private final Set<Room> rooms;

    public RoomMemory(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public Set<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public Room getRoom(int id) {
        List<Room> roomList = rooms.stream()
                .filter(room -> room.getId() == id)
                .collect(Collectors.toList());
        return roomList.get(0);
    }

    @Override
    public void deleteRoom(int id) {
        List<Room> roomList = rooms.stream()
                .filter(room -> room.getId() == id)
                .collect(Collectors.toList());
        Room room = roomList.get(0);
        rooms.remove(room);
    }
}
