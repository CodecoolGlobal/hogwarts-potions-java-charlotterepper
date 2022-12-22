package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.data_sample.RoomCreator;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class GreetingController {
    private final RoomMemory roomMemory;
    private final RoomCreator roomCreator;

    GreetingController(RoomMemory roomMemory, RoomCreator roomCreator) {
        this.roomMemory = roomMemory;
        this.roomCreator = roomCreator;
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Witches and Wizards") String name,
                           Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", roomMemory.getAllRooms());
        return "rooms";
    }

    @GetMapping("/rooms/create-room")
    public String getCreateRoom() {
        return "create-room";
    }

    @PostMapping("/rooms/create-room")
    public String createRoom(@RequestParam("room-name") String roomName, @RequestParam(value="room-house", required = false) String roomHouse,
                           @RequestParam("room-capacity") String roomCapacity) {
        HouseType houseType = null;
        for (HouseType type : HouseType.values()) {
            if (type.getHouseName().equalsIgnoreCase(roomHouse)) {
                houseType = type;
            }
        }
        int capacity = Integer.parseInt(roomCapacity);
        Room newRoom = roomCreator.createCustomRoom(roomName, houseType, capacity);
        roomMemory.addRoom(newRoom);
        return "redirect:";
    }

    @GetMapping("/rooms/{id}")
    public String getRoom(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("room", roomMemory.getRoom(id));
        return "room";
    }

    @DeleteMapping("/rooms/{id}")
    public String deleteRoom(@PathVariable Integer id) {
        roomMemory.deleteRoom(id);
        return "redirect:";
    }
}
