package adapter;

/**
 * Adaptee (Legacy Bank System)
 *
 * External banking API with incompatible interface.
 */
public class LocalBankAPI {

    public void makeTransaction(double value) {
        System.out.println("Bank transaction completed: $" + value);
    }
}
