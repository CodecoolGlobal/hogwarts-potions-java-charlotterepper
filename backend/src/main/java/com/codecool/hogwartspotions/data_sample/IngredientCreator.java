package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.Ingredient;
import com.codecool.hogwartspotions.repository.IngredientRepository;
import com.codecool.hogwartspotions.repository.RecipeRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class IngredientCreator {
    private final Faker faker;
    private Random random;

    public IngredientCreator(IngredientRepository ingredientRepository) {
        faker = new Faker();
        random = new Random();
    }

    public Ingredient getRandomIngredient() {
        return new Ingredient(faker.ancient().god());
    }

    public List<Ingredient> getRandomIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ingredients.add(getRandomIngredient());
        }
        return ingredients;
    }
}
