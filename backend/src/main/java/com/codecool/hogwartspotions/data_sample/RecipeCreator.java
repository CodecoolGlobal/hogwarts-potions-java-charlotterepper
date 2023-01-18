package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.Recipe;
import com.codecool.hogwartspotions.repository.RecipeRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RecipeCreator {
    private final Faker faker;
    private Random random;
    private final RecipeRepository recipeRepository;

    private final StudentCreator studentCreator;
    private final IngredientCreator ingredientCreator;

    public RecipeCreator(RecipeRepository recipeRepository, StudentCreator studentCreator, IngredientCreator ingredientCreator) {
        this.recipeRepository = recipeRepository;
        this.studentCreator = studentCreator;
        this.ingredientCreator = ingredientCreator;
        faker = new Faker();
        random = new Random();
    }

//    public Recipe getRandomRecipe() {
//        return new Recipe(faker.ancient().god() + " Recipe", studentCreator.getRandomStudent(), ingredientCreator.getRandomIngredients());
//    }
}
