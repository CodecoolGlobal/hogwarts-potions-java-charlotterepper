package com.codecool.hogwartspotions.dto;

import com.codecool.hogwartspotions.model.HouseType;

public class RoomDTO {
    private String name;
    private HouseType houseType;
    private Integer capacity;

    public RoomDTO(String name, HouseType houseType, Integer capacity) {
        this.name = name;
        this.houseType = houseType;
        this.capacity = capacity;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
