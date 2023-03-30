package com.codecool.hogwartspotions.dto;

import com.codecool.hogwartspotions.data_sample.RoomCreator;
import com.codecool.hogwartspotions.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentDTOMapper {
    private final RoomCreator roomCreator;

    public StudentDTOMapper(RoomCreator roomCreator) {
        this.roomCreator = roomCreator;
    }

    public Student toStudent(StudentDTO studentDTO) {
        return new Student(studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getHouseType(),
                roomCreator.createAndSaveRandomRoom(), studentDTO.getPetType());
    }

    public StudentDTO toStudentDTO(Student student) {
        return new StudentDTO(student.getFirstName(), student.getLastName(), student.getHouseType(), student.getPetType());
    }
}
