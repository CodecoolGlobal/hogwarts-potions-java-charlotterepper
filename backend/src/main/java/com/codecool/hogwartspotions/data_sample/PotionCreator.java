package com.codecool.hogwartspotions.data_sample;

import com.codecool.hogwartspotions.model.BrewingStatus;
import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.repository.PotionRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PotionCreator {
    private final Faker faker;
    private Random random;

    private final PotionRepository potionRepository;
    private final StudentCreator studentCreator;
    private final RecipeCreator recipeCreator;
    private final IngredientCreator ingredientCreator;

    public PotionCreator(PotionRepository potionRepository, StudentCreator studentCreator, RecipeCreator recipeCreator, IngredientCreator ingredientCreator) {
        this.potionRepository = potionRepository;
        this.studentCreator = studentCreator;
        this.recipeCreator = recipeCreator;
        this.ingredientCreator = ingredientCreator;
        faker = new Faker();
        random = new Random();
    }

//    public void createRandomPotion() {
//        potionRepository.save(new Potion(faker.funnyName() + " Potion", studentCreator.getRandomStudent(),
//                ingredientCreator.getRandomIngredients(), getRandomBrewingStatus(), recipeCreator.getRandomRecipe()));
//    }

    public BrewingStatus getRandomBrewingStatus() {
        return BrewingStatus.values()[new Random().nextInt(BrewingStatus.values().length)];
    }
}
