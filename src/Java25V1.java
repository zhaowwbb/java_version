public class Java25V1 {
    public class FinancialInstrument {
        protected final double amount;

        public FinancialInstrument(double amount) {
            this.amount = amount;
        }
    }

    public class AccountDeposit extends FinancialInstrument {
        public AccountDeposit(double amount, String currency) {
            // NEW in Java 25: Code before super()
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }

            // You can also perform local assignments or calculations
            System.out.println("Preparing to initialize deposit of: " + amount);

            super(amount); // super() no longer has to be the first line
        }
    }

    // Flexible Constructor Bodies
    public void test() {
        // This will trigger the validation before the superclass is even initialized
        AccountDeposit depositOK = new AccountDeposit(100.0, "USD");
        AccountDeposit depositBad = new AccountDeposit(0.0, "USD");
    }

    public static void main(String[] args) {
        Java25V1 java25 = new Java25V1();
        java25.test();
    }
}
