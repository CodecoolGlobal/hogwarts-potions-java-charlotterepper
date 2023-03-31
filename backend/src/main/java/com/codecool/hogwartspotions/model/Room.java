package com.codecool.hogwartspotions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private HouseType houseType;
    @NonNull
    private Integer capacity;
    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private Set<Student> residents;
}
