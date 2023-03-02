package com.codecool.hogwartspotions.service;

import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.repository.PotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PotionService {
    private final PotionRepository potionRepository;

    public List<Potion> getAllPotions() {
        return potionRepository.findAll();
    }

    public void addPotion(Potion potion) {
        potionRepository.save(potion);
    }

    public Potion getPotionById(Long id) {
        return potionRepository.findById(id).get();
    }

    public void updatePotionById(Long id, Potion updatedPotion) {
        potionRepository.deleteById(id);
        updatedPotion.setId(id);
        potionRepository.save(updatedPotion);
    }

    public void deletePotionById(Long id) {
        potionRepository.deleteById(id);
    }
}
