package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.repository.RoomRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RoomCreator {
    private final Faker faker;
    private Random random;

    private final RoomRepository roomRepository;

    public RoomCreator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
        faker = new Faker();
        random = new Random();
    }

    public void createRandomRoom() {
        roomRepository.save(new Room(faker.harryPotter().location() + " Room", getRandomHouseType(),
                new Random().nextInt(10 - 1) + 1));
    }

    public HouseType getRandomHouseType() {
        return HouseType.values()[new Random().nextInt(HouseType.values().length)];
    }
}
