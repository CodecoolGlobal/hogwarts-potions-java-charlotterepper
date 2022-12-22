package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Room {
    private Integer id;
    private String name;
    private HouseType houseType;
    private Integer capacity;

    public Room(Integer id, String name, HouseType houseType, Integer amountOfStudents) {
        this.id = id;
        this.name = name;
        this.houseType = houseType;
        this.capacity = amountOfStudents;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
