package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.dto.StudentDTO;
import com.codecool.hogwartspotions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDTO> allStudentsOrderByFirstName() {
        return studentService.getStudentsOrderByFirstName();
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
    }

    @PostMapping("/{studentId}/{roomId}")
    public void addRoomToStudent(@PathVariable("studentId") String studentId, @PathVariable("roomId") String roomId) {
        studentService.addRoomToStudent(Long.parseLong(studentId), Long.parseLong(roomId));
    }
}
