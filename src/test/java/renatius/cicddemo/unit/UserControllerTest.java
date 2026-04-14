package renatius.cicddemo.unit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import renatius.cicddemo.controller.UserController;
import renatius.cicddemo.service.UserService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UserControllerTest {

    UserController controller = new UserController(new UserService());

    @Test
    void shouldReturnUsers() {
        List<String> users = controller.getUsers();
        assertTrue(users.contains("Alice"));
    }
}
