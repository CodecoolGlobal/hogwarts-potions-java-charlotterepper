package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public List<Room> rooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") Long id) {
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

    @GetMapping("/create")
    public void getCreateRoom() {

    }

    @PostMapping("/create")
    public RedirectView createRoom(@RequestBody MultiValueMap<String, String> map) {
        Room room = new Room(map.get("room-name").get(0),
                             HouseType.valueOf(map.get("room-house").get(0).toUpperCase()),
                             Integer.parseInt(map.get("room-capacity").get(0)));
        roomService.addRoom(room);
        return new RedirectView("http://localhost:3000/rooms/");
    }

    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAllRooms();
    }
}
