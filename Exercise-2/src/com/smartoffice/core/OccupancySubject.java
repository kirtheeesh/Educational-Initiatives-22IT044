package com.smartoffice.core;

import java.util.ArrayList;
import java.util.List;

public abstract class OccupancySubject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(boolean occupied) {
        for (Observer observer : observers) {
            if (this instanceof Room) {
                Room room = (Room) this;
                observer.update(room.getId(), occupied);
            }
        }
    }
}
