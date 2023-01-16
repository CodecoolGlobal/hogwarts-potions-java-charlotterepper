package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.HouseType;
import com.codecool.hogwarts_potions.model.PetType;
import com.codecool.hogwarts_potions.model.Room;
import com.codecool.hogwarts_potions.model.Student;
import com.codecool.hogwarts_potions.service.RoomService;
import com.codecool.hogwarts_potions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class GreetingController {
    private final RoomService roomService;

    @GetMapping("/rooms")
    public List<Room> rooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/create-room")
    public String getCreateRoom() {
        return "create-room";
    }

    @PostMapping("/rooms/create-room")
    public String createRoom(@RequestBody MultiValueMap<String, String> map) {
        int capacity = Integer.parseInt(map.get("room-capacity").get(0));
        Room room = new Room(map.get("room-name").get(0), HouseType.valueOf(map.get("room-house").get(0)), capacity);
        roomService.addRoom(room);
        return "redirect:";
    }

    @GetMapping("/rooms/{id}")
    public String getRoom(@PathVariable("id") Long id, Model model) {
        model.addAttribute("room", roomService.getRoomById(id));
        return "room";
    }

    @DeleteMapping("/rooms/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomById(id);
        return "redirect:";
    }

    @PostMapping("/rooms/{id}")
    public String updateRoom(@PathVariable Long id, @RequestBody MultiValueMap<String, String> map) {
        int capacity = Integer.parseInt(map.get("room-capacity").get(0));
        Room room = new Room(map.get("room-name").get(0), HouseType.valueOf(map.get("room-house").get(0)), capacity);
        roomService.updateRoomById(id, room);
        return "redirect:";
    }



    // TODO: remove addStudentToRoom() --> just for testing purposes --> unavailable room is not shown on endpoint
    @GetMapping("/rooms/available")
    public String getAvailableRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "available-rooms";
    }
}
