# 🏢 Smart Office Facility – Console Application

A Java console-based application to manage a **Smart Office Facility** with **conference room bookings, occupancy detection, and automated control of AC & lighting**.

This project demonstrates **Design Patterns**:

* **Singleton Pattern** – Office configuration & booking system.
* **Observer Pattern** – Sensors (lights, AC) responding to occupancy changes.
* **Command Pattern** – Booking, cancellation, and occupancy as commands.

---

## 📂 Folder Structure

```
SmartOffice/
├── src/
│   └── com/smartoffice/
│       ├── Main.java
│       ├── core/
│       │   ├── Office.java
│       │   ├── Room.java
│       │   └── Command.java
│       │
│       ├── commands/
│       │   ├── ConfigRoomCommand.java
│       │   ├── BlockRoomCommand.java
│       │   ├── CancelRoomCommand.java
│       │   ├── AddOccupantCommand.java
│       │   └── StatusCommand.java
│       │
│       ├── observers/
│       │   ├── OccupancyObserver.java
│       │   ├── Light.java
│       │   └── AirConditioner.java
│       │
│       └── utils/
│           ├── CommandParser.java
│           └── Logger.java
│
├── README.md
└── .gitignore
```

---

## 🚀 How to Run

1. Clone this repo:

   ```bash
   git clone https://github.com/yourusername/SmartOffice.git
   cd SmartOffice
   ```

2. Compile:

   ```bash
   javac -d out src/com/smartoffice/**/*.java
   ```

3. Run:

   ```bash
   java -cp out com.smartoffice.Main
   ```

---

## 🖥 Example Run

```
Welcome to SmartOffice Console
Type 'help' for commands.

> config room count 3
Office configured with 3 meeting rooms:
Room 1
Room 2
Room 3

> config room max capacity 1 10
Room 1 maximum capacity set to 10.

> block 1 09:00 60
Room 1 booked from 09:00 for 60 minutes.

> add occupant 1 2
Room 1 is now occupied by at least 2 persons. AC and lights turned on.
Room 1 occupant count: 2
Light in Room 1 turned ON.
AC in Room 1 turned ON.

> add occupant 1 0
Room 1 is now unoccupied. AC and lights turned off.
Room 1 occupant count: 2
Light in Room 1 turned OFF.
AC in Room 1 turned OFF.

> cancel 1
Booking for Room 1 cancelled successfully.

> block 1 09:00 60
Room 1 booked from 09:00 for 60 minutes.

> block 1 09:00 60
Room 1 is already booked during this time. Cannot book.

> cancel 2
Room 2 is not booked. Cannot cancel booking.

> add occupant 2 1
Room 2 occupant count: 1

> status 1
Room 1 occupied=false booking=Room 1 booked from 09:00 for 60 minutes by user

> exit
Shutting down...
