package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.data_sample.RoomCreator;
import com.codecool.hogwartspotions.dto.StudentDTO;
import com.codecool.hogwartspotions.dto.StudentDTOMapper;
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


    @GetMapping
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/add")
    public void addStudent() {

    }

    @PostMapping("/add")
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    @PostMapping("/{studentId}/{roomId}")
    public void addRoomToStudent(@PathVariable("studentId") String studentId, @PathVariable("roomId") String roomId) {
        studentService.addRoomToStudent(Long.parseLong(studentId), Long.parseLong(roomId));
    }
}
