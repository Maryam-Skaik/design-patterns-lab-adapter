package adapter;

/**
 * Adaptee (Existing Incompatible System)
 *
 * This class represents an external or legacy banking system
 * that was NOT designed to match our backend architecture.
 *
 * Problem:
 * - It exposes a different method name (makeTransaction)
 * - It does not implement PaymentProcessor
 * - It cannot be modified directly (simulating third-party SDK)
 *
 * In real-world systems, this could be:
 * - external payment gateway
 * - old banking API
 * - third-party SDK
 */
public class LegacyBankAPI {

    /**
     * Performs a transaction using the legacy system's interface.
     *
     * @param value the transaction amount
     */
    public void makeTransaction(double value) {
        System.out.println("Transaction completed: $" + value);
    }
}
