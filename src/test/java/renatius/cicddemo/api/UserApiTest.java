package renatius.cicddemo.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UserApiTest {

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void shouldGetUsers() {
        String response = restTemplate.getForObject(
                "http://localhost:8080/users",
                String.class
        );

        assertNotNull(response);
        assertTrue(response.contains("Alice"));
    }

    @Test
    void shouldCreateUser() {
        String response = restTemplate.postForObject(
                "http://localhost:8080/users?name=John",
                null,
                String.class
        );

        assertNotNull(response);
        assertTrue(response.contains("John"));
    }
}