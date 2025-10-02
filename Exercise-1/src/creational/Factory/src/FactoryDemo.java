package creational;


public class FactoryDemo {
    public static void main(String[] args) {
        Course online = CourseFactory.createCourse(CourseFactory.Type.ONLINE, "Algorithms");
        Course offline = CourseFactory.createCourse(CourseFactory.Type.OFFLINE, "Mathematics");
        Course hybrid = CourseFactory.createCourse(CourseFactory.Type.HYBRID, "Physics");

        online.describe();
        offline.describe();
        hybrid.describe();
    }

    public interface Course {
        void describe();
    }

    public static class OnlineCourse implements Course {
        private final String name;
        public OnlineCourse(String name) { this.name = name; }
        @Override public void describe() {
            System.out.println("Online course: " + name + " (self-paced video + live doubt sessions)");
        }
    }

    public static class OfflineCourse implements Course {
        private final String name;
        public OfflineCourse(String name) { this.name = name; }
        @Override public void describe() {
            System.out.println("Offline course: " + name + " (in-classroom, limited seats)");
        }
    }

    public static class HybridCourse implements Course {
        private final String name;
        public HybridCourse(String name) { this.name = name; }
        @Override public void describe() {
            System.out.println("Hybrid course: " + name + " (mix of online material and classroom practice)");
        }
    }

    public static class CourseFactory {
        public enum Type { ONLINE, OFFLINE, HYBRID }

        public static Course createCourse(Type type, String name) {
            switch (type) {
                case ONLINE: return new OnlineCourse(name);
                case OFFLINE: return new OfflineCourse(name);
                case HYBRID: return new HybridCourse(name);
                default: throw new IllegalArgumentException("Unknown course type");
            }
        }
    }
}
