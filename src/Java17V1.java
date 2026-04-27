/**
 * A sealed class hierarchy representing different types of bank accounts.
 * The 'permits' clause explicitly lists the allowed subclasses.
 */
sealed class BankAccount permits SavingsAccount, CheckingAccount, CreditAccount {}

// Permitted subclasses must be 'final', 'sealed', or 'non-sealed'
final class SavingsAccount extends BankAccount {
    double interestRate = 0.05;
}

final class CheckingAccount extends BankAccount {
    double limit = 1000.0;
}

// 'non-sealed' opens the class back up for traditional inheritance
non-sealed class CreditAccount extends BankAccount {
    double balance = -500.0;
}

public class Java17V1 {
    public static void main(String[] args) {
        BankAccount myAccount = new SavingsAccount();

        // Java 17 Switch Expression benefit: 
        // The compiler knows only 3 types of BankAccount exist.
        String description = switch (myAccount) {
            case SavingsAccount s  -> "Savings with " + s.interestRate + " interest.";
            case CheckingAccount c -> "Checking with " + c.limit + " limit.";
            case CreditAccount cr  -> "Credit account currently at " + cr.balance;
             default -> "default";
            // No default case needed if all permitted types are covered!
        };

        System.out.println(description);
    }
}