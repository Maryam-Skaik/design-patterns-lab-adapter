package adapter;

/**
 * Target Interface (Expected by Checkout System)
 *
 * Defines the unified contract for all payment providers.
 * The backend depends ONLY on this abstraction.
 */
public interface PaymentProcessor {

    /**
     * Executes a payment operation.
     *
     * @param amount payment amount
     */
    void pay(double amount);
}
