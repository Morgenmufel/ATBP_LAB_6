package renatius.cicddemo.api;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class UserApiTest {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8080";

    @Test
    void shouldGetUsers() {
        waitForApp();

        String response = restTemplate.getForObject(
                BASE_URL + "/users",
                String.class
        );

        assertNotNull(response);
        assertTrue(response.contains("Alice"));
    }

    @Test
    void shouldCreateUser() {
        waitForApp();

        String response = restTemplate.postForObject(
                BASE_URL + "/users?name=John",
                null,
                String.class
        );

        assertNotNull(response);
        assertTrue(response.contains("John"));
    }

    private void waitForApp() {
        for (int i = 0; i < 30; i++) {
            try {
                restTemplate.getForObject(BASE_URL + "/users", String.class);
                return;
            } catch (Exception ignored) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new RuntimeException("App did not start in time");
    }
}