package adapter;

/**
 * Adapter (PayPal → PaymentProcessor)
 */
public class PayPalAdapter implements PaymentProcessor {

    private PayPalService payPalService;

    public PayPalAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public void pay(double amount) {
        payPalService.executePayment(amount);
    }
}
