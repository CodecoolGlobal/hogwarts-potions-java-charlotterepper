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
    private int amountOfStudents;

    public Room(Integer id, String name, HouseType houseType, int amountOfStudents) {
        this.id = id;
        this.name = name;
        this.houseType = houseType;
        this.amountOfStudents = amountOfStudents;
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

    public int getAmountOfStudents() {
        return amountOfStudents;
    }
}
