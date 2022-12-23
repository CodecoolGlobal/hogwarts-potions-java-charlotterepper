package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RoomCreator {
    private int id = 1;
    private final Faker faker;
    private Random random;

    private final RoomMemory roomMemory;

    public RoomCreator(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
        faker = new Faker();
        random = new Random();
        initialize();
    }

    public Room createCustomRoom(String name, HouseType houseType, int capacity) {
        return new Room(id++, name, houseType, capacity, random.nextBoolean());
    }

    public Room createCustomRoomWithId(int id, String name, HouseType houseType, int capacity) {
        return new Room(id, name, houseType, capacity, random.nextBoolean());
    }

    public void initialize() {
        roomMemory.addRoom(new Room(id++, faker.harryPotter().location() + " Room", getRandomHouseType(),
                new Random().nextInt(10 - 1) + 1, random.nextBoolean()));
    }

    public HouseType getRandomHouseType() {
        return HouseType.values()[new Random().nextInt(HouseType.values().length)];
    }
}
