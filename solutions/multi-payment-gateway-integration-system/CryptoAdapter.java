package adapter;

/**
 * Adapter (Crypto → PaymentProcessor)
 *
 * Converts pay() into sendCryptoPayment()
 */
public class CryptoAdapter implements PaymentProcessor {

    private CryptoGateway cryptoGateway;

    public CryptoAdapter(CryptoGateway cryptoGateway) {
        this.cryptoGateway = cryptoGateway;
    }

    @Override
    public void pay(double amount) {
        cryptoGateway.sendCryptoPayment(amount);
    }
}
