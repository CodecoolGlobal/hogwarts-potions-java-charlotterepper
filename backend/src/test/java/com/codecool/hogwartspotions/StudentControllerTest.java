package com.codecool.hogwartspotions;

import com.codecool.hogwartspotions.controller.StudentController;
import com.codecool.hogwartspotions.model.HouseType;
import com.codecool.hogwartspotions.model.PetType;
import com.codecool.hogwartspotions.model.Student;
import com.codecool.hogwartspotions.service.StudentService;
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

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    StudentService studentService;

    @Test
    void getAll() throws Exception {
        // Arrange
        Student student = new Student("A", "B", HouseType.GRYFFINDOR, PetType.CAT);
        student.setId(1L);
        when(studentService.getAllStudents()).thenReturn(List.of(student));

        // Act
        ResultActions resultActions = mvc.perform(get("/students"));

        // Assert
        resultActions.andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(1)))
            .andExpect(jsonPath("$[0].firstName", is("A")))
            .andExpect(jsonPath("$[0].lastName", is("B")))
            .andExpect(jsonPath("$[0].houseType", is("GRYFFINDOR")))
            .andExpect(jsonPath("$[0].petType", is("CAT")));
    }
}
