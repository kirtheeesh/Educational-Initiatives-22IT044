package com.smartoffice.core;

public class LightObserver implements Observer {
    @Override
    public void update(int roomId, boolean occupied) {
        if (occupied) {
            System.out.println("Light in Room " + roomId + " turned ON.");
        } else {
            System.out.println("Light in Room " + roomId + " turned OFF.");
        }
    }
}
