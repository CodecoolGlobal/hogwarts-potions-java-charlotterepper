package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000/")
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
    public RedirectView addStudent(@RequestParam Map<String, String> map) {
        System.out.println(map.get("student-house-type"));
        Student student = new Student(map.get("student-first-name"),
                                      map.get("student-last-name"),
                                      HouseType.valueOf(map.get("student-house-type").toUpperCase()),
                                      PetType.valueOf(map.get("student-pet-type").toUpperCase()));
        studentService.addStudent(student);
        return new RedirectView("http://localhost:3000/students/");
    }

    @PostMapping("/{studentId}/{roomId}")
    public void addRoomToStudent(@PathVariable("studentId") String studentId,
                                         @PathVariable("roomId") String roomId) {
        System.out.println("studentId " + studentId);
        studentService.addRoomToStudent(Long.parseLong(studentId), Long.parseLong(roomId));
//        return new RedirectView("http://localhost:3000/students/");
    }

//    @PostMapping("/students/add-room/{studentId}")
//    public String addStudentToRoom(@PathVariable("studentId") String studentId,
//                                   @RequestBody MultiValueMap<String, String> map) {
//        studentService.addRoom(Integer.parseInt(studentId), Integer.parseInt(map.get("chosen-room").get(0)));
//        roomService.addStudent(Integer.parseInt(studentId), Integer.parseInt(map.get("chosen-room").get(0)));
//        return "redirect:";
//    }


//    @PostMapping("/students/{roomName}/{firstName}/{lastName}")
//    public String addStudentToRoom(@PathVariable("roomName") String roomName,
//                                   @PathVariable("firstName") String firstName,
//                                   @PathVariable("lastName") String lastName) {
//        studentService.addRoomToStudent(Long.parseLong(studentId), Long.parseLong(roomId));
//
//        // TODO: maybe I will not need this
////        roomService.addStudentToRoom(roomName, firstName, lastName);
//        return "redirect:";
//    }

}
