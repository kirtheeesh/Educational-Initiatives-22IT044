package com.smartoffice;

import com.smartoffice.core.Office;
import com.smartoffice.utils.CommandParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Office office = Office.getInstance(); // Singleton
        CommandParser parser = new CommandParser();

        System.out.println("Welcome to SmartOffice Console");
        System.out.println("Type 'help' for commands.");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Shutting down...");
                break;
            }

            parser.handleCommand(input);
        }
        sc.close();
    }
}
