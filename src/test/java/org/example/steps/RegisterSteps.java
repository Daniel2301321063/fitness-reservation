package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.model.User;
import org.example.service.UserService;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterSteps {

    private final UserService userService = new UserService();

    private User user;
    private boolean result;

    @Given("the user enters valid registration data")
    public void validRegistrationData() {
        user = new User(
                "Ivan",
                "ivan@test.com",
                "123456"
        );
    }

    @When("the user submits the registration form")
    public void submitRegistrationForm() {
        result = userService.register(user);
    }

    @Then("the account should be created successfully")
    public void accountCreatedSuccessfully() {
        assertTrue(result);
    }

    @Given("a user with the same email already exists")
    public void existingEmail() {

        User existing = new User(
                "Ivan",
                "ivan@test.com",
                "123456"
        );

        userService.register(existing);

        user = new User(
                "Petar",
                "ivan@test.com",
                "654321"
        );
    }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        assertFalse(result);
    }

    @Given("the email field is empty")
    public void emptyEmailField() {
        user = new User(
                "Ivan",
                "",
                "123456"
        );
    }

    @Then("registration should fail")
    public void registrationFails() {
        assertFalse(result);
    }

    @Given("the password is shorter than 6 characters")
    public void shortPassword() {
        user = new User(
                "Ivan",
                "ivan@test.com",
                "123"
        );
    }

    @Given("the name field is empty")
    public void emptyNameField() {
        user = new User(
                "",
                "ivan@test.com",
                "123456"
        );
    }
}
