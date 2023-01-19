package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.Ingredient;
import com.codecool.hogwartspotions.repository.IngredientRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RequiredArgsConstructor
@Component
public class IngredientCreator {
    private final Faker faker = new Faker();
    private Random random = new Random();
    private final IngredientRepository ingredientRepository;

    public Ingredient getRandomIngredient() {
        return ingredientRepository.save(new Ingredient(faker.food().ingredient()));
    }

    public List<Ingredient> getRandomIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ingredients.add(getRandomIngredient());
        }
        return ingredientRepository.saveAll(ingredients);
    }
}
