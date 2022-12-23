package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentMemory implements StudentDAO {
    private final int id = 1;
    private final Set<Student> students;

    public StudentMemory(Set<Student> students) {
        this.students = students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Set<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(int studentId) {
        return students.stream()
                .filter(student -> student.getId() == studentId)
                .collect(Collectors.toList()).get(0);
    }


}
