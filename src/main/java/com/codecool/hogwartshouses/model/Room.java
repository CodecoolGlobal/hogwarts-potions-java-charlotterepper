package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private HouseType houseType;
    @NonNull
    private Integer capacity;

    private List<Student> students = new ArrayList<>();

    public int getListSize() {
        return students.size();
    }
}
