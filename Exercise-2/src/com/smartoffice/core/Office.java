package com.smartoffice.core;

import java.util.*;

public class Office {
    private static Office instance;
    private Map<Integer, Room> rooms = new HashMap<>();

    private Office() {}

    public static Office getInstance() {
        if (instance == null) {
            instance = new Office();
        }
        return instance;
    }

    public void configureRooms(int count) {
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.put(i, new Room(i));
        }
        System.out.println("Office configured with " + count + " meeting rooms:");
        rooms.values().forEach(r -> System.out.println("Room " + r.getId()));
    }

    public Room getRoom(int id) {
        return rooms.get(id);
    }

    public boolean roomExists(int id) {
        return rooms.containsKey(id);
    }
}
