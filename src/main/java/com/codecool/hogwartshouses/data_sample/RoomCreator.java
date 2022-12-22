package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RoomCreator {
    private int id = 0;
    private final Faker faker = new Faker();

    private final RoomMemory roomMemory;

    public RoomCreator(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
        initialize();
    }

    public Room createCustomRoom(String name, HouseType houseType, int capacity) {
        return new Room(id++, name, houseType, capacity);
    }

    public void initialize() {
        roomMemory.addRoom(new Room(id++, faker.harryPotter().location() + " Room", getRandomHouseType(), new Random().nextInt(10 - 1) + 1));
    }

    public HouseType getRandomHouseType() {
        return HouseType.values()[new Random().nextInt(HouseType.values().length)];
    }
}
