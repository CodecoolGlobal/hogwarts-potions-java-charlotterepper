package com.codecool.hogwartspotions.dto;

import com.codecool.hogwartspotions.model.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomDTOMapper {

    public Room toRoom(RoomDTO roomDTO) {
        return new Room(roomDTO.getName(), roomDTO.getHouseType(), roomDTO.getCapacity());
    }

    public RoomDTO toRoomDTO(Room room) {
        return new RoomDTO(room.getName(), room.getHouseType(), room.getCapacity());
    }
}
