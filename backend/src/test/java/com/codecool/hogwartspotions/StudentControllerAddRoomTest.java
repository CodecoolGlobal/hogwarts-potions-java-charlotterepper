package com.codecool.hogwartspotions;

import com.codecool.hogwartspotions.controller.StudentController;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.repository.RoomRepository;
import com.codecool.hogwartspotions.repository.StudentRepository;
import com.codecool.hogwartspotions.service.RoomService;
import com.codecool.hogwartspotions.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({ StudentController.class, StudentService.class, RoomService.class })
public class StudentControllerAddRoomTest {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    StudentController studentController;


    static {
        System.setProperty("PSQL_USERNAME", "charlotte");
    }

    @Test
    void addRoomToStudent() {
        // Arrange
        Student student = studentRepository.save(new Student("A", "B", HouseType.GRYFFINDOR, PetType.CAT));
        Room room = roomRepository.save(new Room("X", HouseType.HUFFLEPUFF, 2));

        // Act
        studentController.addRoomToStudent(student.getId().toString(), room.getId().toString());

        // Assert
        Student updatedStudent = studentRepository.findById(student.getId()).get();
        assertEquals(room, updatedStudent.getRoom());
//        assertNotNull(room);
//        assertNotNull(updatedStudent.getRoom());
//        assertEquals(room.getId(), updatedStudent.getRoom().getId());

    }

    @Test
    void addStudent() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        map.put("student-first-name", "A");
        map.put("student-last-name", "B");
        map.put("student-house-type", "gryffindor");
        map.put("student-pet-type", "cat");

        // Act
        studentController.addStudent(map);

        // Assert
        Student student = studentRepository.findAll().get(0);
        assertEquals("A", student.getFirstName());
        assertEquals("B", student.getLastName());
        assertEquals("gryffindor", student.getHouseType().getHouseName().toLowerCase());
        assertEquals("cat", student.getPetType().getPetName().toLowerCase());
    }
}
