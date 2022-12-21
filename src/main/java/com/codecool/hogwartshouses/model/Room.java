package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Room {
    private int id;
    private String name;
    private HouseType houseType;

    public Room(int id, String name, HouseType houseType) {
        this.id = id;
        this.name = name;
        this.houseType = houseType;
    }
}
