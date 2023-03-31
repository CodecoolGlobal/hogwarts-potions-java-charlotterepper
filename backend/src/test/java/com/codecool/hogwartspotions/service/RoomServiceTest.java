package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.dto.RoomDTOMapper;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class RoomServiceTest {
    @MockBean
    private RoomRepository roomRepository;

    @MockBean
    private RoomDTOMapper roomDTOMapper;

    @Autowired
    private RoomService roomService;

    static {
        System.setProperty("PSQL_USERNAME", "charlotte");
        System.setProperty("PSQL_PASSWORD", "databaseabc");
    }

    @Test
    void testGetAllRoomsOrderByName() {
        Room room1 = new Room(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        Room room2 = new Room(2L, "B", HouseType.SLYTHERIN, 4, Set.of());
        List<Room> rooms = List.of(room1, room2);

        RoomDTO roomDTO1 = new RoomDTO(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        RoomDTO roomDTO2 = new RoomDTO(2L, "B", HouseType.SLYTHERIN, 4, Set.of());
        List<RoomDTO> expected = List.of(roomDTO1, roomDTO2);

        when(roomRepository.findAllByOrderByName()).thenReturn(rooms);
        when(roomDTOMapper.toRoomDTOList(any())).thenReturn(expected);

        List<RoomDTO> actual = roomService.getAllRoomsOrderByName();

        assertEquals(expected.get(0).getName(), actual.get(0).getName());
    }

    @Test
    void testGetAllAvailableRooms() {
        Room room1 = new Room(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        Room room2 = new Room(2L, "B", HouseType.SLYTHERIN, 4, Set.of());
        List<Room> rooms = List.of(room1, room2);

        RoomDTO roomDTO1 = new RoomDTO(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        RoomDTO roomDTO2 = new RoomDTO(2L, "B", HouseType.SLYTHERIN, 4, Set.of());
        List<RoomDTO> expected = List.of(roomDTO1, roomDTO2);

        when(roomRepository.findAvailableRooms()).thenReturn(rooms);
        when(roomDTOMapper.toRoomDTOList(any())).thenReturn(expected);

        List<RoomDTO> actual = roomService.getAllAvailableRooms();

        assertEquals(expected.get(0).getName(), actual.get(0).getName());
    }

    @Test
    void testAddRoom() {
        Room room = new Room(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        RoomDTO expected = new RoomDTO(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());

        when(roomRepository.save(room)).thenReturn(room);
        when(roomDTOMapper.toRoomDTO(any())).thenReturn(expected);

        RoomDTO actual = roomService.addRoom(expected);

        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    void testGetRoomById() {
        Room room = new Room(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        RoomDTO expected = new RoomDTO(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());

        when(roomRepository.findById(1L)).thenReturn(Optional.of(room));
        when(roomDTOMapper.toRoomDTO(any())).thenReturn(expected);

        RoomDTO actual = roomService.getRoomById(1L);

        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    void testUpdateRoomById() {
        Room room = new Room(1L, "OLD", HouseType.RAVENCLAW, 1, Set.of());
        RoomDTO expected = new RoomDTO(1L, "NEW", HouseType.GRYFFINDOR, 2, Set.of());

        when(roomDTOMapper.toRoom(any())).thenReturn(room);
        when(roomRepository.findById(1L)).thenReturn(Optional.of(room));
        when(roomDTOMapper.toRoomDTO(any())).thenReturn(expected);

        RoomDTO actual = roomService.updateRoomById(1L, expected);

        assertEquals(expected.getName(), actual.getName());
    }

}
