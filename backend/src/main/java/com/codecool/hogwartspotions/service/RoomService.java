package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.dto.RoomDTOMapper;
import com.codecool.hogwartspotions.exceptions.ResourceNotFoundException;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomDTOMapper roomDTOMapper;

    public List<RoomDTO> getAllRoomsOrderByName() {
        List<Room> rooms = roomRepository.findAllByOrderByName();
        return roomDTOMapper.toRoomDTOList(rooms);
    }

    public List<RoomDTO> getAllAvailableRooms() {
        List<Room> rooms = roomRepository.findAvailableRooms();
        return roomDTOMapper.toRoomDTOList(rooms);
    }

    public RoomDTO addRoom(RoomDTO roomDTO) {
        Room room = roomDTOMapper.toRoom(roomDTO);
        roomRepository.save(room);
        return roomDTOMapper.toRoomDTO(room);
    }

    public void addStudentToRoom(Long roomId, Long studentId) {
        //TODO
    }

    public RoomDTO getRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return roomDTOMapper.toRoomDTO(room);
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
