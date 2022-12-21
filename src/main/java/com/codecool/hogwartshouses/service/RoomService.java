package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.data_sample.RoomCreator;
import com.codecool.hogwartshouses.model.Room;
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

    RoomService (RoomCreator roomCreator, RoomDAO roomDAO, RoomMemory roomMemory) {
        this.roomCreator = roomCreator;
        this.roomDAO = roomDAO;
        this.roomMemory = roomMemory;
        createAndAddRooms();
    }

    public void createAndAddRooms() {
        for (int i = 0; i < 50; i++) {
            roomCreator.initialize();
        }
    }

}
