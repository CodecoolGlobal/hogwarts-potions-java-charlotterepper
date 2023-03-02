package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.service.PotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/potions")
public class PotionController {
    private final PotionService potionService;

    @GetMapping
    public List<Potion> allPotions() {
        return potionService.getAllPotions();
    }

    @PostMapping
    public void brewPotion() {
        
    }

    @GetMapping("/{id}")
    public Potion getPotion(@PathVariable("id") Long id) {
        return potionService.getPotionById(id);
    }


//    @PostMapping("/{id}")
//    public RedirectView updateRoom(@PathVariable Long id, @RequestBody MultiValueMap<String, String> map) {
//        Room updatedRoom = new Room(map.get("room-name").get(0),
//                             HouseType.valueOf(map.get("room-house").get(0).toUpperCase()),
//                             Integer.parseInt(map.get("room-capacity").get(0)));
//        roomService.updateRoomById(id, updatedRoom);
//        return new RedirectView("http://localhost:3000/rooms/");
//    }
//
//    @PostMapping("/delete/{id}")
//    public RedirectView deleteRoom(@PathVariable Long id) {
//        roomService.deleteRoomById(id);
//        return new RedirectView("http://localhost:3000/rooms/");
//    }
//
//    @GetMapping("/create")
//    public void getCreateRoom() {
//
//    }
//
//    @PostMapping("/create")
//    public RedirectView createRoom(@RequestBody MultiValueMap<String, String> map) {
//        Room room = new Room(map.get("room-name").get(0),
//                             HouseType.valueOf(map.get("room-house").get(0).toUpperCase()),
//                             Integer.parseInt(map.get("room-capacity").get(0)));
//        roomService.addRoom(room);
//        return new RedirectView("http://localhost:3000/rooms/");
//    }
//
//    @GetMapping("/available")
//    public List<Room> getAvailableRooms() {
//        return roomService.getAllRooms();
//    }
}
