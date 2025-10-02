package com.smartoffice.utils;

import com.smartoffice.commands.*;
import com.smartoffice.core.Office;

public class CommandParser {

    public void handleCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        String[] parts = input.trim().split(" ");
        String cmd = parts[0].toLowerCase();

        try {
            switch (cmd) {
                case "help":
                    printHelp();
                    break;

                case "config":
                    if (parts.length == 4 && parts[1].equalsIgnoreCase("room") && parts[2].equalsIgnoreCase("count")) {
                        int count = Integer.parseInt(parts[3]);
                        Office.getInstance().configureRooms(count);
                    } else if (parts.length == 5 && parts[1].equalsIgnoreCase("room") && parts[2].equalsIgnoreCase("max") && parts[3].equalsIgnoreCase("capacity")) {
                        int roomId = Integer.parseInt(parts[4].split("-")[0]); // handles "1" or "1-5"
                        int capacity = Integer.parseInt(parts[4].split("-")[1]);
                        Office office = Office.getInstance();
                        if (!office.roomExists(roomId)) {
                            System.out.println("Invalid room number. Please enter a valid room number.");
                            return;
                        }
                        office.getRoom(roomId).setCapacity(capacity);
                    } else {
                        System.out.println("Invalid config command.");
                    }
                    break;

                case "block":
                    if (parts.length == 4) {
                        int roomId = Integer.parseInt(parts[1]);
                        String time = parts[2];
                        int duration = Integer.parseInt(parts[3]);
                        new BookRoomCommand(roomId, time, duration).execute();
                    } else {
                        System.out.println("Usage: block <roomId> <time> <duration>");
                    }
                    break;

                case "cancel":
                    if (parts.length == 2) {
                        int roomId = Integer.parseInt(parts[1]);
                        new CancelRoomCommand(roomId).execute();
                    } else {
                        System.out.println("Usage: cancel <roomId>");
                    }
                    break;

                case "add":
                    if (parts.length == 4 && parts[1].equalsIgnoreCase("occupant")) {
                        int roomId = Integer.parseInt(parts[2]);
                        int count = Integer.parseInt(parts[3]);
                        new AddOccupantCommand(roomId, count).execute();
                    } else {
                        System.out.println("Usage: add occupant <roomId> <count>");
                    }
                    break;

                case "status":
                    if (parts.length == 2) {
                        int roomId = Integer.parseInt(parts[1]);
                        new StatusCommand(roomId).execute();
                    } else {
                        System.out.println("Usage: status <roomId>");
                    }
                    break;

                default:
                    System.out.println("Unknown command. Type 'help' for a list of commands.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please try again.");
        } catch (Exception e) {
            System.out.println("Error processing command: " + e.getMessage());
        }
    }

    private void printHelp() {
        System.out.println("Available Commands:");
        System.out.println(" config room count <n>");
        System.out.println(" config room max capacity <roomId-capacity>");
        System.out.println(" block <roomId> <time> <duration>");
        System.out.println(" cancel <roomId>");
        System.out.println(" add occupant <roomId> <count>");
        System.out.println(" status <roomId>");
        System.out.println(" exit");
    }
}
