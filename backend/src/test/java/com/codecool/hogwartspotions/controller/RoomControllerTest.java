package com.codecool.hogwartspotions.controller;

import com.codecool.hogwartspotions.dto.RoomDTO;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.service.RoomService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RoomService roomService;

    @Test
    void testGetAllRoomsOrderByName() throws Exception {
        RoomDTO roomDTO = new RoomDTO(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        RoomDTO roomDTO2 = new RoomDTO(2L, "B", HouseType.RAVENCLAW, 3, Set.of());
        when(roomService.getAllRoomsOrderByName()).thenReturn(List.of(roomDTO, roomDTO2));

        ResultActions resultActions = mvc.perform(get("/rooms"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("A")))
                .andExpect(jsonPath("$[0].houseType", is("GRYFFINDOR")))
                .andExpect(jsonPath("$[0].capacity", is(2)))
                .andExpect(jsonPath("$[0].residents", is(Matchers.empty())))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("B")))
                .andExpect(jsonPath("$[1].houseType", is("RAVENCLAW")))
                .andExpect(jsonPath("$[1].capacity", is(3)))
                .andExpect(jsonPath("$[1].residents", is(Matchers.empty())));
    }

    @Test
    void testGetRoom() throws Exception {
        RoomDTO roomDTO = new RoomDTO(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        when(roomService.getRoomById(1L)).thenReturn(roomDTO);

        ResultActions resultActions = mvc.perform(get("/rooms/1"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("A")))
                .andExpect(jsonPath("$.houseType", is("GRYFFINDOR")))
                .andExpect(jsonPath("$.capacity", is(2)))
                .andExpect(jsonPath("$.residents", is(Matchers.empty())));
    }

    @Test
    void testUpdateRoom() throws Exception {
        RoomDTO roomDTO = new RoomDTO(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        ObjectMapper objectMapper = new ObjectMapper();
        when(roomService.updateRoomById(eq(1L), any())).thenReturn(roomDTO);

        mvc.perform(put("/rooms/1")
                .content(objectMapper.writeValueAsString(roomDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(roomDTO.getId()), Long.class))
                .andExpect(jsonPath("$.name", is(roomDTO.getName())))
                .andExpect(jsonPath("$.houseType", is(roomDTO.getHouseType().name())))
                .andExpect(jsonPath("$.capacity", is(roomDTO.getCapacity())))
                .andExpect(jsonPath("$.residents", is(Matchers.empty()))
        );
    }

    @Test
    void testDeleteRoom() throws Exception {
        mvc.perform(delete("/rooms/delete/" + 1))
                .andExpect(status().isOk());
    }

    @Test
    void testAddRoom() throws Exception {
        RoomDTO roomDTO = new RoomDTO(1L, "A", HouseType.GRYFFINDOR, 2, Set.of());
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(post("/rooms/add")
                        .content(objectMapper.writeValueAsString(roomDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()
        );
    }

    @Test
    void testGetAvailableRooms() throws Exception {
        RoomDTO roomDTO = new RoomDTO(2L, "B", HouseType.RAVENCLAW, 3, Set.of());
        when(roomService.getAllAvailableRooms()).thenReturn(List.of(roomDTO));

        ResultActions resultActions = mvc.perform(get("/rooms/available"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].name", is("B")))
                .andExpect(jsonPath("$[0].houseType", is("RAVENCLAW")))
                .andExpect(jsonPath("$[0].capacity", is(3)))
                .andExpect(jsonPath("$[0].residents", is(Matchers.empty())));
    }
}
