package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.HouseType;
import com.codecool.hogwarts_potions.model.PetType;
import com.codecool.hogwarts_potions.model.Student;
import com.codecool.hogwarts_potions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }

//    @PostMapping("/students/add-room/{roomName}/{firstName}/{lastName}")
//    public String addStudentToRoom(@PathVariable("roomName") String roomName,
//                                   @PathVariable("firstName") String firstName,
//                                   @PathVariable("lastName") String lastName) {
//        // TODO: maybe I will not need this
////        studentService.addRoomToStudent(Long.parseLong(studentId), Long.parseLong(roomId));
//
//        roomService.addStudentToRoom(roomName, firstName, lastName);
//        return "redirect:";
//    }
//
//    @GetMapping("/students/add-student")
//    public String getAddStudent() {
//        return "add-student";
//    }
//
//    @PostMapping("/students/add-student")
//    public String addStudent(@RequestBody MultiValueMap<String, String> map) {
//        Student student = new Student(map.get("student-first-name").get(0), map.get("student-last-name").get(0), HouseType.valueOf(map.get("student-house-type").get(0)), PetType.valueOf(map.get("student-pet-type").get(0)));
//        studentService.addStudent(student);
//        return "redirect:";
//    }
}
