package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.dto.StudentDTO;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    StudentService studentService;

    @Test
    void testGetAllStudentsOrderByFirstName() throws Exception {
        Room room = new Room(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        StudentDTO studentDTO = new StudentDTO(1L, "A", "B", HouseType.GRYFFINDOR, room, PetType.CAT);
        when(studentService.getStudentsOrderByFirstName()).thenReturn(List.of(studentDTO));

        ResultActions resultActions = mvc.perform(get("/students"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(studentDTO.getId().intValue())))
                .andExpect(jsonPath("$[0].firstName", is(studentDTO.getFirstName())))
                .andExpect(jsonPath("$[0].lastName", is(studentDTO.getLastName())))
                .andExpect(jsonPath("$[0].houseType", is(studentDTO.getHouseType().name())))
                .andExpect(jsonPath("$[0].room.id", is(studentDTO.getRoom().getId().intValue())))
                .andExpect(jsonPath("$[0].room.name", is(studentDTO.getRoom().getName())))
                .andExpect(jsonPath("$[0].room.houseType", is(studentDTO.getRoom().getHouseType().name())))
                .andExpect(jsonPath("$[0].room.capacity", is(studentDTO.getRoom().getCapacity())))
                .andExpect(jsonPath("$[0].room.numberOfResidents", is(studentDTO.getRoom().getResidents().size())))
                .andExpect(jsonPath("$[0].petType", is(studentDTO.getPetType().name())));
    }

    @Test
    void testAddStudent() throws Exception {
        Room room = new Room(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        StudentDTO studentDTO = new StudentDTO(1L, "A", "B", HouseType.GRYFFINDOR, room, PetType.CAT);
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(post("/students/add")
                        .content(objectMapper.writeValueAsString(studentDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()
                );
    }

    @Test
    void testAddRoomToStudent() throws Exception {
        Room room = new Room(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        StudentDTO studentDTO = new StudentDTO(2L, "A", "B", HouseType.GRYFFINDOR, room, PetType.CAT);

        mvc.perform(post("/students/" + studentDTO.getId() + "/" + room.getId()))
                .andExpect(status().isOk()
                );
    }
}
