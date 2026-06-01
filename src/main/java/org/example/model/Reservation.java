package org.example.model;

import java.time.LocalDate;

public class Reservation {

    private int id;
    private User user;
    private Training training;
    private LocalDate reservationDate;
    private String status;

    public Reservation(int id, User user, Training training) {
        this.id = id;
        this.user = user;
        this.training = training;
        this.reservationDate = LocalDate.now();
        this.status = "CONFIRMED";
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Training getTraining() {
        return training;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public String getStatus() {
        return status;
    }

    public void confirm() {
        this.status = "CONFIRMED";
    }

    public void cancel() {
        this.status = "CANCELLED";

        if (training != null) {
            training.cancelSpot();
        }
    }

    public boolean isConfirmed() {
        return "CONFIRMED".equals(status);
    }

    public boolean isCancelled() {
        return "CANCELLED".equals(status);
    }
}
