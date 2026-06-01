package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.model.Training;
import org.example.model.User;
import org.example.service.ReservationService;

import static org.junit.jupiter.api.Assertions.*;

public class ReserveTrainingSteps {

    private final ReservationService reservationService = new ReservationService();

    private User user;
    private Training training;
    private boolean result;
    private int reservedBefore;

    @Given("the user is logged in")
    public void userIsLoggedIn() {
        user = new User("Ivan", "ivan@test.com", "123456");
    }

    @Given("the user is not logged in")
    public void userIsNotLoggedIn() {
        user = null;
    }

    @Given("the training has available spots")
    public void trainingHasAvailableSpots() {
        training = new Training("Yoga", 10);
        reservedBefore = training.getReservedSpots();
    }

    @Given("the training has no available spots")
    public void trainingHasNoAvailableSpots() {
        training = new Training("Yoga", 0);
    }

    @Given("the training does not exist")
    public void trainingDoesNotExist() {
        training = null;
    }

    @When("the user reserves the training")
    public void userReservesTraining() {
        result = reservationService.reserveTraining(user, training);
    }

    @Then("the reservation should be successful")
    public void reservationShouldBeSuccessful() {
        assertTrue(result);
    }

    @Then("the reservation should fail")
    public void reservationShouldFail() {
        assertFalse(result);
    }

    @Then("the number of reserved spots should increase")
    public void reservedSpotsShouldIncrease() {
        assertTrue(result);
        assertEquals(reservedBefore + 1, training.getReservedSpots());
    }
}