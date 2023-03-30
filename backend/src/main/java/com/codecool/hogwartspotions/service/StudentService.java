package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.dto.RoomDTOMapper;
import com.codecool.hogwartspotions.dto.StudentDTO;
import com.codecool.hogwartspotions.dto.StudentDTOMapper;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final RoomService roomService;
    private final StudentDTOMapper studentDTOMapper;
    private final RoomDTOMapper roomDTOMapper;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = studentDTOMapper.toStudent(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentDTOMapper.toStudentDTO(savedStudent);
    }

    public void addRoomToStudent(Long studentId, Long roomId) {
        Student student = getStudentById(studentId);
        RoomDTO roomDTO = roomService.getRoomById(roomId);
        Room room = roomDTOMapper.toRoom(roomDTO);
        student.setRoom(room);
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void updateStudentById(Long id, Student updatedStudent) {
        //TODO
    }

    public void deleteStudentById(Long id) {
        //TODO
    }
}
