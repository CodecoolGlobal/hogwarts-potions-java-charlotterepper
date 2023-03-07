package com.codecool.hogwartspotions;

import com.codecool.hogwartspotions.controller.RoomController;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.Room;
import com.codecool.hogwartspotions.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    RoomService roomService;

    @Test
    void getAll() throws Exception {
        // Arrange
        Room room = new Room("A", HouseType.GRYFFINDOR, 1);
        room.setId(1L);
        when(roomService.getAllRooms()).thenReturn(List.of(room));

        // Act
        ResultActions resultActions = mvc.perform(get("/rooms"));

        // Assert
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("A")))
                .andExpect(jsonPath("$[0].houseType", is("GRYFFINDOR")))
                .andExpect(jsonPath("$[0].capacity", is(1)));
    }

    @Test
    void getRoom() throws Exception {
        Room room = new Room("A", HouseType.GRYFFINDOR, 1);
        room.setId(1L);
        when(roomService.getRoomById(1L)).thenReturn(room);

        ResultActions resultActions = mvc.perform(get("/rooms/1"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("A")))
                .andExpect(jsonPath("$[0].houseType", is("GRYFFINDOR")))
                .andExpect(jsonPath("$[0].capacity", is(1)));
    }
}
