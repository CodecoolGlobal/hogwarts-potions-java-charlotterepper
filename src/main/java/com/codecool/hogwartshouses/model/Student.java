package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private HouseType houseType;

    public Student(Integer id, String firstName, String lastName, HouseType houseType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.houseType = houseType;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public HouseType getHouseType() {
        return houseType;
    }
}
