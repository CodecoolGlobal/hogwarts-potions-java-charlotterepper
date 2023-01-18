package com.codecool.hogwartspotions.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table
public class Potion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToMany
    private List<Ingredient> ingredients;
    @NonNull
    private BrewingStatus brewingStatus;
    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
