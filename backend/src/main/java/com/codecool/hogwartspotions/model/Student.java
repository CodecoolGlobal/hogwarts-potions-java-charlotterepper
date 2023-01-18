package com.codecool.hogwartspotions.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {

//    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private HouseType houseType;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @NonNull
    private PetType petType;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}