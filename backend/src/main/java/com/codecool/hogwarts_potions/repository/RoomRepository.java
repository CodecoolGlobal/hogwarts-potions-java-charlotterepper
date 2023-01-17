package com.codecool.hogwarts_potions.repository;

import com.codecool.hogwarts_potions.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
