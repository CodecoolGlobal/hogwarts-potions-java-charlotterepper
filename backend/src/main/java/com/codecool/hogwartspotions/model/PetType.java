package com.codecool.hogwartspotions.model;

public enum PetType {
    CAT("cat"),
    RAT("rat"),
    OWL("owl"),
    NONE("none");

    private final String petName;
    PetType(String petName) {
        this.petName = petName;
    }

    public String getPetName() {
        return petName;
    }
}
