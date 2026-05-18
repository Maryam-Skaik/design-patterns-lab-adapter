package adapter;

/**
 * Target Interface (Expected by the Backend)
 *
 * This interface defines the standard contract that all payment
 * providers must follow in the system.
 *
 * In real backend systems, this acts as an abstraction layer between:
 * - business logic (backend)
 * - external payment providers (APIs / SDKs)
 *
 * Why it exists:
 * - Ensures consistency across different payment implementations
 * - Allows the backend to depend only on abstractions
 * - Enables scalability (add new providers without changing backend code)
 */
public interface PaymentProcessor {

    /**
     * Executes a payment operation.
     *
     * @param amount the amount to be paid
     */
    void pay(double amount);
}
