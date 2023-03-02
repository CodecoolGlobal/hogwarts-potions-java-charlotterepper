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

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({ StudentController.class, StudentService.class, RoomService.class })
public class StudentControllerAddRoomTest {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentController studentController;

    @Autowired
    RoomRepository roomRepository;

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
}
