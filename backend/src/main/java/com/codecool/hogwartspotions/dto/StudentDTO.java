package com.codecool.hogwartspotions.dto;

import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;
import com.codecool.hogwartspotions.model.Room;

public class StudentDTO {
    private Long id;
    private String firstName;

    private String lastName;

    private HouseType houseType;
    private Room room;

    private PetType petType;

    public StudentDTO(Long id, String firstName, String lastName, HouseType houseType, Room room, PetType petType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.houseType = houseType;
        this.room = room;
        this.petType = petType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", houseType=" + houseType +
                ", room=" + room +
                ", petType=" + petType +
                '}';
    }
}
