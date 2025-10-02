# 🎓 Tutorial Center – Design Patterns Demo (Java)

This project demonstrates **6 classic software design patterns** in Java using the example of a **Tutorial Center**.  
It covers **Behavioral, Creational, and Structural** design patterns.

---


## 🚀 How to Run

1. Clone this repository.
2. Compile the source files:
   ```bash
   javac src/**/*.java -d out
Patterns Implemented
🔹 1. Behavioral Patterns
a) Strategy Pattern – Teaching Strategies

Context: A tutor can switch between online teaching and classroom teaching dynamically.

Benefit: Makes teaching method flexible without changing the tutor’s code.

b) Observer Pattern – Student Notifications

Context: A course notifies enrolled students about class updates (time change, exam notice, etc.).

Benefit: Loose coupling between the course and students.

🔹 2. Creational Patterns
a) Factory Pattern – Course Creation

Context: A factory creates different types of courses (MathCourse, ScienceCourse) without exposing the creation logic.

Benefit: Decouples client from object creation.

b) Singleton Pattern – Tutorial Center

Context: Only one instance of the TutorialCenter exists.

Benefit: Centralized global access point for shared resources.

🔹 3. Structural Patterns
a) Decorator Pattern – Course Features

Context: Start with a basic course and dynamically add features like Video Lessons and Quizzes.

Benefit: Enhances objects without modifying their structure.

b) Adapter Pattern – Payment Systems

Context: Adapt an old cash-based payment system to work with a new online payment system.

Benefit: Bridges legacy systems with new interfaces.