package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.data_sample.RoomCreator;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomService {
    private final RoomDAO roomDAO;

    private final RoomCreator roomCreator;
    private final RoomMemory roomMemory;
    private final int MAX_AMOUNT_ROOMS = 20;

    RoomService (RoomCreator roomCreator, RoomDAO roomDAO, RoomMemory roomMemory) {
        this.roomCreator = roomCreator;
        this.roomDAO = roomDAO;
        this.roomMemory = roomMemory;
        createAndAddRooms();
    }

    public void createAndAddRooms() {
        for (int i = 0; i < MAX_AMOUNT_ROOMS; i++) {
            roomCreator.initialize();
        }
    }

    public void createAndAddRoom() {
        roomCreator.initialize();
    }

    public void updateRoom(int id, String name, HouseType houseType, int capacity) {
        roomMemory.deleteRoom(id);
        Room room = roomCreator.createCustomRoomWithId(id, name, houseType, capacity);
        roomMemory.addRoom(room);
    }

}
