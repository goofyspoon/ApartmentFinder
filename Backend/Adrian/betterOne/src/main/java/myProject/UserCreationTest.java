package myProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class UserCreationTest {

    @MockBean
    private Users u;

    @Test
    public void testit(){

        Users use = new Users();

        use.setPassword("Test");
        use.setUserName("test");
        use.setEmail("test@test.test");

        assertEquals("Test", use.getPassword());
        assertEquals("test", use.getUserName());
        assertEquals("test@test.test", use.getEmail());

    }

}
