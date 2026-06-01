package org.example.model;

public class Training {

    private String title;
    private int capacity;
    private int reservedSpots;

    public Training(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.reservedSpots = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getReservedSpots() {
        return reservedSpots;
    }

    public boolean hasAvailableSpots() {
        return reservedSpots < capacity;
    }

    public void reserveSpot() {
        if (hasAvailableSpots()) {
            reservedSpots++;
        }
    }

    public void cancelSpot() {
        if (reservedSpots > 0) {
            reservedSpots--;
        }
    }
}
