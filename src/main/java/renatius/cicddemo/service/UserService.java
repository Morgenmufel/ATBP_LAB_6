package renatius.cicddemo.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    public List<String> getUsers() {
        return List.of("Alice", "Bob");
    }

    public String createUser(String name) {
        return "User " + name + " created";
    }
}
