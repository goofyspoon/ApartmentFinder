/*package myProject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

public class TestBySingleId {

    @Autowired
    private MockMvc controller;

    @MockBean
    private UsersDB userDB;

    @MockBean
    private UserController control;

    @Test
    public void testSingle() throws Exception {

        Users user = new Users(0, "Test", "test", "te@st.re");
        Users var = userDB.createUser(user);
        when(userDB.findByUserName("Test")).thenReturn((List<Users>) var);
        controller.perform(get("/User/{userName}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userName", is("Test")));

    }
}
*/

