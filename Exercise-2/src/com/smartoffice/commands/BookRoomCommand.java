package com.smartoffice.commands;

import com.smartoffice.core.Office;
import com.smartoffice.core.Room;

public class BookRoomCommand implements Command {
    private int roomId;
    private String time;
    private int duration;

    public BookRoomCommand(int roomId, String time, int duration) {
        this.roomId = roomId;
        this.time = time;
        this.duration = duration;
    }

    @Override
    public void execute() {
        Office office = Office.getInstance();
        if (!office.roomExists(roomId)) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        Room room = office.getRoom(roomId);
        room.book(time, duration);
    }
}
