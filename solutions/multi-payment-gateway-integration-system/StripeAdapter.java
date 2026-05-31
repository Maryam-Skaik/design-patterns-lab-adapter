package adapter;

/**
 * Adapter (Stripe → PaymentProcessor)
 *
 * Converts PaymentProcessor.pay() into StripeService.processPayment()
 */
public class StripeAdapter implements PaymentProcessor {

    private StripeService stripeService;

    public StripeAdapter(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public void pay(double amount) {
        stripeService.processPayment(amount);
    }
}
