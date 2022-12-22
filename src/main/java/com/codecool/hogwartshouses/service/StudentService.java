package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.data_sample.StudentCreator;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService {
    private final StudentCreator studentCreator;
    private final StudentMemory studentMemory;
    private final int MAX_AMOUNT_STUDENTS = 20;

    StudentService(StudentCreator studentCreator, StudentMemory studentMemory) {
        this.studentCreator = studentCreator;
        this.studentMemory = studentMemory;
        createAndAddStudents();
    }

    public void createAndAddStudents() {
        for (int i = 0; i < MAX_AMOUNT_STUDENTS; i++) {
            studentCreator.initialize();
        }
    }

    public void createAndAddStudent(String firstName, String lastName, HouseType houseType) {
        studentMemory.addStudent(studentCreator.createCustomStudent(firstName, lastName, houseType));
    }

    public Set<Student> getAllStudents() {
        return studentMemory.getAllStudents();
    }

}
