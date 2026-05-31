package adapter;

/**
 * Adapter (Bank → PaymentProcessor)
 *
 * Converts pay() into makeTransaction()
 */
public class BankAdapter implements PaymentProcessor {

    private LocalBankAPI localBankAPI;

    public BankAdapter(LocalBankAPI localBankAPI) {
        this.localBankAPI = localBankAPI;
    }

    @Override
    public void pay(double amount) {
        localBankAPI.makeTransaction(amount);
    }
}
