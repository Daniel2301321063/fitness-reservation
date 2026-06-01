package org.example.service;

import org.example.model.Reservation;
import org.example.model.Training;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private final List<Reservation> reservations = new ArrayList<>();
    private int nextReservationId = 1;

    public boolean reserveTraining(User user, Training training) {

        if (user == null) {
            return false;
        }

        if (training == null) {
            return false;
        }

        if (!training.hasAvailableSpots()) {
            return false;
        }

        Reservation reservation = new Reservation(
                nextReservationId,
                user,
                training
        );

        nextReservationId++;

        reservations.add(reservation);
        training.reserveSpot();

        return true;
    }

    public boolean cancelReservation(Reservation reservation) {

        if (reservation == null) {
            return false;
        }

        if (!reservations.contains(reservation)) {
            return false;
        }

        reservation.cancel();
        reservations.remove(reservation);

        return true;
    }

    public int getReservationCount() {
        return reservations.size();
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}