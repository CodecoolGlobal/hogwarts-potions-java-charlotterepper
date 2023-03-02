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
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @NonNull
    @OneToMany
    List<Ingredient> ingredients;
}
