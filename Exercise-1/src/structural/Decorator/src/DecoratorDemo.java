package structural;


public class DecoratorDemo {
    public static void main(String[] args) {
        Material base = new BaseMaterial("Intro to Java", 30);
        Material withVideo = new VideoDecorator(base, 20); // 20 minutes of video
        Material withQuiz = new QuizDecorator(withVideo, 10); // 10 minutes quiz
        Material withTranscript = new TranscriptDecorator(withQuiz);

        System.out.println("Description: " + withTranscript.getDescription());
        System.out.println("Total duration (minutes): " + withTranscript.getDurationMinutes());
    }

    public interface Material {
        String getDescription();
        int getDurationMinutes();
    }

    public static class BaseMaterial implements Material {
        private final String title;
        private final int durationMinutes;

        public BaseMaterial(String title, int durationMinutes) {
            this.title = title;
            this.durationMinutes = durationMinutes;
        }

        @Override public String getDescription() { return title + " (core notes)"; }
        @Override public int getDurationMinutes() { return durationMinutes; }
    }

    // base decorator
    public static abstract class MaterialDecorator implements Material {
        protected final Material wrapped;
        public MaterialDecorator(Material wrapped) { this.wrapped = wrapped; }
        @Override public String getDescription() { return wrapped.getDescription(); }
        @Override public int getDurationMinutes() { return wrapped.getDurationMinutes(); }
    }

    public static class VideoDecorator extends MaterialDecorator {
        private final int extraMinutes;
        public VideoDecorator(Material wrapped, int extraMinutes) {
            super(wrapped);
            this.extraMinutes = extraMinutes;
        }
        @Override public String getDescription() {
            return wrapped.getDescription() + " + Video(" + extraMinutes + "m)";
        }
        @Override public int getDurationMinutes() {
            return wrapped.getDurationMinutes() + extraMinutes;
        }
    }

    public static class QuizDecorator extends MaterialDecorator {
        private final int quizMinutes;
        public QuizDecorator(Material wrapped, int quizMinutes) {
            super(wrapped);
            this.quizMinutes = quizMinutes;
        }
        @Override public String getDescription() {
            return wrapped.getDescription() + " + Quiz(" + quizMinutes + "m)";
        }
        @Override public int getDurationMinutes() {
            return wrapped.getDurationMinutes() + quizMinutes;
        }
    }

    public static class TranscriptDecorator extends MaterialDecorator {
        public TranscriptDecorator(Material wrapped) { super(wrapped); }
        @Override public String getDescription() {
            return wrapped.getDescription() + " + Transcript";
        }
        // transcript doesn't add play time
        @Override public int getDurationMinutes() { return wrapped.getDurationMinutes(); }
    }
}
