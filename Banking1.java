// Define the Account interface
package Application;
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// Abstract class BankAccount that implements Account
abstract class BankAccount implements Account {
    protected double balance;

    protected BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

  
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }


    public double getBalance() {
        return balance;
    }
}

// SavingsAccount class that extends BankAccount
class SavingsAccount extends BankAccount {
    private final double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }
}

// CheckingAccount class that extends BankAccount
class CheckingAccount extends BankAccount {
    private static final double TRANSACTION_FEE = 1.0;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount + TRANSACTION_FEE <= balance) {
            balance -= (amount + TRANSACTION_FEE);
        }
    }
}

// Main program to demonstrate functionality
public class Banking1 {
    public static void main(String[] args) {
        // Create SavingsAccount and CheckingAccount instances
        SavingsAccount savings = new SavingsAccount(1000, 0.05);
        CheckingAccount checking = new CheckingAccount(1000);

        // Perform deposits
        savings.deposit(500);
        checking.deposit(500);

        // Perform withdrawals
        savings.withdraw(200);
        checking.withdraw(200);

        // Add interest to savings account
        savings.addInterest();

        // Display final balances
        System.out.println("Savings Account Balance: " + savings.getBalance());
        System.out.println("Checking Account Balance: " + checking.getBalance());
    }
}
