package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StudentCreator {
    private int id = 1;
    private final Faker faker = new Faker();

    private final StudentMemory studentMemory;

    public StudentCreator(StudentMemory studentMemory) {
        this.studentMemory = studentMemory;
        initialize();
    }

    public void initialize() {
        studentMemory.addStudent(new Student(id++, faker.name().firstName(), faker.name().lastName(), getRandomHouseType()));
    }

    public HouseType getRandomHouseType() {
        return HouseType.values()[new Random().nextInt(HouseType.values().length)];
    }

    public Student createCustomStudent(String firstName, String lastName, HouseType houseType) {
        return new Student(id++, firstName, lastName, houseType);
    }
}
