package renatius.cicddemo.bdd;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserSteps {

    private final RestTemplate restTemplate = new RestTemplate();
    private String response;

    @When("I request users")
    public void callApi() {
        response = restTemplate.getForObject(
                "http://localhost:8080/users",
                String.class
        );
    }

    @Then("response contains {string}")
    public void check(String expected) {
        assertTrue(response.contains(expected));
    }
}