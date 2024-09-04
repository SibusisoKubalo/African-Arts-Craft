package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.domain.Users;
import za.ac.cput.service.UserService;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testCreateUser() throws Exception {
        Users user = new Users.Builder()
                .setUsername("john_doe")
                .setPassword("password123")
                .setEmail("john.doe@example.com")
                .setFirst_name("John")
                .setLast_name("Doe")
                .setCreated_at(LocalDate.now())
                .setUpdated_at(LocalDate.now())
                .build();

        when(userService.create(any(Users.class))).thenReturn(user);

        mockMvc.perform(post("/store/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("john_doe"));
    }
}
