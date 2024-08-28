package Application;
 interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
abstract class BankAccount implements Account {
    protected double balance;

    protected BankAccount(double balance) {
        this.balance = balance;
    }

  
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    
    public void withdraw(double amount) {
        double fee = getTransactionFee();
        if (amount + fee <= balance) {
            balance -= (amount + fee);
        }
    }

    protected abstract double getTransactionFee();

 
    public double getBalance() {
        return balance;
    }
}
 class SavingsAccount extends BankAccount {
    private final double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }

 
    protected double getTransactionFee() {
        return 0.0;
    }
}
 class CheckingAccount extends BankAccount {
    private static final double TRANSACTION_FEE = 1.00;

    public CheckingAccount(double balance) {
        super(balance);
    }


    protected double getTransactionFee() {
        return TRANSACTION_FEE;
    }
}
public class Banking {
    public static void main(String[] args) {
		System.out.println("Welcome to Bank..............");
        SavingsAccount savings = new SavingsAccount(1000, 0.05);
        CheckingAccount checking = new CheckingAccount(500);

		System.out.println("\nPerforming transactions on Savings Account:");
        savings.deposit(200);
        savings.addInterest();
        savings.withdraw(100);

        System.out.println("\nPerforming transactions on Checking Account:");
        checking.deposit(300);
        checking.withdraw(200);
        checking.withdraw(50);

        // Display final balances
        System.out.println("\nFinal balances:");
        System.out.println("Savings Account Balance: $" + savings.getBalance());
        System.out.println("Checking Account Balance: $" + checking.getBalance());

        System.out.println("\nThank you for banking with us. Have a great day!");
    }
}