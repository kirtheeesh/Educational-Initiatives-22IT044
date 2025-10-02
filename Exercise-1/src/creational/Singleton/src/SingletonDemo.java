package creational;

import java.util.*;


public class SingletonDemo {
    public static void main(String[] args) {
        EnrollmentManager m1 = EnrollmentManager.getInstance();
        EnrollmentManager m2 = EnrollmentManager.getInstance();

        System.out.println("Same instance? " + (m1 == m2));

        m1.enroll("Anita", "Java Foundations");
        m2.enroll("Ravi", "Java Foundations");
        m1.enroll("Isha", "Algorithms");

        m1.printEnrollments();
    }

    public static class EnrollmentManager {
        private static volatile EnrollmentManager instance;
        private final Map<String, List<String>> enrollments = new HashMap<>();

        private EnrollmentManager() { }

        public static EnrollmentManager getInstance() {
            if (instance == null) {
                synchronized (EnrollmentManager.class) {
                    if (instance == null) instance = new EnrollmentManager();
                }
            }
            return instance;
        }

        public void enroll(String studentName, String courseName) {
            enrollments.computeIfAbsent(courseName, k -> new ArrayList<>()).add(studentName);
            System.out.println("Enrolled " + studentName + " into " + courseName);
        }

        public void printEnrollments() {
            System.out.println("=== Enrollments ===");
            for (Map.Entry<String, List<String>> e : enrollments.entrySet()) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }
        }
    }
}
