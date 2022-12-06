package com.SkillBox.users.controllers;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.UsersApplication;
import com.SkillBox.users.testcontainers.config.ContainersEnvironment;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(classes = UsersApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class UserControllerTest extends ContainersEnvironment {

    private final String jsonTest = "{\"id\":\"039fb3b6-6693-11ed-9022-0242ac120002\",\"firstName\":\"Petroff\",\"lastName\":\"Ivan\",\"middleName\":\"Sidorovich\",\"gender\":true,\"birthday\":\"01.01.2000\",\"currentLocation\":\"Moscow\",\"avatarLink\":\"http://avatars.com/random/123\",\"personalInfo\":\"Some personal info\",\"nickname\":\"Bojor\",\"email\":\"petroff@mail.ru\",\"phone\":\"+7(951)125-15-15\",\"deleted\":false}";

    private final User existedUser = new User(
            "Petroff",
            "Ivan",
            "Sidorovich",
            true,
            "01.01.2000",
            "Moscow",
            "http://avatars.com/random/123",
            "Some personal info",
            "Bojor",
            "petroff@mail.ru",
            "+7(951)125-15-15",
            false);


    private final User newTestUser = new User(
            "Volachkova",
            "Olga",
            "Olegovna",
            false,
            "01.01.1970",
            "Moscow",
            "http://avatars.com/V/100",
            "Balle rina",
            "Vola",
            "vola@mail.ru",
            "+7(999)777-00-00",
            false);

    @Autowired
    private ObjectMapper objectMapper;

    //needs @AutoConfigureMockMvc
    @Autowired
    private MockMvc mockMvc;


    // проверяется создание контроллера
    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void whenGetByCorrectId_thenReturn_OK() throws Exception {
        this.mockMvc
                .perform(get("/users/039fb3b6-6693-11ed-9022-0242ac120002"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void whenGetByWrongId_thenReturn_NOT_FOUND() throws Exception {
        this.mockMvc
                .perform(get("/users/039fb3b6-6693-11ed-9022-0242ac120007"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void whenGetByCorrectId_thenReturn_CorrectJSON() throws Exception {

        String json = this.mockMvc
                .perform(get("/users/039fb3b6-6693-11ed-9022-0242ac120002"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse().getContentAsString();

        Assertions.assertEquals(jsonTest, json);
    }

    @Test
    public void whenPOST_thenReturn_() throws Exception {

        String result = mockMvc
                .perform(post("/users")
                        .content(objectMapper.writeValueAsString(newTestUser))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Assertions.assertTrue(result.contains("Saved OK UserId:"));
    }
}