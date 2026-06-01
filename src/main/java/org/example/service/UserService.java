package org.example.service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public boolean register(User user) {

        if (user.getName() == null || user.getName().isEmpty()) {
            return false;
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return false;
        }

        if (user.getPassword().length() < 6) {
            return false;
        }

        boolean exists = users.stream()
                .anyMatch(u -> u.getEmail().equals(user.getEmail()));

        if (exists) {
            return false;
        }

        users.add(user);
        return true;
    }
}
