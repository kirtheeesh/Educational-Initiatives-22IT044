package behavioral;

import java.util.*;


public class StrategyDemo {
    public static void main(String[] args) {
        Student s = new Student("Anita", Arrays.asList(72, 88, 95));

        AssessmentStrategy weighted = new WeightedAverageStrategy();
        AssessmentStrategy highest = new HighestScoreStrategy();
        AssessmentStrategy project = new ProjectBasedStrategy();

        System.out.println("Student: " + s.getName());
        System.out.println("Weighted Average Score: " + weighted.evaluate(s));
        System.out.println("Highest Score Strategy: " + highest.evaluate(s));
        System.out.println("Project-based Strategy: " + project.evaluate(s));
    }

    // domain
    public static class Student {
        private String name;
        private List<Integer> scores;

        public Student(String name, List<Integer> scores) {
            this.name = name;
            this.scores = new ArrayList<>(scores);
        }

        public String getName() { return name; }
        public List<Integer> getScores() { return Collections.unmodifiableList(scores); }
    }

    // Strategy interface
    public interface AssessmentStrategy {
        double evaluate(Student s);
    }

    // concrete strategies
    public static class WeightedAverageStrategy implements AssessmentStrategy {
        @Override
        public double evaluate(Student s) {
            List<Integer> scores = s.getScores();
            if (scores.isEmpty()) return 0;
            double sum = 0;
            for (int sc : scores) sum += sc;
            return Math.round((sum / scores.size()) * 100.0) / 100.0;
        }
    }

    public static class HighestScoreStrategy implements AssessmentStrategy {
        @Override
        public double evaluate(Student s) {
            return s.getScores().stream().mapToInt(Integer::intValue).max().orElse(0);
        }
    }

    // Example: project-based: last score weighs 60%, others 40% average
    public static class ProjectBasedStrategy implements AssessmentStrategy {
        @Override
        public double evaluate(Student s) {
            List<Integer> scores = s.getScores();
            if (scores.isEmpty()) return 0;
            int last = scores.get(scores.size()-1);
            double othersAvg = 0;
            if (scores.size() > 1) {
                othersAvg = scores.subList(0, scores.size()-1).stream().mapToInt(Integer::intValue).average().orElse(0);
            }
            double result = 0.6 * last + 0.4 * othersAvg;
            return Math.round(result * 100.0) / 100.0;
        }
    }
}
