package behavioral;

import java.util.*;

public class ObserverDemo {
    public static void main(String[] args) {
        Course javaCourse = new Course("Java Foundations");

        CourseObserver s1 = new StudentObserver("Ravi");
        CourseObserver s2 = new StudentObserver("Maya");
        CourseObserver s3 = new StudentObserver("Isha");

        javaCourse.registerObserver(s1);
        javaCourse.registerObserver(s2);
        javaCourse.registerObserver(s3);

        javaCourse.addContent("Lecture 1: Intro to Java");
        javaCourse.scheduleClass("2025-10-05 17:00 IST");

        // Maya unsubscribes
        javaCourse.unregisterObserver(s2);

        javaCourse.addContent("Assignment 1: Basic OOP");
    }

    // Subject
    public static class Course {
        private final String title;
        private final List<CourseObserver> observers = new ArrayList<>();

        public Course(String title) { this.title = title; }

        public void registerObserver(CourseObserver o) {
            observers.add(o);
            System.out.println(o.getName() + " subscribed to " + title);
        }
        public void unregisterObserver(CourseObserver o) {
            observers.remove(o);
            System.out.println(o.getName() + " unsubscribed from " + title);
        }

        private void notifyObservers(String notification) {
            for (CourseObserver o : observers) o.update(title, notification);
        }

        public void addContent(String content) {
            System.out.println("Course '" + title + "' added content: " + content);
            notifyObservers("New content posted: " + content);
        }

        public void scheduleClass(String dateTime) {
            System.out.println("Course '" + title + "' scheduled a class at " + dateTime);
            notifyObservers("Class scheduled at " + dateTime);
        }
    }

    // Observer interface
    public interface CourseObserver {
        void update(String courseTitle, String message);
        String getName();
    }

    // concrete observer
    public static class StudentObserver implements CourseObserver {
        private final String name;

        public StudentObserver(String name) { this.name = name; }

        @Override
        public void update(String courseTitle, String message) {
            System.out.println("[" + name + "] received from '" + courseTitle + "': " + message);
        }

        @Override
        public String getName() { return name; }
    }
}
