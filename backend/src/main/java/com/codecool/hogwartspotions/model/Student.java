package com.codecool.hogwartspotions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private HouseType houseType;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @NonNull
    private PetType petType;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
