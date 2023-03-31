package com.codecool.hogwartspotions.dto;

import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.Student;

import java.util.Set;

public class RoomDTO {
    private Long id;
    private String name;
    private HouseType houseType;
    private Integer capacity;
    private Set<Student> residents;

    public RoomDTO(Long id, String name, HouseType houseType, Integer capacity, Set<Student> residents) {
        this.id = id;
        this.name = name;
        this.houseType = houseType;
        this.capacity = capacity;
        this.residents = residents;
    }

    public Long getId() {
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

    public Set<Student> getResidents() {
        return residents;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setResidents(Set<Student> residents) {
        this.residents = residents;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", houseType=" + houseType +
                ", capacity=" + capacity +
                ", residents=" + residents +
                '}';
    }
}
