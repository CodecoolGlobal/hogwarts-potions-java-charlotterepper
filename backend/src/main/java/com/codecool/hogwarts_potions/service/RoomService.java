package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.model.Room;
import com.codecool.hogwarts_potions.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void addRoom(Room room) {
        //TODO
    }

    public void addStudentToRoom(String roomName, String firstName, String lastName) {
        //TODO
    }

    public Room getRoomById(Long id) {
        //TODO
        return null;
    }

    public void updateRoomById(Long id, Room updatedRoom) {
        //TODO
    }

    public void deleteRoomById(Long id) {
        //TODO
    }

    public List<Room> getRoomsForRatOwners() {
        //TODO
        return null;
    }
}
