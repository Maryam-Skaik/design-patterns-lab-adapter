package adapter;

/**
 * Client (Checkout System)
 *
 * Depends ONLY on PaymentProcessor abstraction.
 * Does NOT know which payment provider is used.
 */
public class Main {

    public static void main(String[] args) {

        double amount = 100;

        /**
         * Stripe Payment Flow
         */
        PaymentProcessor stripePayment = new StripeAdapter(new StripeService());
        stripePayment.pay(amount);

        /**
         * Bank Payment Flow
         */
        PaymentProcessor bankPayment = new BankAdapter(new LocalBankAPI());
        bankPayment.pay(amount);

        /**
         * Crypto Payment Flow
         */
        PaymentProcessor cryptoPayment = new CryptoAdapter(new CryptoGateway());
        cryptoPayment.pay(amount);
    }
}
