package renatius.cicddemo.unit;

import org.junit.jupiter.api.Test;
import renatius.cicddemo.controller.UserController;
import renatius.cicddemo.service.UserService;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;

class UserControllerTest {

    private final UserController controller =
            new UserController(new UserService());

    @Test
    void shouldReturnUsers() {
        List<String> users = controller.getUsers();
        assertTrue(users.contains("Alice"));
    }
}