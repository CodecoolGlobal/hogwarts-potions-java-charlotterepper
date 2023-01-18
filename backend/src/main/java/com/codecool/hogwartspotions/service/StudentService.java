package com.codecool.hogwartspotions.service;

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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void addRoomToStudent(Long studentId, Long roomId) {
        Student student = getStudentById(studentId);
        Room room = roomService.getRoomById(roomId);
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
