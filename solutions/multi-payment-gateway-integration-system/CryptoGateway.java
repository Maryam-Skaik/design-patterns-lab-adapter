package adapter;

/**
 * Adaptee (Crypto Payment System)
 *
 * External crypto provider with different method structure.
 */
public class CryptoGateway {

    public void sendCryptoPayment(double amount) {
        System.out.println("Crypto payment sent: $" + amount);
    }
}
