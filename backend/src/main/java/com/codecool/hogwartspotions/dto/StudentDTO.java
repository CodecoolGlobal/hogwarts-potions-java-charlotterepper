package com.codecool.hogwartspotions.dto;

import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;

public class StudentDTO {
    private String firstName;

    private String lastName;

    private HouseType houseType;

    private PetType petType;

    public StudentDTO(String firstName, String lastName, HouseType houseType, PetType petType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.houseType = houseType;
        this.petType = petType;
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

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }
}
