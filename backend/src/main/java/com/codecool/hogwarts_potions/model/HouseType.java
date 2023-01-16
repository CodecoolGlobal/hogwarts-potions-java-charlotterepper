package com.codecool.hogwarts_potions.model;

public enum HouseType {
    GRYFFINDOR ("Gryffindor"),
    HUFFLEPUFF ("Hufflepuff"),
    RAVENCLAW ("Ravenclaw"),
    SLYTHERIN ("Slytherin");

    private final String houseName;
    HouseType(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseName() {
        return houseName;
    }
}
