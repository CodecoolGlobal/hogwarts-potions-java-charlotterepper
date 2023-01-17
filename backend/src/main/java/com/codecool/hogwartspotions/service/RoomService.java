package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.repository.RoomRepository;
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

    public void addStudentToRoom(Long roomId, Long studentId) {
        //TODO
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).get();
    }

    public void updateRoomById(Long id, Room updatedRoom) {
        roomRepository.deleteById(id);
        updatedRoom.setId(id);
        roomRepository.save(updatedRoom);
    }

    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getRoomsForRatOwners() {
        //TODO
        return null;
    }
}
