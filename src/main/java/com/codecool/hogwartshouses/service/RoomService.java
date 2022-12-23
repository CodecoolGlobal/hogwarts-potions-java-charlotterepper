package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.data_sample.RoomCreator;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomService {
    private final RoomCreator roomCreator;
    private final RoomMemory roomMemory;
    private final StudentMemory studentMemory;
    private final int MAX_AMOUNT_ROOMS = 20;

    RoomService(RoomCreator roomCreator, RoomMemory roomMemory, StudentMemory studentMemory) {
        this.roomCreator = roomCreator;
        this.roomMemory = roomMemory;
        this.studentMemory = studentMemory;
        createAndAddRooms();
    }

    public void createAndAddRooms() {
        for (int i = 0; i <= MAX_AMOUNT_ROOMS; i++) {
            roomCreator.initialize();
        }
    }

    public void createAndAddRoom(String name, HouseType houseType, int capacity) {
        Room room = roomCreator.createCustomRoom(name, houseType, capacity);
        roomMemory.addRoom(room);
    }

    public void updateRoom(int id, String name, HouseType houseType, int capacity) {
        roomMemory.deleteRoom(id);
        Room room = roomCreator.createCustomRoomWithId(id, name, houseType, capacity);
        roomMemory.addRoom(room);
    }

    public Set<Room> getAllRooms() {
        return roomMemory.getAllRooms();
    }

    public Room getRoom(int id) {
        return roomMemory.getRoom(id);
    }

    public void deleteRoom(int id) {
        roomMemory.deleteRoom(id);
    }

    public void addStudent(int studentId, int roomId) {
        Student student = studentMemory.getStudent(studentId);
        Room room = getRoom(roomId);
        room.getStudents().add(student);
    }

}
