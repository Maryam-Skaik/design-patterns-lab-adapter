package adapter;

/**
 * Client (Backend Entry Point)
 *
 * This class represents the application layer that uses
 * the payment system.
 *
 * Important idea:
 * - The client ONLY depends on PaymentProcessor (abstraction)
 * - It does NOT know anything about LegacyBankAPI
 * - It does NOT care how payment is executed internally
 *
 * This is the key benefit of the Adapter Pattern:
 * → decoupling backend logic from external systems
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Creating the legacy system (incompatible API)
         */
        LegacyBankAPI legacyBankAPI = new LegacyBankAPI();

        /**
         * Wrapping the legacy system inside an adapter
         *
         * Now it becomes compatible with PaymentProcessor interface.
         */
        PaymentProcessor paymentProcessor = new BankAdapter(legacyBankAPI);

        /**
         * Backend interacts only with the standard interface
         *
         * It does NOT know:
         * - what LegacyBankAPI is
         * - how payment is processed internally
         */
        paymentProcessor.pay(250);
    }
}
