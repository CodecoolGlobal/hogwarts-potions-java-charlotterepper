package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    private final RoomMemory roomMemory;

    GreetingController(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
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

    @PostMapping("/rooms")
    public void createRoom() {

    }
}
