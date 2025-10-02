package com.smartoffice.commands;

import com.smartoffice.core.Office;
import com.smartoffice.core.Room;

public class CancelRoomCommand implements Command {
    private int roomId;

    public CancelRoomCommand(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public void execute() {
        Office office = Office.getInstance();
        if (!office.roomExists(roomId)) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        Room room = office.getRoom(roomId);
        room.cancelBooking();
    }
}
