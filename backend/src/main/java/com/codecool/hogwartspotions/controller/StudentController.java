package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.data_sample.RoomCreator;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final RoomCreator roomCreator;

    @GetMapping
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/add")
    public void addStudent() {

    }

    @PostMapping("/add")
    public RedirectView addStudent(@RequestBody MultiValueMap<String, String> map) {
        Student student = new Student(map.get("student-first-name").get(0),
                                      map.get("student-last-name").get(0),
                                      HouseType.valueOf(map.get("student-house-type").get(0).toUpperCase()),
                roomCreator.createAndSaveRandomRoom(), PetType.valueOf(map.get("student-pet-type").get(0).toUpperCase()));
        studentService.addStudent(student);
        return new RedirectView("http://localhost:3000/students/");
    }

    @PostMapping("/{studentId}/{roomId}")
    public void addRoomToStudent(@PathVariable("studentId") String studentId,
                                 @PathVariable("roomId") String roomId) {
        studentService.addRoomToStudent(Long.parseLong(studentId), Long.parseLong(roomId));
    }
}
