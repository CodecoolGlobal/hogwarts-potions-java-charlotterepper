package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.model.Room;
import com.codecool.hogwarts_potions.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addStudentToRoom(Long roomId, Long studentId) {
        //TODO
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
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
