package com.codecool.hogwartspotions.repository;

import com.codecool.hogwartspotions.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "SELECT * FROM room r " +
            "WHERE r.capacity > (SELECT COUNT(*) FROM student s WHERE s.room_id = r.id)" +
            " AND (SELECT COUNT(*) FROM student s WHERE s.room_id = r.id) >= 0", nativeQuery = true)
    List<Room> findAvailableRooms();

}
