package com.codecool.hogwartspotions.repository;

import com.codecool.hogwartspotions.model.Potion;
import com.codecool.hogwartspotions.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotionRepository extends JpaRepository<Potion, Long> {
}
