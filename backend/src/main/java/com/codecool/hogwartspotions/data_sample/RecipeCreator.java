package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.Recipe;
import com.codecool.hogwartspotions.repository.RecipeRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@RequiredArgsConstructor
@Component
public class RecipeCreator {
    private final Faker faker = new Faker();
    private Random random = new Random();

    private final StudentCreator studentCreator;
    private final IngredientCreator ingredientCreator;
    private final RecipeRepository recipeRepository;

    public Recipe getRandomRecipe() {
        return recipeRepository.save(new Recipe(faker.ancient().titan() + " Recipe", studentCreator.getRandomStudent(),
                ingredientCreator.getRandomIngredients()));
    }
}
