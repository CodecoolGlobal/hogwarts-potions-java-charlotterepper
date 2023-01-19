package com.codecool.hogwartspotions.runner;

import com.codecool.hogwartspotions.data_sample.PotionCreator;
import com.codecool.hogwartspotions.data_sample.RoomCreator;
import com.codecool.hogwartspotions.data_sample.StudentCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HogwartsRunner implements CommandLineRunner {
    private final RoomCreator roomCreator;
    private final StudentCreator studentCreator;
    private final PotionCreator potionCreator;

    @Override
    public void run(String... args) {
        for (int i = 0; i < 5; i++) {
            roomCreator.createRandomRoom();
            studentCreator.createRandomStudent();
            potionCreator.createRandomPotion();
        }
    }
}

