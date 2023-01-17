package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.Room;
import com.codecool.hogwarts_potions.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Room> getRoom(@PathVariable("id") Long id) {
        return roomService.getRoomById(id);
    }

//    @GetMapping("/rooms/create-room")
//    public String getCreateRoom() {
//        return "create-room";
//    }
//
//    @PostMapping("/rooms/create-room")
//    public String createRoom(@RequestBody MultiValueMap<String, String> map) {
//        int capacity = Integer.parseInt(map.get("room-capacity").get(0));
//        Room room = new Room(map.get("room-name").get(0), HouseType.valueOf(map.get("room-house").get(0)), capacity);
//        roomService.addRoom(room);
//        return "redirect:";
//    }
//
//
//    @DeleteMapping("/rooms/{id}")
//    public String deleteRoom(@PathVariable Long id) {
//        roomService.deleteRoomById(id);
//        return "redirect:";
//    }
//
//    @PostMapping("/rooms/{id}")
//    public String updateRoom(@PathVariable Long id, @RequestBody MultiValueMap<String, String> map) {
//        int capacity = Integer.parseInt(map.get("room-capacity").get(0));
//        Room room = new Room(map.get("room-name").get(0), HouseType.valueOf(map.get("room-house").get(0)), capacity);
//        roomService.updateRoomById(id, room);
//        return "redirect:";
//    }
//
//
//
//    // TODO: remove addStudentToRoom() --> just for testing purposes --> unavailable room is not shown on endpoint
//    @GetMapping("/rooms/available")
//    public String getAvailableRooms(Model model) {
//        model.addAttribute("rooms", roomService.getAllRooms());
//        return "available-rooms";
//    }
}
