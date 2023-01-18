package com.codecool.hogwartspotions.repository;

import com.codecool.hogwartspotions.model.Ingredient;
import com.codecool.hogwartspotions.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
