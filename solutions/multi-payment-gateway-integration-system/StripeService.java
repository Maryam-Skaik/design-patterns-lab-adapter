package adapter;

/**
 * Adaptee (External Stripe System)
 *
 * Incompatible payment provider with its own API.
 * Cannot be modified.
 */
public class StripeService {

    public void processPayment(double amount) {
        System.out.println("Stripe payment processed: $" + amount);
    }
}
