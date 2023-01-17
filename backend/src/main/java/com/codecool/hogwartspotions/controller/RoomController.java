package com.codecool.hogwartspotions.controller;

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

    @PostMapping("/{id}")
    public RedirectView updateRoom(@PathVariable Long id, @RequestBody MultiValueMap<String, String> map) {
        Room updatedRoom = new Room(map.get("room-name").get(0),
                             HouseType.valueOf(map.get("room-house").get(0).toUpperCase()),
                             Integer.parseInt(map.get("room-capacity").get(0)));
        roomService.updateRoomById(id, updatedRoom);
        return new RedirectView("http://localhost:3000/rooms/");
    }



    // TODO: fix delete room
//    @DeleteMapping("/{id}")
//    public RedirectView deleteRoom(@PathVariable Long id) {
//        roomService.deleteRoomById(id);
//        return new RedirectView("/rooms");
//    }

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
//
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
