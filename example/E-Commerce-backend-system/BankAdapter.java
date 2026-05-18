package adapter;

/**
 * Adapter (Bridges incompatible interfaces)
 *
 * This class is the core of the Adapter Pattern.
 *
 * Responsibility:
 * - Converts the expected interface (PaymentProcessor)
 *   into a compatible call for LegacyBankAPI
 *
 * Why it is needed:
 * - The backend expects pay()
 * - The legacy system provides makeTransaction()
 *
 * Instead of modifying either side, this adapter translates between them.
 */
public class BankAdapter implements PaymentProcessor {

    /**
     * 🔗 Wrapped external system (composition)
     *
     * We use composition instead of inheritance to:
     * - reduce coupling
     * - improve flexibility
     * - allow easier testing and replacement
     */
    private LegacyBankAPI legacyBankAPI;

    /**
     * Constructor Injection
     *
     * The external service is injected into the adapter.
     * This allows:
     * - dependency flexibility
     * - easier unit testing
     * - better maintainability
     */
    public BankAdapter(LegacyBankAPI legacyBankAPI) {
        this.legacyBankAPI = legacyBankAPI;
    }

    /**
     * 🎯 Translates the standard method into legacy behavior
     *
     * Backend calls: pay()
     * Adapter converts it into: makeTransaction()
     */
    @Override
    public void pay(double amount) {
        legacyBankAPI.makeTransaction(amount);
    }
}
