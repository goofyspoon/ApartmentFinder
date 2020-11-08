/*package myProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class TestPost {

    @Autowired
    private MockMvc controller;

    @MockBean
    private UsersDB userDB;

    @MockBean
    private UserController control;


    @Test
    public void Create() throws Exception{

    Users use = new Users(0,"Test", "TestPass", "test@test.test");

    use.setEmail("test@test.test");
    use.setUserName("Test");
    use.setPassword("TestPass");

    control.createUser(use);
        userDB.createUser(use);
        when(userDB.createUser(use)).thenReturn(use);
        when(control.createUser(use)).thenReturn(use);

        control.createUser(use);
        userDB.createUser(use);
    ObjectMapper o = new ObjectMapper();

    this.controller.perform(post("/User")
    .contentType(MediaType.APPLICATION_JSON)
    .content(String.valueOf(use)))
    .andExpect(status().isOk())
            .andExpect(jsonPath("$.UserName", is("Test")))
            .andExpect(jsonPath("$.Password", is("TestPass")))
            .andExpect(jsonPath("$.Email", is("test@test.test")));

    }
}
*/