package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.model.Admin;
import org.example.model.Training;
import org.example.service.AdminService;

import static org.junit.jupiter.api.Assertions.*;

public class AddTrainingSteps {

    private final AdminService adminService = new AdminService();

    private Admin admin;
    private Training training;

    private boolean result;
    private int trainingsBefore;

    @Given("the admin is logged in")
    public void adminLoggedIn() {

        admin = new Admin(
                "Admin",
                "admin@test.com",
                "admin123"
        );
    }

    @Given("the admin is not logged in")
    public void adminNotLoggedIn() {
        admin = null;
    }

    @Given("the admin enters valid training data")
    public void validTrainingData() {

        training = new Training(
                "Fitness",
                15
        );

        trainingsBefore =
                adminService.getTrainingCount();
    }

    @Given("the training title is empty")
    public void emptyTrainingTitle() {

        training = new Training(
                "",
                10
        );
    }

    @Given("the training capacity is negative")
    public void negativeCapacity() {

        training = new Training(
                "Fitness",
                -5
        );
    }

    @When("the admin adds the training")
    public void addTraining() {

        result = adminService.addTraining(
                admin,
                training
        );
    }

    @Then("the training should be added successfully")
    public void trainingAddedSuccessfully() {
        assertTrue(result);
    }

    @Then("adding training should fail")
    public void addingTrainingFails() {
        assertFalse(result);
    }

    @Then("the number of trainings should increase")
    public void trainingsIncrease() {

        assertTrue(result);

        assertEquals(
                trainingsBefore + 1,
                adminService.getTrainingCount()
        );
    }
}
