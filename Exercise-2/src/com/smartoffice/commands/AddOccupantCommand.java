package com.smartoffice.commands;

import com.smartoffice.core.*;

public class AddOccupantCommand implements Command {
    private int roomId;
    private int count;

    public AddOccupantCommand(int roomId, int count) {
        this.roomId = roomId;
        this.count = count;
    }

    @Override
    public void execute() {
        Office office = Office.getInstance();
        if (!office.roomExists(roomId)) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        Room room = office.getRoom(roomId);

        // Attach observers if not already done
        room.addObserver(new LightObserver());
        room.addObserver(new ACObserver());

        room.addOccupants(count);
    }
}
