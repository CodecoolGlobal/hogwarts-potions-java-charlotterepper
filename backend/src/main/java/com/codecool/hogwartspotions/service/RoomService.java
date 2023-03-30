package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.dto.RoomDTOMapper;
import com.codecool.hogwartspotions.exceptions.ResourceNotFoundException;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.repository.RoomRepository;
import com.codecool.hogwartspotions.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final StudentRepository studentRepository;
    private final RoomDTOMapper roomDTOMapper;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public void addStudentToRoom(Long roomId, Long studentId) {
        //TODO
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public RoomDTO updateRoomById(Long id, RoomDTO roomDTO) {
        Room oldRoom = roomRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        Room updatedRoom = roomDTOMapper.toRoom(roomDTO);
        oldRoom.setName(updatedRoom.getName());
        oldRoom.setHouseType(updatedRoom.getHouseType());
        oldRoom.setCapacity(updatedRoom.getCapacity());
        roomRepository.save(oldRoom);
        return roomDTOMapper.toRoomDTO(oldRoom);
    }

    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getRoomsForRatOwners() {
        //TODO
        return null;
    }
}
