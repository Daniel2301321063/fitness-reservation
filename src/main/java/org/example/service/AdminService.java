package org.example.service;

import org.example.model.Admin;
import org.example.model.Training;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    private final List<Training> trainings = new ArrayList<>();

    public boolean addTraining(Admin admin, Training training) {

        if (admin == null) {
            return false;
        }

        if (training == null) {
            return false;
        }

        if (training.getTitle() == null ||
                training.getTitle().isEmpty()) {
            return false;
        }

        if (training.getCapacity() <= 0) {
            return false;
        }

        trainings.add(training);
        return true;
    }

    public int getTrainingCount() {
        return trainings.size();
    }
}