package com.codecool.hogwartspotions.dto;

import com.codecool.hogwartspotions.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomDTOMapper {

    public Room toRoom(RoomDTO roomDTO) {
        return new Room(roomDTO.getId(), roomDTO.getName(), roomDTO.getHouseType(), roomDTO.getCapacity(),
                roomDTO.getResidents());
    }

    public RoomDTO toRoomDTO(Room room) {
        return new RoomDTO(room.getId(), room.getName(), room.getHouseType(), room.getCapacity(), room.getResidents());
    }

    public List<RoomDTO> toRoomDTOList(List<Room> rooms) {
        return rooms.stream()
                .map(this::toRoomDTO)
                .collect(Collectors.toList());
    }
}
