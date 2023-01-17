package com.codecool.hogwarts_potions.runner;

import com.codecool.hogwarts_potions.data_sample.RoomCreator;
import com.codecool.hogwarts_potions.data_sample.StudentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HogwartsRunner implements CommandLineRunner {
    private final RoomCreator roomCreator;
    private final StudentCreator studentCreator;

    @Override
    public void run(String... args) {
        for (int i = 0; i < 5; i++) {
            roomCreator.createRandomRoom();
            studentCreator.createRandomStudent();
        }
    }
}

