package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public List<RoomDTO> rooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public RoomDTO getRoom(@PathVariable("id") Long id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/{id}")
    public RoomDTO updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO) {
        return roomService.updateRoomById(id, roomDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomById(id);
    }

    @PostMapping("/add")
    public RoomDTO addRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.addRoom(roomDTO);
    }

    @GetMapping("/available")
    public List<RoomDTO> getAvailableRooms() {
        return roomService.getAllAvailableRooms();
    }
}
