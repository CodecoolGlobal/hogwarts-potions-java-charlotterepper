package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.dto.RoomDTOMapper;
import com.codecool.hogwartspotions.dto.StudentDTO;
import com.codecool.hogwartspotions.dto.StudentDTOMapper;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.repository.RoomRepository;
import com.codecool.hogwartspotions.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class StudentServiceTest {
    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private RoomService roomService;

    @MockBean
    private RoomDTOMapper roomDTOMapper;

    @MockBean
    private StudentDTOMapper studentDTOMapper;

    @Autowired
    private StudentService studentService;

    static {
        System.setProperty("PSQL_USERNAME", "charlotte");
        System.setProperty("PSQL_PASSWORD", "databaseabc");
    }

    @Test
    void testGetStudentsOrderByName() {
        Student student1 = new Student(1L, "A", "B", HouseType.GRYFFINDOR, new Room(), PetType.RAT);
        Student student2 = new Student(2L, "C", "D", HouseType.SLYTHERIN, new Room(), PetType.CAT);
        List<Student> students = List.of(student1, student2);

        StudentDTO studentDTO1 = new StudentDTO(1L, "A", "B", HouseType.GRYFFINDOR, new Room(), PetType.RAT);
        StudentDTO studentDTO2 = new StudentDTO(2L, "C", "D", HouseType.SLYTHERIN, new Room(), PetType.CAT);
        List<StudentDTO> expected = List.of(studentDTO1, studentDTO2);

        when(studentRepository.findAllByOrderByFirstName()).thenReturn(students);
        when(studentDTOMapper.toStudentDTOList(any())).thenReturn(expected);

        List<StudentDTO> actual = studentService.getStudentsOrderByFirstName();

        assertEquals(expected.get(0).getFirstName(), actual.get(0).getFirstName());
    }


    @Test
    void testAddStudent() {
        Student student = new Student(1L, "A", "B", HouseType.GRYFFINDOR, new Room(), PetType.RAT);
        StudentDTO expected = new StudentDTO(1L, "A", "B", HouseType.GRYFFINDOR, new Room(), PetType.RAT);

        when(studentRepository.save(student)).thenReturn(student);
        when(studentDTOMapper.toStudentDTO(any())).thenReturn(expected);

        StudentDTO actual = studentService.addStudent(expected);

        assertEquals(expected.getFirstName(), actual.getFirstName());
    }


    @Test
    void testGetRoomById() {
        Student expected = new Student(1L, "A", "B", HouseType.GRYFFINDOR, new Room(), PetType.RAT);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(expected));

        Student actual = studentService.getStudentById(1L);

        assertEquals(expected.getFirstName(), actual.getFirstName());
    }
}
