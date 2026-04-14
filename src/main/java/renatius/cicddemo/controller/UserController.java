package renatius.cicddemo.controller;

import org.springframework.web.bind.annotation.*;
import renatius.cicddemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getUsers() {
        return service.getUsers();
    }

    @PostMapping
    public String createUser(@RequestParam String name) {
        return service.createUser(name);
    }
}