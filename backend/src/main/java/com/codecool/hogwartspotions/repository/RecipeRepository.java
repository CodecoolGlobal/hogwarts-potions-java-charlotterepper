package com.codecool.hogwartspotions.repository;

import com.codecool.hogwartspotions.model.Recipe;
import com.codecool.hogwartspotions.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
