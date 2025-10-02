package com.smartoffice.core;

import java.util.ArrayList;
import java.util.List;

public class Room extends OccupancySubject {
    private int id;
    private int capacity = 0;
    private boolean booked = false;
    private boolean occupied = false;
    private int occupants = 0;

    public Room(int id) {
        this.id = id;
    }

    public int getId() { return id; }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Invalid capacity. Please enter a valid positive number.");
            return;
        }
        this.capacity = capacity;
        System.out.println("Room " + id + " maximum capacity set to " + capacity + ".");
    }

    public void book(String time, int duration) {
        if (booked) {
            System.out.println("Room " + id + " is already booked during this time. Cannot book.");
            return;
        }
        booked = true;
        System.out.println("Room " + id + " booked from " + time + " for " + duration + " minutes.");
    }

    public void cancelBooking() {
        if (!booked) {
            System.out.println("Room " + id + " is not booked. Cannot cancel booking.");
            return;
        }
        booked = false;
        System.out.println("Booking for Room " + id + " cancelled successfully.");
    }

    public void addOccupants(int count) {
        this.occupants = count;
        if (count >= 2) {
            if (!occupied) {
                occupied = true;
                System.out.println("Room " + id + " is now occupied by " + count + " persons. AC and lights turned on.");
                notifyObservers(true);
            }
        } else {
            occupied = false;
            System.out.println("Room " + id + " is now unoccupied. AC and lights turned off.");
            notifyObservers(false);
        }
    }

    public void showStatus() {
        System.out.println("Room " + id + " occupied=" + occupied + " booking=" + (booked ? "Booked" : "Not booked"));
    }
}
