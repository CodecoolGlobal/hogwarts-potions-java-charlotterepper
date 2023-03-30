package com.codecool.hogwartspotions.dto;

import com.codecool.hogwartspotions.data_sample.RoomCreator;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentDTOMapper {
    private final RoomCreator roomCreator;

    public StudentDTOMapper(RoomCreator roomCreator) {
        this.roomCreator = roomCreator;
    }

    public Student toStudent(StudentDTO studentDTO) {
        return new Student(studentDTO.getId(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getHouseType(),
                roomCreator.createAndSaveRandomRoom(), studentDTO.getPetType());
    }

    public StudentDTO toStudentDTO(Student student) {
        return new StudentDTO(student.getId(), student.getFirstName(), student.getLastName(), student.getHouseType(),
                student.getRoom(), student.getPetType());
    }

    public List<StudentDTO> toStudentDTOList(List<Student> students) {
        return students.stream()
                .map(this::toStudentDTO)
                .collect(Collectors.toList());
    }
}
