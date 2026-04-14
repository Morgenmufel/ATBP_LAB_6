package renatius.cicddemo.api;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
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
                ResponseEntity<String> response = restTemplate.getForEntity(
                        BASE_URL + "/users",
                        String.class
                );
                if (response.getStatusCode().is2xxSuccessful()) {
                    System.out.println("✅ App is ready");
                    return;
                }
            } catch (Exception e) {
                System.out.println("⏳ Waiting for app... (" + (i+1) + "/30) - " + e.getMessage());
            }
            try {
                Thread.sleep(2000); // 2 секунды вместо 1
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("❌ App did not start in 60 seconds");
    }
}