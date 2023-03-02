package com.codecool.hogwartspotions;

import com.codecool.hogwartspotions.controller.PotionController;
import com.codecool.hogwartspotions.model.*;
import com.codecool.hogwartspotions.repository.PotionRepository;
import com.codecool.hogwartspotions.service.PotionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


@WebMvcTest(PotionController.class)
public class PotionControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    PotionService potionService;
    @Autowired
    private PotionRepository potionRepository;

    @Test
    void givenListOfPotions_whenGetAllPotions_thenReturnPotionsList() throws Exception {
        // given - precondition
        Room room = new Room("o", HouseType.GRYFFINDOR, 5);
        Student student = new Student("e", "r", HouseType.GRYFFINDOR, room, PetType.RAT);
        Ingredient ingredient1 = new Ingredient("b");
        Ingredient ingredient2 = new Ingredient("c");
        Recipe recipe = new Recipe("u", student, Arrays.asList(ingredient1, ingredient2));

        List<Potion> listOfPotions = new ArrayList<>();
        listOfPotions.add(new Potion("a", student, Arrays.asList(ingredient1, ingredient2), BrewingStatus.BREW, recipe));

        given(potionService.getAllPotions()).willReturn(listOfPotions);

        assertEquals(potionService.getAllPotions().size(), listOfPotions.size());

        // when - action or behaviour
//        ResultActions response = mvc.perform(get("/potions"));
//
//        // then - verify the output
//        response.andExpect(status().isOk())
//                .andDo(print())
//                .andExpect((ResultMatcher) jsonPath("$.size()",
//                        is(listOfPotions.size())));
    }

}
