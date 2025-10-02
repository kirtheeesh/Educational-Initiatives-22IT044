package structural;


public class AdapterDemo {
    public static void main(String[] args) {
        ExternalPaymentService external = new ExternalPaymentService();
        PaymentProcessor processor = new PaymentAdapter(external);

        double amount = 1499.50;
        boolean success = processor.processPayment(amount);
        System.out.println("Payment of " + amount + " successful? " + success);
    }

    // Target interface used across our system
    public interface PaymentProcessor {
        boolean processPayment(double amount);
    }

    // Third-party/external API that doesn't match our interface
    public static class ExternalPaymentService {
        // different method signature & return type
        public String makeExternalPayment(String merchantId, double money, String currency) {
            // mock behaviour: return transaction id when amount < 10k
            if (money <= 10000) {
                return "EXT-TXN-" + System.currentTimeMillis();
            } else {
                return null; // failure
            }
        }
    }

    // Adapter - converts our calls into ExternalPaymentService calls
    public static class PaymentAdapter implements PaymentProcessor {
        private final ExternalPaymentService external;
        private final String merchantId = "TUTORIAL_CENTER_001";
        private final String currency = "INR";

        public PaymentAdapter(ExternalPaymentService external) {
            this.external = external;
        }

        @Override
        public boolean processPayment(double amount) {
            System.out.println("Adapter: forwarding payment to external service...");
            String tx = external.makeExternalPayment(merchantId, amount, currency);
            if (tx != null) {
                System.out.println("Payment accepted. External TXN id: " + tx);
                return true;
            } else {
                System.out.println("Payment failed at external service.");
                return false;
            }
        }
    }
}
