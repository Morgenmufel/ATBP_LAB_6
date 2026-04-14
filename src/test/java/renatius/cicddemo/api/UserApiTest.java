package renatius.cicddemo.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApiTest {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void shouldGetUsers() {
        String url = "http://localhost:" + port + "/users";

        String response = restTemplate.getForObject(url, String.class);

        assertNotNull(response);
        assertTrue(response.contains("Alice"));
    }

    @Test
    void shouldCreateUser() {
        String url = "http://localhost:" + port + "/users?name=John";

        String response = restTemplate.postForObject(url, null, String.class);

        assertNotNull(response);
        assertTrue(response.contains("John"));
    }
}