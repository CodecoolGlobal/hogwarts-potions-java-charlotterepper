package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.RoomService;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    private final RoomService roomService;
    private final StudentService studentService;

    GreetingController(RoomService roomService, StudentService studentService) {
        this.roomService = roomService;
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Witches and Wizards") String name,
                           Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    @GetMapping("/rooms/create-room")
    public String getCreateRoom() {
        return "create-room";
    }

    @PostMapping("/rooms/create-room")
    public String createRoom(@RequestBody MultiValueMap<String, String> map) {
        HouseType houseType = getHouseType(map);
        int capacity = Integer.parseInt(map.get("room-capacity").get(0));
        roomService.createAndAddRoom(map.get("room-name").get(0), houseType, capacity);
        return "redirect:";
    }

    @GetMapping("/rooms/{id}")
    public String getRoom(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("room", roomService.getRoom(id));
        return "room";
    }

    @DeleteMapping("/rooms/{id}")
    public String deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        return "redirect:";
    }

    @PostMapping("/rooms/{id}")
    public String updateRoom(@PathVariable Integer id, @RequestBody MultiValueMap<String, String> map) {
        HouseType houseType = getHouseType(map);
        int capacity = Integer.parseInt(map.get("room-capacity").get(0));
        roomService.updateRoom(id, map.get("room-name").get(0), houseType, capacity);
        return "redirect:";
    }

    public HouseType getHouseType(MultiValueMap<String, String> map) {
        HouseType houseType = null;
        for (HouseType type : HouseType.values()) {
            if (type.getHouseName().equalsIgnoreCase(map.get("room-house").get(0))) {
                houseType = type;
            }
        }
        return houseType;
    }

    @GetMapping("/students")
    public String allStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("rooms", roomService.getAllRooms());
        return "students";
    }

    @PostMapping("/students/add-room/{studentId}")
    public String addStudentToRoom(@PathVariable("studentId") String studentId,
                                   @RequestBody MultiValueMap<String, String> map) {

        return "redirect:";
    }

    @GetMapping("/students/add-student")
    public String getAddStudent() {
        return "add-student";
    }

    @PostMapping("/students/add-student")
    public String addStudent(@RequestBody MultiValueMap<String, String> map) {
        HouseType houseType = getHouseType(map);
        studentService.createAndAddStudent(map.get("student-first-name").get(0), map.get("student-last-name").get(0), houseType);
        return "redirect:";
    }
}
