package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;

import java.util.Set;

public interface StudentDAO {
    void addStudent(Student student);
    Set<Student> getAllStudents();
    void addRoom(int id, Room room);
}
