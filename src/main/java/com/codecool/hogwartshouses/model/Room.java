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
    private Boolean empty;

    public Room(Integer id, String name, HouseType houseType, Integer capacity, Boolean empty) {
        this.id = id;
        this.name = name;
        this.houseType = houseType;
        this.capacity = capacity;
        this.empty = empty;
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

    public String isEmpty() {
        return empty ? "empty" : "occupied";
    }
}
