package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        //TODO
    }

    public void addRoomToStudent(Long studentId, Long roomId) {
        //TODO: search student by first name and last name, search room by room name and add student
    }

    public Student getStudentById(Long id) {
        //TODO
        return null;
    }

    public void updateStudentById(Long id, Student updatedStudent) {
        //TODO
    }

    public void deleteStudentById(Long id) {
        //TODO
    }
}
