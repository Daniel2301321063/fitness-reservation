package org.example.service;

import org.example.model.Training;
import org.example.model.User;

public class ReservationService {

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

        training.reserveSpot();
        return true;
    }
}
