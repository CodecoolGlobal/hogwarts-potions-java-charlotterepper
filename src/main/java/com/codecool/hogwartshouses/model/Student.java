package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @NonNull
    private Integer id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private HouseType houseType;
    private Room room;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
