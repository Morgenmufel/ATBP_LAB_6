package renatius.cicddemo.bdd;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserSteps {

    private final RestTemplate restTemplate = new RestTemplate();
    private String response;
    private final String BASE_URL = "http://localhost:8080";

    @When("I request users")
    public String callApi() {
        return restTemplate.getForObject(BASE_URL + "/users", String.class);
    }

    @Then("response contains {string}")
    public void check(String expected) {
        assertTrue(response.contains(expected));
    }
}