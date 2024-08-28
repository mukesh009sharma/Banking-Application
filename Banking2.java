package Application;
import java.util.Scanner;

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
        } else {
            System.out.println("Insufficient balance to withdraw $" + amount + " including transaction fee.");
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
} class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Good morning! Welcome to the bank.");
        System.out.println("Enter transaction details:");
        SavingsAccount savings = new SavingsAccount(1000, 0.05);
        CheckingAccount checking = new CheckingAccount(500);

        System.out.print("Deposit to Savings Account: $");
        double savingsDeposit = scanner.nextDouble();
        savings.deposit(savingsDeposit);

        System.out.print("Withdraw from Savings Account: $");
        double savingsWithdraw = scanner.nextDouble();
        savings.withdraw(savingsWithdraw);

        savings.addInterest();

        System.out.print("Deposit to Checking Account: $");
        double checkingDeposit = scanner.nextDouble();
        checking.deposit(checkingDeposit);

        System.out.print("Withdraw from Checking Account: $");
        double checkingWithdraw = scanner.nextDouble();
        checking.withdraw(checkingWithdraw);

        System.out.println("\nFinal balances:");
        System.out.println("Savings Account Balance: $" + savings.getBalance());
        System.out.println("Checking Account Balance: $" + checking.getBalance());

        System.out.println("\nThank you for banking with us. Have a great day!");
        System.out.println("hello");
        scanner.close();}

    }