package com.smartoffice.core;

public class ACObserver implements Observer {
    @Override
    public void update(int roomId, boolean occupied) {
        if (occupied) {
            System.out.println("AC in Room " + roomId + " turned ON.");
        } else {
            System.out.println("AC in Room " + roomId + " turned OFF.");
        }
    }
}
