package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.service.PotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/potions")
public class PotionController {
    private final PotionService potionService;

    @GetMapping
    public List<Potion> allPotions() {
        return potionService.getAllPotions();
    }

    @PostMapping
    public void brewPotion() {

    }

    @GetMapping("/{id}")
    public Potion getPotion(@PathVariable("id") Long id) {
        return potionService.getPotionById(id);
    }
}
