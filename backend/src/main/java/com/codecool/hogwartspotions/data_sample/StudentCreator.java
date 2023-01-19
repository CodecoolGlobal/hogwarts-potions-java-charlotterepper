package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StudentCreator {
    private final Faker faker = new Faker();

    private final StudentRepository studentRepository;

    public StudentCreator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createRandomStudent() {
        studentRepository.save(new Student(faker.name().firstName(), faker.name().lastName(), getRandomHouseType(), getRandomPetType()));
    }

    public Student getRandomStudent() {
        return studentRepository.save(new Student(faker.name().firstName(), faker.name().lastName(), getRandomHouseType(), getRandomPetType()));
    }

    public HouseType getRandomHouseType() {
        return HouseType.values()[new Random().nextInt(HouseType.values().length)];
    }

    public PetType getRandomPetType() {
        return PetType.values()[new Random().nextInt(PetType.values().length)];
    }
}
